// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.aiimsproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EmployeeListAdapter$EmployeeListViewHolder_ViewBinding implements Unbinder {
  private EmployeeListAdapter.EmployeeListViewHolder target;

  @UiThread
  public EmployeeListAdapter$EmployeeListViewHolder_ViewBinding(EmployeeListAdapter.EmployeeListViewHolder target,
      View source) {
    this.target = target;

    target.textViewEmployeeName = Utils.findRequiredViewAsType(source, R.id.tv_employee_name, "field 'textViewEmployeeName'", TextView.class);
    target.isChecked = Utils.findRequiredViewAsType(source, R.id.check, "field 'isChecked'", CheckBox.class);
    target.department = Utils.findRequiredViewAsType(source, R.id.tv_department, "field 'department'", TextView.class);
    target.designation = Utils.findRequiredViewAsType(source, R.id.tv_designation, "field 'designation'", TextView.class);
    target.textViewVerified = Utils.findRequiredViewAsType(source, R.id.tv_verify, "field 'textViewVerified'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EmployeeListAdapter.EmployeeListViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewEmployeeName = null;
    target.isChecked = null;
    target.department = null;
    target.designation = null;
    target.textViewVerified = null;
  }
}
