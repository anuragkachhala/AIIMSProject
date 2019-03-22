// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.btnEmployeeRegistration = Utils.findRequiredViewAsType(source, R.id.btn_employee_registration, "field 'btnEmployeeRegistration'", Button.class);
    target.btnStudentRegistration = Utils.findRequiredViewAsType(source, R.id.btn_student_registration, "field 'btnStudentRegistration'", Button.class);
    target.btnLoginAdmin = Utils.findRequiredViewAsType(source, R.id.btn_login_admin, "field 'btnLoginAdmin'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnEmployeeRegistration = null;
    target.btnStudentRegistration = null;
    target.btnLoginAdmin = null;
  }
}
