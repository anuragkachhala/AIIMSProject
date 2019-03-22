package com.example.aiimsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.example.aiimsproject.Model.RegistrationRequest;
import com.example.aiimsproject.Model.UpdateStatus;
import com.example.aiimsproject.Utils.EmployeeListSingleton;
import com.example.aiimsproject.Utils.ValidationUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeDetailActivity extends BaseActivity{
    private static final String TAG = EmployeeDetailActivity.class.getName();


    @BindView(R.id.tv_employee_name)
    TextView textViewEmplyeeName;

    @BindView(R.id.tv_employee_father)
    TextView textViewFatherName;

    @BindView(R.id.tv_employee_mother_name)
    TextView textViewMotherName;

    @BindView(R.id.tv_employee_designation)
    TextView textViewDesignation;

    @BindView(R.id.tv_employee_department)
    TextView textViewEmployeeDepartment;

    @BindView(R.id.tv_employee_grade_pay)
    TextView textViewEmployeeGradePay;

    @BindView(R.id.tv_employee_blood_group)
    TextView textViewBloodGroup;

    @BindView(R.id.tv_employee_type)
    TextView textViewEmployeeType;

    @BindView(R.id.tv_employee_dob)
    TextView textViewEmployeeDob;

    @BindView(R.id.tv_employee_doj)
    TextView textViewEmployeeDoj;

    @BindView(R.id.tv_employee_body)
    TextView textViewBodyMark;

    @BindView(R.id.tv_employee_contact)
    TextView textViewContact;

    @BindView(R.id.tv_employee_landLine_no)
    TextView textViewEmployeeLandLineNo;

    @BindView(R.id.tv_employee_emergency_no)
    TextView textViewEmployeeEmergencyNo;

    @BindView(R.id.tv_employee_parment_add)
    TextView textViewEmployeeParmentAdd;

    @BindView(R.id.tv_employee_present_add)
    TextView textViewEmployeePresentAdd;

    @BindView(R.id.tv_employee_email_di)
    TextView textViewEmailId;

    @BindView(R.id.tv_label_father_name)
    TextView textViewLabelFatherName;

    private RegistrationRequest registrationRequest;
    private EmployeeListSingleton employeeListSingleton;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        employeeListSingleton = EmployeeListSingleton.getInstance();
        intent = getIntent();
        int position = intent.getIntExtra("POSITION",-1);
        registrationRequest = employeeListSingleton.getRegistrationRequest(position);


        showEmployeeDetails();

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void setResources() {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_employeee_detail;
    }

    @Override
    protected String getToolBarTitle() {
        return getResources().getString(R.string.toolbar_title_employee_details);
    }

    @Override
    protected void startActivity(Class<?> cls) {

    }

    private void showEmployeeDetails() {
        textViewEmplyeeName.setText(registrationRequest.getName());
        if(!registrationRequest.isFather()){
            textViewLabelFatherName.setText(getResources().getString(R.string.label_reg_applicant_husband_name));
        }
        textViewFatherName.setText(registrationRequest.getFatherName());
        textViewMotherName.setText(registrationRequest.getMotherName());
        textViewDesignation.setText(registrationRequest.getDesignation());
        textViewEmployeeDepartment.setText(registrationRequest.getDepartment());
        textViewEmployeeGradePay.setText(registrationRequest.getGradePay());
        textViewBloodGroup.setText(registrationRequest.getBloodGroup());
        textViewEmployeeType.setText(registrationRequest.getEmployeementType());
        textViewEmployeeDob.setText(ValidationUtil.longToDate(registrationRequest.getDob()));
        textViewEmployeeDoj.setText(ValidationUtil.longToDate(registrationRequest.getDateOfJoining()));
        textViewBodyMark.setText(registrationRequest.getBodyIdMark());
        textViewContact.setText(registrationRequest.getEmergencyContactNo());
        textViewEmployeeLandLineNo.setText(registrationRequest.getLandLineNO());
        textViewEmployeeEmergencyNo.setText(registrationRequest.getEmergencyContactNo());
        textViewEmployeeParmentAdd.setText(registrationRequest.getPermanentAddress());
        textViewEmployeePresentAdd.setText(registrationRequest.getPresentAddress());
        textViewEmailId.setText(registrationRequest.getEmailId());




    }



}
