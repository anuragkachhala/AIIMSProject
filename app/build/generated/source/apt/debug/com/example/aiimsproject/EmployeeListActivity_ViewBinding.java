// Generated code from Butter Knife. Do not modify!
package com.example.aiimsproject;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EmployeeListActivity_ViewBinding extends BaseActivity_ViewBinding {
  private EmployeeListActivity target;

  @UiThread
  public EmployeeListActivity_ViewBinding(EmployeeListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EmployeeListActivity_ViewBinding(EmployeeListActivity target, View source) {
    super(target, source);

    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    target.processBar = Utils.findRequiredViewAsType(source, R.id.progress, "field 'processBar'", ProgressBar.class);
  }

  @Override
  public void unbind() {
    EmployeeListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.recyclerView = null;
    target.processBar = null;

    super.unbind();
  }
}
