package com.example.aiimsproject;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiimsproject.Service.DownloadPDFServices;
import com.example.aiimsproject.Utils.ConnectivityReceiver;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class FormRegistrationActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    public static final String MESSAGE_PROGRESS = "message_progress";
    private static final int PERMISSION_REQUEST_CODE = 1;


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
    @BindView(R.id.sp_blood_group)
    AppCompatSpinner spBloodGroup;
    @BindView(R.id.title)
    TextView textViewTitle;

    @BindView(R.id.rg_received_id)
    RadioGroup rgReceivedID;
    @BindView(R.id.rg_father_husband)
    RadioGroup rgFatherHusband;
    @BindView(R.id.checkbox_address)
    CheckBox checkBoxAddress;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    protected String[] bloodGroupList;
    protected String bloodGroup,fatherName,husbandName;
    protected boolean receivedId,isFather;
    protected TextInputLayout textInputLayoutError;
    protected  TextView textViewError;
    private int mYear, mDay,mMonth;
    protected Long personalDetailID = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);

        setBloodGroupSpinner();

        setResources();
        setFormHeading();
        downloadPDF();




        }

   @Override
    protected  void setListener(){
        tvApplicantDOB.setOnClickListener(this);
        //radio button....
        rgFatherHusband.setOnCheckedChangeListener(this);
        rgReceivedID.setOnCheckedChangeListener(this);
        //spinner listener
        spBloodGroup.setOnItemSelectedListener(this);
        // checkbox listener...
        checkBoxAddress.setOnCheckedChangeListener(this);
    }






    private void setBloodGroupSpinner()
    {
        bloodGroupList = getResources().getStringArray(R.array.blood_group);
        spBloodGroup.setAdapter(SpinnerManager.setSpinner(this, bloodGroupList));
    }

    @Override
    protected void setResources(){

        fatherName = getResources().getString(R.string.label_reg_applicant_father_name);
        husbandName = getResources().getString(R.string.label_reg_applicant_husband_name);
        layoutFatherName.setHint(fatherName);

    }

    protected abstract String getFormHeading();

    private void setFormHeading(){
        String formHeading = getFormHeading();
        SpannableString content = new SpannableString(formHeading);
        content.setSpan(new UnderlineSpan(), 0, formHeading.length(), 0);
        textViewTitle.setText(content);
    }

    /*protected void setRadioGroupListener(){
        rgFatherHusband.setOnCheckedChangeListener(this);
        rgReceivedID.setOnCheckedChangeListener(this);
    }*/

    protected void setError(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String errorMsg) {
        textInputEditText.requestFocus();
        textInputLayout.setError(errorMsg);
        textInputLayoutError = textInputLayout;


    }

    protected boolean checkEmpty(TextInputEditText textInputEditText) {
         return getValue(textInputEditText).isEmpty();
         }

    protected String getValue(TextInputEditText textInputEditText) {
        return textInputEditText.getText().toString().trim();
    }

    protected abstract boolean checkValidation();


    protected void openCalenderDOB() {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker dateView, int year, int monthOfYear, int dayOfMonth) {
                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                tvApplicantDOB.setText(date);
            }

        }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    protected void clearForm(LinearLayout linearLayout) {
        int count = linearLayout.getChildCount();
        for (int i = 0; i < count; ++i) {

            View view = linearLayout.getChildAt(i);
            if (view instanceof TextInputLayout) {
                View view1 = ((TextInputLayout) view).getEditText();
                if (view1 instanceof TextInputEditText) {
                    ((TextInputEditText) view1).getText().clear();
                }
            }
            if (view instanceof RelativeLayout) {
                View view2 = ((RelativeLayout) view).getChildAt(0);
                if (view2 instanceof TextView) {
                    ((TextView) view2).setText("");
                }
            }

        }
        spBloodGroup.setSelection(0);


    }


    protected boolean checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        if (!isConnected) {

            //showSnack(isConnected);
            return false;
        }

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_get_pdf:
                if (personalDetailID != null) {
                    if (checkConnection()) {
                        downloadPDF();
                    } else {
                        showToast(getResources().getString(R.string.msg_check_connection));

                    }
                } else {
                    showToast("Please fill form ");
                }

                break;


        }

        return super.onOptionsItemSelected(item);


    }




    protected boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            progressBar.setVisibility(View.VISIBLE);
            return true;

        } else {

            return false;
        }


    }


    protected void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);

    }



    protected abstract void downloadPDF();


}
