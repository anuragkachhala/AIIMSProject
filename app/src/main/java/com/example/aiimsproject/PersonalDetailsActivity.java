package com.example.aiimsproject;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.aiimsproject.Model.Download;
import com.example.aiimsproject.Model.RegistrationRequest;
import com.example.aiimsproject.RestApi.ApiClient;
import com.example.aiimsproject.RestApi.ApiInterface;
import com.example.aiimsproject.Service.DownloadPDFServices;
import com.example.aiimsproject.Utils.DialogUtitlity;
import com.example.aiimsproject.Utils.MoneyTextWatcher;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.aiimsproject.Utils.ValidationUtil.DateToLong;
import static com.example.aiimsproject.Utils.ValidationUtil.removeExtraSpace;
import static com.example.aiimsproject.Utils.ValidationUtil.stringFormatIn2Digit;
import static com.example.aiimsproject.Utils.ValidationUtil.validateEmail;
import static com.example.aiimsproject.Utils.ValidationUtil.validateMobile;
import static com.example.aiimsproject.Utils.ValidationUtil.validateName;

public class PersonalDetailsActivity extends FormRegistrationActivity implements Callback<String> {
    public static final String TAG = PersonalDetailsActivity.class.getName();
    public static final String MESSAGE_PROGRESS = "message_progress";
    private static final int PERMISSION_REQUEST_CODE = 1;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.layoutName)
    TextInputLayout layoutName;
    @BindView(R.id.et_applicant_name)
    TextInputEditText etApplicantName;
    @BindView(R.id.layoutFatherName)
    TextInputLayout layoutFatherName;
    @BindView(R.id.et_applicant_father_name)
    TextInputEditText etApplicantFatherName;
    @BindView(R.id.layoutMotherName)
    TextInputLayout layoutMotherName;
    @BindView(R.id.et_applicant_mother_name)
    TextInputEditText etApplicantMotherName;
    @BindView(R.id.tv_applicant_dob)
    TextView tvApplicantDOB;
    @BindView(R.id.layoutDesignation)
    TextInputLayout layoutDesignation;
    @BindView(R.id.et_designation)
    TextInputEditText etDesignation;
    @BindView(R.id.layoutDepartment)
    TextInputLayout layoutDepartment;
    @BindView(R.id.et_department)
    TextInputEditText etDepartment;
    @BindView(R.id.layoutGradePay)
    TextInputLayout layoutGradePay;
    @BindView(R.id.et_grade_pay)
    TextInputEditText etGradPay;
    @BindView(R.id.tv_date_of_joining)
    TextView tvDateOfJoining;
    @BindView(R.id.layoutPresentAddress)
    TextInputLayout layoutPresentAddress;
    @BindView(R.id.et_present_address)
    TextInputEditText etPresentAddress;
    @BindView(R.id.layoutPermanentAddress)
    TextInputLayout layoutPermanentAddress;
    @BindView(R.id.et_permanent_address)
    TextInputEditText etPermanentAddress;
    @BindView(R.id.layoutBodyIdentyMark)
    TextInputLayout layoutBodyIdentyMark;
    @BindView(R.id.et_body_identy_mark)
    TextInputEditText etBodyIdentyMark;
    @BindView(R.id.sp_blood_group)
    AppCompatSpinner spBloodGroup;
    @BindView(R.id.layoutMobileNo)
    TextInputLayout layoutMobileNo;
    @BindView(R.id.et_mobile_no)
    TextInputEditText etMobileNo;
    @BindView(R.id.layoutLandlineNo)
    TextInputLayout layoutLandlineNo;
    @BindView(R.id.et_landline_no)
    TextInputEditText etLandlineNo;
    @BindView(R.id.layoutEmergencyContact)
    TextInputLayout layoutEmergencyContact;
    @BindView(R.id.et_emergency_contact)
    TextInputEditText etEmergencyContact;
    @BindView(R.id.layoutEmailID)
    TextInputLayout layoutEmailID;
    @BindView(R.id.et_email_id)
    TextInputEditText etEmailID;
    @BindView(R.id.sp_employment_type)
    AppCompatSpinner spEmploymentType;
    @BindView(R.id.layoutProjectName)
    TextInputLayout layoutProjectName;
    @BindView(R.id.et_project_name)
    TextInputEditText etProjectName;

    @BindView(R.id.tv_error_dob)
    TextView textViewDobError;
    @BindView(R.id.layoutIfYesSelect)
    TextInputLayout layoutIfYesSelect;
    @BindView(R.id.et_if_yes_select)
    TextInputEditText etIfYesWriteReason;
    @BindView(R.id.btn_save_personal_details)
    Button btnSavePersonalDetails;
    @BindView(R.id.tv_error_doj)
    TextView textViewErrorDOJ;
    @BindView(R.id.tv_applicant_tenure)
    TextView textViewApplicantTenure;

    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.layout)
    LinearLayout linearLayout;
    @BindView(R.id.tv_error_employee_type)
    TextView textViewErrorEmploymentType;

    @BindView(R.id.checkbox_address)
    CheckBox checkBoxAddress;

    @BindView(R.id.tv_error_tenure)
    TextView textViewErrorTenure;

    @BindView(R.id.layoutOtherEmpType)
    TextInputLayout inputLayoutEmpType;

    @BindView(R.id.et_OtherEmpType)
    TextInputEditText etOtherEmpType;
    String[] employeeTypeList;
    private int employmentTypePosition = 0;
    private int mYear, mMonth, mDay;
    private RegistrationRequest registrationRequest;
    private String employeeType;
    private Long personalDetailID = null;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(MESSAGE_PROGRESS)) {

                Download download = intent.getParcelableExtra("download");
                //mProgressBar.setProgress(download.getProgress());

                if (download.getProgress() == 100) {
                    progressBar.setVisibility(View.GONE);

                } else {


                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        registerReceiver();
        setListener();
        setEmployeeSpinner();
        downloadPDF();

    }


    private void startDownload() {

        Intent intent = new Intent(this, DownloadPDFServices.class);
        intent.putExtra("id", /*personalDetailID*/1552042658089L);
        startService(intent);

    }


    @Override
    protected void setListener() {
        super.setListener();
        btnSavePersonalDetails.setOnClickListener(this);
        spEmploymentType.setOnItemSelectedListener(this);
        tvDateOfJoining.setOnClickListener(this);
        textViewApplicantTenure.setOnClickListener(this);
        etGradPay.addTextChangedListener(new MoneyTextWatcher(etGradPay));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_personal_details;
    }

    @Override
    protected String getToolBarTitle() {
        return getResources().getString(R.string.toolbar_title_employee_reg);
    }

    @Override
    protected void startActivity(Class<?> cls) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_save_personal_details:
                if (checkValidation()) {
                    setPersonalDetailsData();

                }
                break;
            case R.id.tv_applicant_dob:
                openCalenderDOB();
                break;
            case R.id.tv_date_of_joining:
                openCalenderDateOfJoining();
                break;
            case R.id.tv_applicant_tenure:
                showCallDurationDialog();
                break;
        }
    }

    private void setPersonalDetailsData() {
        personalDetailID = System.currentTimeMillis();
        registrationRequest = new RegistrationRequest();
        registrationRequest.setName(removeExtraSpace(getValue(etApplicantName)));
        registrationRequest.setFatherName(removeExtraSpace(getValue(etApplicantFatherName)));
        registrationRequest.setMotherName(removeExtraSpace(getValue(etApplicantMotherName)));
        registrationRequest.setDob(DateToLong(tvApplicantDOB.getText().toString().trim()));
        registrationRequest.setBloodGroup(bloodGroup);
        registrationRequest.setBodyIdMark(removeExtraSpace(getValue(etBodyIdentyMark)));
        registrationRequest.setDateOfJoining(DateToLong(tvDateOfJoining.getText().toString().trim()));
        registrationRequest.setDepartment(removeExtraSpace(getValue(etDepartment)));
        registrationRequest.setDesignation(removeExtraSpace(getValue(etDesignation)));
        registrationRequest.setEmailId(getValue(etEmailID));
        registrationRequest.setEmergencyContactNo(getValue(etEmergencyContact));
        registrationRequest.setId(personalDetailID);
        if (employmentTypePosition == 7) {
            employeeType = getValue(etOtherEmpType);
        }
        registrationRequest.setEmployeementType(removeExtraSpace(employeeType));
        registrationRequest.setGradePay(getValue(etGradPay));
        registrationRequest.setLandLineNO(getValue(etLandlineNo));
        registrationRequest.setMobileNo(getValue(etMobileNo));
        registrationRequest.setPermanentAddress(removeExtraSpace(getValue(etPermanentAddress)));
        registrationRequest.setPresentAddress(removeExtraSpace(getValue(etPresentAddress)));
        registrationRequest.setProjectName(removeExtraSpace(getValue(etProjectName)));
        registrationRequest.setRecievedId(receivedId);
        registrationRequest.setTenure(textViewApplicantTenure.getText().toString());
        registrationRequest.setReason(removeExtraSpace(getValue(etIfYesWriteReason)));
        registrationRequest.setFather(isFather);
        employeeRequestToServer();

    }

    private void employeeRequestToServer() {
        DialogUtitlity.showLoading(this);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<String> callClient = apiService.employeeRegistration(registrationRequest);
        callClient.enqueue(this);
    }

    @Override
    protected boolean checkValidation() {
        if (textInputLayoutError != null) {
            textInputLayoutError.setError(null);

        }
        if (textViewError != null) {
            textViewError.setVisibility(View.GONE);
        }
        if (checkEmpty(etApplicantName)) {
            setError(etApplicantName, layoutName, getResources().getString(R.string.name_error));
            return false;
        }
        if (!validateName(getValue(etApplicantName), 3)) {
            setError(etApplicantName, layoutName, getResources().getString(R.string.name_length_error));
            return false;
        }
        if (checkEmpty(etApplicantFatherName)) {
            setError(etApplicantFatherName, layoutFatherName, getResources().getString(R.string.father_name_error));
            return false;
        }
        if (!validateName(getValue(etApplicantFatherName), 3)) {
            setError(etApplicantFatherName, layoutFatherName, getResources().getString(R.string.father_name_length_error));
            return false;
        }
        if (checkEmpty(etApplicantMotherName)) {
            setError(etApplicantMotherName, layoutMotherName, getResources().getString(R.string.mother_name_error));
            return false;
        }
        if (!validateName(getValue(etApplicantMotherName), 3)) {
            setError(etApplicantMotherName, layoutMotherName, getResources().getString(R.string.mother_name_length_error));
            return false;
        }
        if (tvApplicantDOB.getText().toString().isEmpty()) {
            textViewDobError.setVisibility(View.VISIBLE);
            textViewError = textViewDobError;
            return false;
        }
        if (checkEmpty(etDesignation)) {
            setError(etDesignation, layoutDesignation, getResources().getString(R.string.designation_error));
            return false;
        }

        if (checkEmpty(etGradPay)) {
            setError(etGradPay, layoutGradePay, getResources().getString(R.string.grade_pay_error));
            return false;
        }
        if (checkEmpty(etDepartment)) {
            setError(etDepartment, layoutDepartment, getResources().getString(R.string.department_error));
            return false;
        }
        if (tvDateOfJoining.getText().toString().isEmpty()) {
            textViewErrorDOJ.setVisibility(View.VISIBLE);
            textViewError = textViewErrorDOJ;
            return false;
        }
        if (checkEmpty(etPresentAddress)) {
            setError(etPresentAddress, layoutPresentAddress, getResources().getString(R.string.present_address_error));
            return false;
        }
        if (checkEmpty(etPermanentAddress)) {
            setError(etPermanentAddress, layoutPermanentAddress, getResources().getString(R.string.permanent_address_erro));
            return false;
        }
        if (checkEmpty(etBodyIdentyMark)) {
            setError(etBodyIdentyMark, layoutBodyIdentyMark, getResources().getString(R.string.body_identy_mark_error));
            return false;
        }
        if (checkEmpty(etMobileNo)) {
            setError(etMobileNo, layoutMobileNo, getResources().getString(R.string.mobile_no_error));
            return false;
        }
        if (!validateMobile(getValue(etMobileNo))) {
            setError(etMobileNo, layoutMobileNo, getResources().getString(R.string.mobile_no_valid));
            return false;
        }

        /*if (checkEmpty(etLandlineNo)) {
            setError(etLandlineNo, layoutLandlineNo, getResources().getString(R.string.landline_no_error));
            return false;
        }*/
        if (!checkEmpty(etLandlineNo) && !validateMobile(getValue(etLandlineNo))) {
            setError(etLandlineNo, layoutLandlineNo, getResources().getString(R.string.landline_no_valid));
            return false;
        }
        if (checkEmpty(etEmergencyContact)) {
            setError(etEmergencyContact, layoutEmergencyContact, getResources().getString(R.string.emergency_contact_error));
            return false;
        }
        if (!validateMobile(getValue(etEmergencyContact))) {
            setError(etEmergencyContact, layoutEmergencyContact, getResources().getString(R.string.emergency_contact_valid));
            return false;
        }
        if (checkEmpty(etEmailID)) {
            setError(etEmailID, layoutEmailID, getResources().getString(R.string.email_error));
            return false;
        }
        if (!validateEmail(getValue(etEmailID))) {
            setError(etEmailID, layoutEmailID, getResources().getString(R.string.valid_email_address));
            return false;
        }
        if (employmentTypePosition <= 0) {
            textViewErrorEmploymentType.setVisibility(View.VISIBLE);
            textViewError = textViewErrorEmploymentType;
            return false;
        }
        if (employmentTypePosition == 7 && checkEmpty(etOtherEmpType)) {
            setError(etOtherEmpType, inputLayoutEmpType, "Please Enter Employment Type");
            return false;
        }

        if (checkEmpty(etProjectName)) {
            setError(etProjectName, layoutProjectName, getResources().getString(R.string.project_name_error));
            return false;
        }
        if (!checkEmpty(etProjectName) && textViewApplicantTenure.getText().toString().trim().isEmpty()) {
            textViewErrorTenure.setVisibility(View.VISIBLE);
            textViewError = textViewErrorTenure;
            return false;
        }
        /*if (checkEmpty(etTenure)) {
            setError(etTenure,layoutTenure,layoutProjectName,getResources().getString(R.string.tenure_error));
           *//* layoutTenure.setError(getResources().getString(R.string.tenure_error));
            layoutProjectName.setError(null);*//*
            return false;
        }
        if (checkEmpty(etIfYesWriteReason)) {
            setError(etIfYesWriteReason,layoutIfYesSelect,layoutTenure,getResources().getString(R.string.if_yes_select_error));
            *//*layoutIfYesSelect.setError(getResources().getString(R.string.if_yes_select_error));
            layoutTenure.setError(null);*//*
            layoutIfYesSelect.setError(null);
            return false;
        }*/
        if (receivedId && checkEmpty(etIfYesWriteReason)) {
            setError(etIfYesWriteReason, layoutIfYesSelect, "Please Enter Reason");
            return false;
        }
        //clearForm(linearLayout);

        return true;

    }


    public void openCalenderDateOfJoining() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker dateView, int year, int monthOfYear, int dayOfMonth) {
                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                tvDateOfJoining.setText(date);
                //tvDateOfJoining.setText(date);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    public void setEmployeeSpinner() {
        employeeTypeList = getResources().getStringArray(R.array.employment_type);
        spEmploymentType.setAdapter(SpinnerManager.setSpinner(this, employeeTypeList));
    }


    @Override
    protected String getFormHeading() {
        return getResources().getString(R.string.details_card);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (adapterView.getId()) {
            case R.id.sp_blood_group:
                bloodGroup = bloodGroupList[position];
                break;
            case R.id.sp_employment_type:
                employeeType = employeeTypeList[position];
                employmentTypePosition = position;
                Log.e("Position", "" + employmentTypePosition);
                if (position == 7) {
                    employmentTypePosition = position;
                    inputLayoutEmpType.setVisibility(View.VISIBLE);
                } else {
                    inputLayoutEmpType.setVisibility(View.GONE);
                }

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void showCallDurationDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View tenureView = inflater.inflate(R.layout.layout_call_duration, null);
        final NumberPicker noPickerYear = (NumberPicker) tenureView.findViewById(R.id.number_picker_hr);
        final NumberPicker noPickerMonth = (NumberPicker) tenureView.findViewById(R.id.number_picker_min);
        final NumberPicker noPickerDay = (NumberPicker) tenureView.findViewById(R.id.number_picker_sec);
        setMaxMinValue(noPickerYear, 12, 0);
        setMaxMinValue(noPickerMonth, 12, 0);
        setMaxMinValue(noPickerDay, 31, 0);
        noPickerYear.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        noPickerYear.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return stringFormatIn2Digit(i);
            }
        });


        noPickerMonth.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        noPickerMonth.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return stringFormatIn2Digit(i);
            }
        });


        noPickerDay.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        noPickerDay.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return stringFormatIn2Digit(i);
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(tenureView);
        alert.setCancelable(false);

        alert.setPositiveButton("SET", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


                textViewApplicantTenure.setText(checkTenureValue(noPickerYear.getValue(), noPickerMonth.getValue(), noPickerDay.getValue()));
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();


    }

    private StringBuilder checkTenureValue(int years, int months, int days) {
        StringBuilder tenure = new StringBuilder();
        if (years != 0) {
            tenure.append(years).append(" Year ");
        }
        if (months != 0) {
            tenure.append(months).append(" Month ");
        }
        if (days != 0) {
            tenure.append(days).append(" Day ");
        }

        return tenure;
    }


    private void setMaxMinValue(NumberPicker numberPicker, int maxValue, int minValue) {
        numberPicker.setMaxValue(maxValue);
        numberPicker.setMinValue(minValue);
    }



    protected void downloadPDF() {

        if (checkPermission()) {
            startDownload();

        } else {
            requestPermission();
        }
    }

    private void registerReceiver() {

        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MESSAGE_PROGRESS);
        bManager.registerReceiver(broadcastReceiver, intentFilter);

    }


    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        DialogUtitlity.hideLoading();
        switch (response.code()) {

            case 201: {
                showToast("details have been saved");
                clearForm1(linearLayout);
                //downloadPDF();
                break;

            }
            case 403: {
                showToast("Problem at server site");
            }
        }


    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        DialogUtitlity.hideLoading();
        showToast(t.toString());

    }


    private void clearForm1(LinearLayout linearLayout) {
        super.clearForm(linearLayout);
        spEmploymentType.setSelection(0);

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
        switch (checkId) {
            case R.id.radio_father:
                layoutFatherName.setHint(fatherName);
                isFather = true;
                break;
            case R.id.radio_husband:
                layoutFatherName.setHint(husbandName);
                isFather = false;
                break;
            case R.id.radio_yes:
                layoutIfYesSelect.setVisibility(View.VISIBLE);
                receivedId = true;
                break;
            case R.id.radio_no:
                layoutIfYesSelect.setVisibility(View.GONE);
                receivedId = false;
                break;
        }


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        String text = isChecked ? !checkEmpty(etPresentAddress) ? getValue(etPresentAddress) : null : null;
        etPermanentAddress.setText(text);
    }
}

