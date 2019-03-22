package com.example.aiimsproject.Utils;

import com.example.aiimsproject.Model.RegistrationRequest;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListSingleton  {

    ArrayList<RegistrationRequest> oldEmployeeList;

    private RegistrationRequest registrationRequest;

    List<RegistrationRequest> employeeList;

   // ArrayList<RegistrationRequest> selectedContacts ;



    private static EmployeeListSingleton employeeStatic=new EmployeeListSingleton();
    private EmployeeListSingleton(){

    }

    public static EmployeeListSingleton getInstance()
    {
        return employeeStatic;
    }


    public ArrayList<RegistrationRequest> getOldEmployeeList() {
        return oldEmployeeList;
    }

    public void setOldEmployeeList(ArrayList<RegistrationRequest> oldEmployeeList) {
        this.oldEmployeeList = oldEmployeeList;
    }

    public List<RegistrationRequest> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<RegistrationRequest> employeeList) {
        this.employeeList = employeeList;
    }

   public RegistrationRequest getRegistrationRequest(int position){
       return registrationRequest = employeeList.get(position);

   }
}
