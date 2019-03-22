package com.example.aiimsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aiimsproject.Model.UpdateStatus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getName();

    @BindView(R.id.btn_employee_registration)
    Button btnEmployeeRegistration;

    @BindView(R.id.btn_student_registration)
    Button btnStudentRegistration;

    @BindView(R.id.btn_login_admin)
    Button btnLoginAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btnEmployeeRegistration.setOnClickListener(this);
        btnLoginAdmin.setOnClickListener(this);
        btnStudentRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_employee_registration:
                startActivity(new Intent(this, PersonalDetailsActivity.class));
                break;
            case R.id.btn_login_admin:
                startActivity(new Intent(this,AdminLoginActivity.class));
                break;
            case R.id.btn_student_registration:
                startActivity(new Intent(this,StudentRegActivity.class));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_employee_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_verify_form:




        }

        return super.onOptionsItemSelected(item);
    }

}
