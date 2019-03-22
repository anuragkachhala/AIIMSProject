package com.example.aiimsproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.aiimsproject.Model.RegistrationRequest;
import com.example.aiimsproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeListViewHolder> {

    private Context context;
    private List<RegistrationRequest> registrationRequestList;
    private EmployeeListListener employeeListListener;

    public EmployeeListAdapter(Context context, List<RegistrationRequest> registrationRequestList, EmployeeListListener employeeListListener) {
        this.context = context;
        this.registrationRequestList = registrationRequestList;
        this.employeeListListener = employeeListListener;
    }

    @NonNull
    @Override
    public EmployeeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_employee_list, parent, false);
        return new EmployeeListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull EmployeeListViewHolder employeeListViewHolder, int position) {
        RegistrationRequest registrationRequest = registrationRequestList.get(position);
        String relationship;
        if (registrationRequest.isFather()) {
            relationship = " s/o ";
        } else {
            relationship = " w/o ";
        }
        employeeListViewHolder.textViewEmployeeName.setText(registrationRequest.getName() + relationship + registrationRequest.getFatherName());
        employeeListViewHolder.department.setText(registrationRequest.getDepartment());
        employeeListViewHolder.designation.setText(registrationRequest.getDesignation());
        employeeListViewHolder.isChecked.setChecked(registrationRequest.isChecked());
        if(registrationRequest.isSubmitted()){
            employeeListViewHolder.textViewVerified.setVisibility(View.VISIBLE);
            employeeListViewHolder.isChecked.setEnabled(false);
        }else {
            employeeListViewHolder.textViewVerified.setVisibility(View.GONE);
            employeeListViewHolder.isChecked.setEnabled(true);
        }
        applyClickEvents(employeeListViewHolder, position);

    }

    private void applyClickEvents(EmployeeListViewHolder holder, final int position) {
        holder.isChecked.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        employeeListListener.onCheckBoxClicked(position);
                    }
                });


    }


    @Override
    public int getItemCount() {
        return registrationRequestList.size();
    }

    public interface EmployeeListListener {

        void onCheckBoxClicked(int position);

        void onItemClicked(int position);

    }

    public class EmployeeListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_employee_name)
        TextView textViewEmployeeName;
        @BindView(R.id.check)
        CheckBox isChecked;

        @BindView(R.id.tv_department)
        TextView department;

        @BindView(R.id.tv_designation)
        TextView designation;

        @BindView(R.id.tv_verify)
        TextView textViewVerified;

        public EmployeeListViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    employeeListListener.onItemClicked(getAdapterPosition());

                }
            });


        }
    }

}
