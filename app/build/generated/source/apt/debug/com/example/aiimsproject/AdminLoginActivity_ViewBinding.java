// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdminLoginActivity_ViewBinding extends BaseActivity_ViewBinding {
  private AdminLoginActivity target;

  @UiThread
  public AdminLoginActivity_ViewBinding(AdminLoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AdminLoginActivity_ViewBinding(AdminLoginActivity target, View source) {
    super(target, source);

    this.target = target;

    target.editTextUserName = Utils.findRequiredViewAsType(source, R.id.et_UserName, "field 'editTextUserName'", TextInputEditText.class);
    target.editTextPassword = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'editTextPassword'", TextInputEditText.class);
    target.textInputLayoutUserName = Utils.findRequiredViewAsType(source, R.id.layoutUserName, "field 'textInputLayoutUserName'", TextInputLayout.class);
    target.textInputLayoutPassword = Utils.findRequiredViewAsType(source, R.id.layoutPassword, "field 'textInputLayoutPassword'", TextInputLayout.class);
    target.buttonLoginAdmin = Utils.findRequiredViewAsType(source, R.id.btn_login_admin, "field 'buttonLoginAdmin'", Button.class);
  }

  @Override
  public void unbind() {
    AdminLoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextUserName = null;
    target.editTextPassword = null;
    target.textInputLayoutUserName = null;
    target.textInputLayoutPassword = null;
    target.buttonLoginAdmin = null;

    super.unbind();
  }
}
