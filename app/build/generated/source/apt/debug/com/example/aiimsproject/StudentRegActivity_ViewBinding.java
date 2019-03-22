// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StudentRegActivity_ViewBinding extends FormRegistrationActivity_ViewBinding {
  private StudentRegActivity target;

  @UiThread
  public StudentRegActivity_ViewBinding(StudentRegActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StudentRegActivity_ViewBinding(StudentRegActivity target, View source) {
    super(target, source);

    this.target = target;

    target.layoutSpeciality = Utils.findRequiredViewAsType(source, R.id.layoutSpeciality, "field 'layoutSpeciality'", TextInputLayout.class);
    target.etSpeciality = Utils.findRequiredViewAsType(source, R.id.et_speciality, "field 'etSpeciality'", TextInputEditText.class);
    target.textInputLayoutRollNo = Utils.findRequiredViewAsType(source, R.id.layoutRollNo, "field 'textInputLayoutRollNo'", TextInputLayout.class);
    target.etRollNo = Utils.findRequiredViewAsType(source, R.id.et_roll_no, "field 'etRollNo'", TextInputEditText.class);
    target.textInputLayoutRegNo = Utils.findRequiredViewAsType(source, R.id.layoutRegistrationNo, "field 'textInputLayoutRegNo'", TextInputLayout.class);
    target.etRegNo = Utils.findRequiredViewAsType(source, R.id.et_registration_no, "field 'etRegNo'", TextInputEditText.class);
    target.layoutPresentAddress = Utils.findRequiredViewAsType(source, R.id.layoutPresentAddress, "field 'layoutPresentAddress'", TextInputLayout.class);
    target.etPresentAddress = Utils.findRequiredViewAsType(source, R.id.et_present_address, "field 'etPresentAddress'", TextInputEditText.class);
    target.layoutPermanentAddress = Utils.findRequiredViewAsType(source, R.id.layoutPermanentAddress, "field 'layoutPermanentAddress'", TextInputLayout.class);
    target.etPermanentAddress = Utils.findRequiredViewAsType(source, R.id.et_permanent_address, "field 'etPermanentAddress'", TextInputEditText.class);
    target.layoutBodyIdentyMark = Utils.findRequiredViewAsType(source, R.id.layoutBodyIdentyMark, "field 'layoutBodyIdentyMark'", TextInputLayout.class);
    target.etBodyIdentyMark = Utils.findRequiredViewAsType(source, R.id.et_body_identy_mark, "field 'etBodyIdentyMark'", TextInputEditText.class);
    target.layoutMobileNo = Utils.findRequiredViewAsType(source, R.id.layoutMobileNo, "field 'layoutMobileNo'", TextInputLayout.class);
    target.etMobileNo = Utils.findRequiredViewAsType(source, R.id.et_mobile_no, "field 'etMobileNo'", TextInputEditText.class);
    target.layoutLandlineNo = Utils.findRequiredViewAsType(source, R.id.layoutLandlineNo, "field 'layoutLandlineNo'", TextInputLayout.class);
    target.etLandlineNo = Utils.findRequiredViewAsType(source, R.id.et_landline_no, "field 'etLandlineNo'", TextInputEditText.class);
    target.layoutEmergencyContact = Utils.findRequiredViewAsType(source, R.id.layoutEmergencyContact, "field 'layoutEmergencyContact'", TextInputLayout.class);
    target.etEmergencyContact = Utils.findRequiredViewAsType(source, R.id.et_emergency_contact, "field 'etEmergencyContact'", TextInputEditText.class);
    target.layoutEmailID = Utils.findRequiredViewAsType(source, R.id.layoutEmailID, "field 'layoutEmailID'", TextInputLayout.class);
    target.etEmailID = Utils.findRequiredViewAsType(source, R.id.et_email_id, "field 'etEmailID'", TextInputEditText.class);
    target.spCourseName = Utils.findRequiredViewAsType(source, R.id.sp_course_name, "field 'spCourseName'", AppCompatSpinner.class);
    target.textViewDobError = Utils.findRequiredViewAsType(source, R.id.tv_error_dob, "field 'textViewDobError'", TextView.class);
    target.layoutIfYesSelect = Utils.findRequiredViewAsType(source, R.id.layoutIfYesSelect, "field 'layoutIfYesSelect'", TextInputLayout.class);
    target.etIfYesWriteReason = Utils.findRequiredViewAsType(source, R.id.et_if_yes_select, "field 'etIfYesWriteReason'", TextInputEditText.class);
    target.btnSavePersonalDetails = Utils.findRequiredViewAsType(source, R.id.btn_save_personal_details, "field 'btnSavePersonalDetails'", Button.class);
    target.radioGroupPG = Utils.findRequiredViewAsType(source, R.id.radioGroup_pg, "field 'radioGroupPG'", RadioGroup.class);
    target.textViewErrorCourseName = Utils.findRequiredViewAsType(source, R.id.tv_error_course_name, "field 'textViewErrorCourseName'", TextView.class);
    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.layout, "field 'linearLayout'", LinearLayout.class);
  }

  @Override
  public void unbind() {
    StudentRegActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutSpeciality = null;
    target.etSpeciality = null;
    target.textInputLayoutRollNo = null;
    target.etRollNo = null;
    target.textInputLayoutRegNo = null;
    target.etRegNo = null;
    target.layoutPresentAddress = null;
    target.etPresentAddress = null;
    target.layoutPermanentAddress = null;
    target.etPermanentAddress = null;
    target.layoutBodyIdentyMark = null;
    target.etBodyIdentyMark = null;
    target.layoutMobileNo = null;
    target.etMobileNo = null;
    target.layoutLandlineNo = null;
    target.etLandlineNo = null;
    target.layoutEmergencyContact = null;
    target.etEmergencyContact = null;
    target.layoutEmailID = null;
    target.etEmailID = null;
    target.spCourseName = null;
    target.textViewDobError = null;
    target.layoutIfYesSelect = null;
    target.etIfYesWriteReason = null;
    target.btnSavePersonalDetails = null;
    target.radioGroupPG = null;
    target.textViewErrorCourseName = null;
    target.linearLayout = null;

    super.unbind();
  }
}
