package com.example.aiimsproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.aiimsproject.Model.Download;
import com.example.aiimsproject.Service.DownloadPDFServices;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.aiimsproject.Utils.ValidationUtil.validateEmail;
import static com.example.aiimsproject.Utils.ValidationUtil.validateMobile;
import static com.example.aiimsproject.Utils.ValidationUtil.validateName;

public class StudentRegActivity extends FormRegistrationActivity {

    public static final String TAG = StudentRegActivity.class.getName();


    @BindView(R.id.layoutSpeciality)
    TextInputLayout layoutSpeciality;
    @BindView(R.id.et_speciality)
    TextInputEditText etSpeciality;

    @BindView(R.id.layoutRollNo)
    TextInputLayout textInputLayoutRollNo;

    @BindView(R.id.et_roll_no)
    TextInputEditText etRollNo;

    @BindView(R.id.layoutRegistrationNo)
    TextInputLayout textInputLayoutRegNo;

    @BindView(R.id.et_registration_no)
    TextInputEditText etRegNo;

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
    @BindView(R.id.sp_course_name)
    AppCompatSpinner spCourseName;
    @BindView(R.id.tv_error_dob)
    TextView textViewDobError;
    @BindView(R.id.layoutIfYesSelect)
    TextInputLayout layoutIfYesSelect;
    @BindView(R.id.et_if_yes_select)
    TextInputEditText etIfYesWriteReason;
    @BindView(R.id.btn_save_personal_details)
    Button btnSavePersonalDetails;

    @BindView(R.id.radioGroup_pg)
    RadioGroup radioGroupPG;


    @BindView(R.id.tv_error_course_name)
    TextView textViewErrorCourseName;

    @BindView(R.id.layout)
    LinearLayout linearLayout;
    private String[] courseNameList;
    private boolean isPostGraduated;


    private String  courseName, title,speciality;
    private int courseNamePosition =0;


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
        setListener();
        setCourseSpinner();




    }



    protected void downloadPDF() {

        if (checkPermission()) {
            startDownload();

        } else {
            requestPermission();
        }
    }


    private void startDownload() {

        Intent intent = new Intent(this, DownloadPDFServices.class);
        intent.putExtra("id", /*personalDetailID*/ 1552042658089L);
        startService(intent);

    }


    @Override
    protected void setListener() {
        super.setListener();
        btnSavePersonalDetails.setOnClickListener(this);
        spCourseName.setOnItemSelectedListener(this);
        radioGroupPG.setOnCheckedChangeListener(this);
    }

    private void setCourseSpinner(){
        courseNameList = getResources().getStringArray(R.array.course_name);
        spCourseName.setAdapter(SpinnerManager.setSpinner(this, courseNameList));
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_student_reg;
    }

    @Override
    protected String getToolBarTitle() {
        return getResources().getString(R.string.toolbar_title_student_reg);
    }

    @Override
    protected void startActivity(Class<?> cls) {

    }

    @Override
    protected String getFormHeading() {
        return getResources().getString(R.string.form_heading_student);
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
        }if(courseNamePosition<=0){
            textViewErrorCourseName.setVisibility(View.VISIBLE);
            textViewError = textViewErrorCourseName;
            return false;
        }if(isPostGraduated && checkEmpty(etSpeciality)){
            setError(etSpeciality, layoutSpeciality, getResources().getString(R.string.err_speciality));
            return false;
        }if(checkEmpty(etRollNo)){
            setError(etRollNo, textInputLayoutRollNo, getResources().getString(R.string.err_roll_no));
            return false;
        }
        if(checkEmpty(etRegNo)){
            setError(etRegNo, textInputLayoutRegNo, getResources().getString(R.string.err_registration_no));
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
        if ( ! checkEmpty(etLandlineNo) && !validateMobile(getValue(etLandlineNo))) {
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
        } if (!validateEmail(getValue(etEmailID))) {
            setError(etEmailID, layoutEmailID, getResources().getString(R.string.valid_email_address));
            return false;
        }

        if (receivedId && checkEmpty(etIfYesWriteReason)) {
            setError(etIfYesWriteReason, layoutIfYesSelect, "Please Enter Reason");
            return false;
        }
        return true;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save_personal_details:
                if (checkValidation()) {
                    setStudentDetails();
                }
                break;
            case R.id.tv_applicant_dob:
                openCalenderDOB();
                break;

        }
    }

    private void setStudentDetails() {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        switch (adapterView.getId()) {
            case R.id.sp_blood_group:
                bloodGroup = bloodGroupList[position];
                 break;
            case R.id.sp_course_name:
                courseName = courseNameList[position];
                courseNamePosition =position;
                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
        switch (checkId) {
            case R.id.radio_yes:
                layoutIfYesSelect.setVisibility(View.VISIBLE);
                receivedId = true;
                break;
            case R.id.radio_no:
                layoutIfYesSelect.setVisibility(View.GONE);
                receivedId = false;
                break;
            case R.id.radio_father:
                layoutFatherName.setHint(fatherName);
                isFather = true;
                break;
            case R.id.radio_husband:
                layoutFatherName.setHint(husbandName);
                isFather = false;
                break;
            case R.id.radio_yes_pg:
                layoutSpeciality.setVisibility(View.VISIBLE);
                isPostGraduated =true;
                break;
            case R.id.radio_no_pg:
                layoutSpeciality.setVisibility(View.GONE);
                isPostGraduated = false;
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
    String text  =  isChecked ? !checkEmpty(etPresentAddress) ? getValue(etPresentAddress):null:null;
    etPermanentAddress.setText(text);
    }
}
