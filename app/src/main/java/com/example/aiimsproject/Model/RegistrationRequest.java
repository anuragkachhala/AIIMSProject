package com.example.aiimsproject.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationRequest {



    @SerializedName("submitted")
    @Expose
    private boolean isSubmitted;

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dob")
    @Expose
    private Long dob;
    @SerializedName("fatherName")
    @Expose
    private String fatherName;
    @SerializedName("motherName")
    @Expose
    private String motherName;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("gradePay")
    @Expose
    private String gradePay;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("dateOfJoining")
    @Expose
    private Long dateOfJoining;
    @SerializedName("presentAddress")
    @Expose
    private String presentAddress;
    @SerializedName("permanentAddress")
    @Expose
    private String permanentAddress;
    @SerializedName("bodyIdMark")
    @Expose
    private String bodyIdMark;
    @SerializedName("bloodGroup")
    @Expose
    private String bloodGroup;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("landLineNO")
    @Expose
    private String landLineNO;
    @SerializedName("emergencyContactNo")
    @Expose
    private String emergencyContactNo;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("employeementType")
    @Expose
    private String employeementType;
    @SerializedName("projectName")
    @Expose
    private String projectName;
    @SerializedName("tenure")
    @Expose
    private String tenure;
    @SerializedName("recievedId")
    @Expose
    private Boolean recievedId;
    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("check")
    @Expose
    private boolean isFather;

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    public boolean isFather() {
        return isFather;
    }

    public void setFather(boolean father) {
        isFather = father;
    }



    private transient boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGradePay() {
        return gradePay;
    }

    public void setGradePay(String gradePay) {
        this.gradePay = gradePay;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Long dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getBodyIdMark() {
        return bodyIdMark;
    }

    public void setBodyIdMark(String bodyIdMark) {
        this.bodyIdMark = bodyIdMark;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLandLineNO() {
        return landLineNO;
    }

    public void setLandLineNO(String landLineNO) {
        this.landLineNO = landLineNO;
    }

    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmployeementType() {
        return employeementType;
    }

    public void setEmployeementType(String employeementType) {
        this.employeementType = employeementType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public Boolean getRecievedId() {
        return recievedId;
    }

    public void setRecievedId(Boolean recievedId) {
        this.recievedId = recievedId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
