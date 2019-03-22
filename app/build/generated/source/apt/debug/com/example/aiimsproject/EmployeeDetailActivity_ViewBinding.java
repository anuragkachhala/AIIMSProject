// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EmployeeDetailActivity_ViewBinding extends BaseActivity_ViewBinding {
  private EmployeeDetailActivity target;

  @UiThread
  public EmployeeDetailActivity_ViewBinding(EmployeeDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EmployeeDetailActivity_ViewBinding(EmployeeDetailActivity target, View source) {
    super(target, source);

    this.target = target;

    target.textViewEmplyeeName = Utils.findRequiredViewAsType(source, R.id.tv_employee_name, "field 'textViewEmplyeeName'", TextView.class);
    target.textViewFatherName = Utils.findRequiredViewAsType(source, R.id.tv_employee_father, "field 'textViewFatherName'", TextView.class);
    target.textViewMotherName = Utils.findRequiredViewAsType(source, R.id.tv_employee_mother_name, "field 'textViewMotherName'", TextView.class);
    target.textViewDesignation = Utils.findRequiredViewAsType(source, R.id.tv_employee_designation, "field 'textViewDesignation'", TextView.class);
    target.textViewEmployeeDepartment = Utils.findRequiredViewAsType(source, R.id.tv_employee_department, "field 'textViewEmployeeDepartment'", TextView.class);
    target.textViewEmployeeGradePay = Utils.findRequiredViewAsType(source, R.id.tv_employee_grade_pay, "field 'textViewEmployeeGradePay'", TextView.class);
    target.textViewBloodGroup = Utils.findRequiredViewAsType(source, R.id.tv_employee_blood_group, "field 'textViewBloodGroup'", TextView.class);
    target.textViewEmployeeType = Utils.findRequiredViewAsType(source, R.id.tv_employee_type, "field 'textViewEmployeeType'", TextView.class);
    target.textViewEmployeeDob = Utils.findRequiredViewAsType(source, R.id.tv_employee_dob, "field 'textViewEmployeeDob'", TextView.class);
    target.textViewEmployeeDoj = Utils.findRequiredViewAsType(source, R.id.tv_employee_doj, "field 'textViewEmployeeDoj'", TextView.class);
    target.textViewBodyMark = Utils.findRequiredViewAsType(source, R.id.tv_employee_body, "field 'textViewBodyMark'", TextView.class);
    target.textViewContact = Utils.findRequiredViewAsType(source, R.id.tv_employee_contact, "field 'textViewContact'", TextView.class);
    target.textViewEmployeeLandLineNo = Utils.findRequiredViewAsType(source, R.id.tv_employee_landLine_no, "field 'textViewEmployeeLandLineNo'", TextView.class);
    target.textViewEmployeeEmergencyNo = Utils.findRequiredViewAsType(source, R.id.tv_employee_emergency_no, "field 'textViewEmployeeEmergencyNo'", TextView.class);
    target.textViewEmployeeParmentAdd = Utils.findRequiredViewAsType(source, R.id.tv_employee_parment_add, "field 'textViewEmployeeParmentAdd'", TextView.class);
    target.textViewEmployeePresentAdd = Utils.findRequiredViewAsType(source, R.id.tv_employee_present_add, "field 'textViewEmployeePresentAdd'", TextView.class);
    target.textViewEmailId = Utils.findRequiredViewAsType(source, R.id.tv_employee_email_di, "field 'textViewEmailId'", TextView.class);
    target.textViewLabelFatherName = Utils.findRequiredViewAsType(source, R.id.tv_label_father_name, "field 'textViewLabelFatherName'", TextView.class);
  }

  @Override
  public void unbind() {
    EmployeeDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewEmplyeeName = null;
    target.textViewFatherName = null;
    target.textViewMotherName = null;
    target.textViewDesignation = null;
    target.textViewEmployeeDepartment = null;
    target.textViewEmployeeGradePay = null;
    target.textViewBloodGroup = null;
    target.textViewEmployeeType = null;
    target.textViewEmployeeDob = null;
    target.textViewEmployeeDoj = null;
    target.textViewBodyMark = null;
    target.textViewContact = null;
    target.textViewEmployeeLandLineNo = null;
    target.textViewEmployeeEmergencyNo = null;
    target.textViewEmployeeParmentAdd = null;
    target.textViewEmployeePresentAdd = null;
    target.textViewEmailId = null;
    target.textViewLabelFatherName = null;

    super.unbind();
  }
}
