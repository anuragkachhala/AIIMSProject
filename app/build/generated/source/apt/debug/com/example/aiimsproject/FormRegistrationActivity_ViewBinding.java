// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FormRegistrationActivity_ViewBinding extends BaseActivity_ViewBinding {
  private FormRegistrationActivity target;

  @UiThread
  public FormRegistrationActivity_ViewBinding(FormRegistrationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FormRegistrationActivity_ViewBinding(FormRegistrationActivity target, View source) {
    super(target, source);

    this.target = target;

    target.layoutName = Utils.findRequiredViewAsType(source, R.id.layoutName, "field 'layoutName'", TextInputLayout.class);
    target.etApplicantName = Utils.findRequiredViewAsType(source, R.id.et_applicant_name, "field 'etApplicantName'", TextInputEditText.class);
    target.layoutFatherName = Utils.findRequiredViewAsType(source, R.id.layoutFatherName, "field 'layoutFatherName'", TextInputLayout.class);
    target.etApplicantFatherName = Utils.findRequiredViewAsType(source, R.id.et_applicant_father_name, "field 'etApplicantFatherName'", TextInputEditText.class);
    target.layoutMotherName = Utils.findRequiredViewAsType(source, R.id.layoutMotherName, "field 'layoutMotherName'", TextInputLayout.class);
    target.etApplicantMotherName = Utils.findRequiredViewAsType(source, R.id.et_applicant_mother_name, "field 'etApplicantMotherName'", TextInputEditText.class);
    target.tvApplicantDOB = Utils.findRequiredViewAsType(source, R.id.tv_applicant_dob, "field 'tvApplicantDOB'", TextView.class);
    target.spBloodGroup = Utils.findRequiredViewAsType(source, R.id.sp_blood_group, "field 'spBloodGroup'", AppCompatSpinner.class);
    target.textViewTitle = Utils.findRequiredViewAsType(source, R.id.title, "field 'textViewTitle'", TextView.class);
    target.rgReceivedID = Utils.findRequiredViewAsType(source, R.id.rg_received_id, "field 'rgReceivedID'", RadioGroup.class);
    target.rgFatherHusband = Utils.findRequiredViewAsType(source, R.id.rg_father_husband, "field 'rgFatherHusband'", RadioGroup.class);
    target.checkBoxAddress = Utils.findRequiredViewAsType(source, R.id.checkbox_address, "field 'checkBoxAddress'", CheckBox.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  public void unbind() {
    FormRegistrationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutName = null;
    target.etApplicantName = null;
    target.layoutFatherName = null;
    target.etApplicantFatherName = null;
    target.layoutMotherName = null;
    target.etApplicantMotherName = null;
    target.tvApplicantDOB = null;
    target.spBloodGroup = null;
    target.textViewTitle = null;
    target.rgReceivedID = null;
    target.rgFatherHusband = null;
    target.checkBoxAddress = null;
    target.progressBar = null;

    super.unbind();
  }
}
