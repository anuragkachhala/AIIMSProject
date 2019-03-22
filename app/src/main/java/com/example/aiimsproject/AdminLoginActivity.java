package com.example.aiimsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminLoginActivity extends BaseActivity{


    @BindView(R.id.et_UserName)
    TextInputEditText editTextUserName;

    @BindView(R.id.et_password)
    TextInputEditText editTextPassword;

    @BindView(R.id.layoutUserName)
    TextInputLayout textInputLayoutUserName;

    @BindView(R.id.layoutPassword)
    TextInputLayout textInputLayoutPassword;

    @BindView(R.id.btn_login_admin)
    Button buttonLoginAdmin;

    private TextInputLayout textInputLayoutError;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListener();



    }

    @Override
    protected void setListener() {

        buttonLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkValidation()) {
                    startActivity(EmployeeListActivity.class);
                }
            }
        });

    }

    @Override
    protected void setResources() {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_admin_login;
    }

    @Override
    protected String getToolBarTitle() {
        return "Login";
    }

    @Override
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();


    }



    private boolean checkValidation() {
        if (textInputLayoutError != null) {
            textInputLayoutError.setError(null);

        }
        if (checkEmpty(editTextUserName)) {
            setError(editTextUserName, textInputLayoutUserName, getResources().getString(R.string.err_msg_enter_user_name));
            return false;
        }
        if (checkEmpty(editTextPassword)) {
            setError(editTextPassword, textInputLayoutPassword, getResources().getString(R.string.err_msg_enter_password));
            return false;
        }
        if (!getValue(editTextUserName).equals("Admin")) {
            setError(editTextUserName, textInputLayoutUserName, getResources().getString(R.string.err_msg_valid_user_name));
            ;
            return false;
        }
        if (!getValue(editTextPassword).equals("Pass")) {
            setError(editTextPassword, textInputLayoutPassword, getResources().getString(R.string.err_msg_valid_password));
            return false;
        }
        return true;

    }


    private boolean checkEmpty(TextInputEditText textInputEditText) {
        if (getValue(textInputEditText).isEmpty()) {
            return true;
        }
        return false;

    }


    private String getValue(TextInputEditText textInputEditText) {
        return textInputEditText.getText().toString().trim();
    }


    private void setError(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String errorMsg) {
        textInputEditText.requestFocus();
        textInputLayout.setError(errorMsg);
        textInputLayoutError = textInputLayout;


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

        }

        return super.onOptionsItemSelected(item);


    }


}
