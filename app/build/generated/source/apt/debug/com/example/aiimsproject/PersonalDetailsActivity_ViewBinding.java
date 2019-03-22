// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalDetailsActivity_ViewBinding extends FormRegistrationActivity_ViewBinding {
  private PersonalDetailsActivity target;

  @UiThread
  public PersonalDetailsActivity_ViewBinding(PersonalDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonalDetailsActivity_ViewBinding(PersonalDetailsActivity target, View source) {
    super(target, source);

    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.layoutName = Utils.findRequiredViewAsType(source, R.id.layoutName, "field 'layoutName'", TextInputLayout.class);
    target.etApplicantName = Utils.findRequiredViewAsType(source, R.id.et_applicant_name, "field 'etApplicantName'", TextInputEditText.class);
    target.layoutFatherName = Utils.findRequiredViewAsType(source, R.id.layoutFatherName, "field 'layoutFatherName'", TextInputLayout.class);
    target.etApplicantFatherName = Utils.findRequiredViewAsType(source, R.id.et_applicant_father_name, "field 'etApplicantFatherName'", TextInputEditText.class);
    target.layoutMotherName = Utils.findRequiredViewAsType(source, R.id.layoutMotherName, "field 'layoutMotherName'", TextInputLayout.class);
    target.etApplicantMotherName = Utils.findRequiredViewAsType(source, R.id.et_applicant_mother_name, "field 'etApplicantMotherName'", TextInputEditText.class);
    target.tvApplicantDOB = Utils.findRequiredViewAsType(source, R.id.tv_applicant_dob, "field 'tvApplicantDOB'", TextView.class);
    target.layoutDesignation = Utils.findRequiredViewAsType(source, R.id.layoutDesignation, "field 'layoutDesignation'", TextInputLayout.class);
    target.etDesignation = Utils.findRequiredViewAsType(source, R.id.et_designation, "field 'etDesignation'", TextInputEditText.class);
    target.layoutDepartment = Utils.findRequiredViewAsType(source, R.id.layoutDepartment, "field 'layoutDepartment'", TextInputLayout.class);
    target.etDepartment = Utils.findRequiredViewAsType(source, R.id.et_department, "field 'etDepartment'", TextInputEditText.class);
    target.layoutGradePay = Utils.findRequiredViewAsType(source, R.id.layoutGradePay, "field 'layoutGradePay'", TextInputLayout.class);
    target.etGradPay = Utils.findRequiredViewAsType(source, R.id.et_grade_pay, "field 'etGradPay'", TextInputEditText.class);
    target.tvDateOfJoining = Utils.findRequiredViewAsType(source, R.id.tv_date_of_joining, "field 'tvDateOfJoining'", TextView.class);
    target.layoutPresentAddress = Utils.findRequiredViewAsType(source, R.id.layoutPresentAddress, "field 'layoutPresentAddress'", TextInputLayout.class);
    target.etPresentAddress = Utils.findRequiredViewAsType(source, R.id.et_present_address, "field 'etPresentAddress'", TextInputEditText.class);
    target.layoutPermanentAddress = Utils.findRequiredViewAsType(source, R.id.layoutPermanentAddress, "field 'layoutPermanentAddress'", TextInputLayout.class);
    target.etPermanentAddress = Utils.findRequiredViewAsType(source, R.id.et_permanent_address, "field 'etPermanentAddress'", TextInputEditText.class);
    target.layoutBodyIdentyMark = Utils.findRequiredViewAsType(source, R.id.layoutBodyIdentyMark, "field 'layoutBodyIdentyMark'", TextInputLayout.class);
    target.etBodyIdentyMark = Utils.findRequiredViewAsType(source, R.id.et_body_identy_mark, "field 'etBodyIdentyMark'", TextInputEditText.class);
    target.spBloodGroup = Utils.findRequiredViewAsType(source, R.id.sp_blood_group, "field 'spBloodGroup'", AppCompatSpinner.class);
    target.layoutMobileNo = Utils.findRequiredViewAsType(source, R.id.layoutMobileNo, "field 'layoutMobileNo'", TextInputLayout.class);
    target.etMobileNo = Utils.findRequiredViewAsType(source, R.id.et_mobile_no, "field 'etMobileNo'", TextInputEditText.class);
    target.layoutLandlineNo = Utils.findRequiredViewAsType(source, R.id.layoutLandlineNo, "field 'layoutLandlineNo'", TextInputLayout.class);
    target.etLandlineNo = Utils.findRequiredViewAsType(source, R.id.et_landline_no, "field 'etLandlineNo'", TextInputEditText.class);
    target.layoutEmergencyContact = Utils.findRequiredViewAsType(source, R.id.layoutEmergencyContact, "field 'layoutEmergencyContact'", TextInputLayout.class);
    target.etEmergencyContact = Utils.findRequiredViewAsType(source, R.id.et_emergency_contact, "field 'etEmergencyContact'", TextInputEditText.class);
    target.layoutEmailID = Utils.findRequiredViewAsType(source, R.id.layoutEmailID, "field 'layoutEmailID'", TextInputLayout.class);
    target.etEmailID = Utils.findRequiredViewAsType(source, R.id.et_email_id, "field 'etEmailID'", TextInputEditText.class);
    target.spEmploymentType = Utils.findRequiredViewAsType(source, R.id.sp_employment_type, "field 'spEmploymentType'", AppCompatSpinner.class);
    target.layoutProjectName = Utils.findRequiredViewAsType(source, R.id.layoutProjectName, "field 'layoutProjectName'", TextInputLayout.class);
    target.etProjectName = Utils.findRequiredViewAsType(source, R.id.et_project_name, "field 'etProjectName'", TextInputEditText.class);
    target.textViewDobError = Utils.findRequiredViewAsType(source, R.id.tv_error_dob, "field 'textViewDobError'", TextView.class);
    target.layoutIfYesSelect = Utils.findRequiredViewAsType(source, R.id.layoutIfYesSelect, "field 'layoutIfYesSelect'", TextInputLayout.class);
    target.etIfYesWriteReason = Utils.findRequiredViewAsType(source, R.id.et_if_yes_select, "field 'etIfYesWriteReason'", TextInputEditText.class);
    target.btnSavePersonalDetails = Utils.findRequiredViewAsType(source, R.id.btn_save_personal_details, "field 'btnSavePersonalDetails'", Button.class);
    target.textViewErrorDOJ = Utils.findRequiredViewAsType(source, R.id.tv_error_doj, "field 'textViewErrorDOJ'", TextView.class);
    target.textViewApplicantTenure = Utils.findRequiredViewAsType(source, R.id.tv_applicant_tenure, "field 'textViewApplicantTenure'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progressBar'", ProgressBar.class);
    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.layout, "field 'linearLayout'", LinearLayout.class);
    target.textViewErrorEmploymentType = Utils.findRequiredViewAsType(source, R.id.tv_error_employee_type, "field 'textViewErrorEmploymentType'", TextView.class);
    target.checkBoxAddress = Utils.findRequiredViewAsType(source, R.id.checkbox_address, "field 'checkBoxAddress'", CheckBox.class);
    target.textViewErrorTenure = Utils.findRequiredViewAsType(source, R.id.tv_error_tenure, "field 'textViewErrorTenure'", TextView.class);
    target.inputLayoutEmpType = Utils.findRequiredViewAsType(source, R.id.layoutOtherEmpType, "field 'inputLayoutEmpType'", TextInputLayout.class);
    target.etOtherEmpType = Utils.findRequiredViewAsType(source, R.id.et_OtherEmpType, "field 'etOtherEmpType'", TextInputEditText.class);
  }

  @Override
  public void unbind() {
    PersonalDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.layoutName = null;
    target.etApplicantName = null;
    target.layoutFatherName = null;
    target.etApplicantFatherName = null;
    target.layoutMotherName = null;
    target.etApplicantMotherName = null;
    target.tvApplicantDOB = null;
    target.layoutDesignation = null;
    target.etDesignation = null;
    target.layoutDepartment = null;
    target.etDepartment = null;
    target.layoutGradePay = null;
    target.etGradPay = null;
    target.tvDateOfJoining = null;
    target.layoutPresentAddress = null;
    target.etPresentAddress = null;
    target.layoutPermanentAddress = null;
    target.etPermanentAddress = null;
    target.layoutBodyIdentyMark = null;
    target.etBodyIdentyMark = null;
    target.spBloodGroup = null;
    target.layoutMobileNo = null;
    target.etMobileNo = null;
    target.layoutLandlineNo = null;
    target.etLandlineNo = null;
    target.layoutEmergencyContact = null;
    target.etEmergencyContact = null;
    target.layoutEmailID = null;
    target.etEmailID = null;
    target.spEmploymentType = null;
    target.layoutProjectName = null;
    target.etProjectName = null;
    target.textViewDobError = null;
    target.layoutIfYesSelect = null;
    target.etIfYesWriteReason = null;
    target.btnSavePersonalDetails = null;
    target.textViewErrorDOJ = null;
    target.textViewApplicantTenure = null;
    target.progressBar = null;
    target.linearLayout = null;
    target.textViewErrorEmploymentType = null;
    target.checkBoxAddress = null;
    target.textViewErrorTenure = null;
    target.inputLayoutEmpType = null;
    target.etOtherEmpType = null;

    super.unbind();
  }
}
