package org.example.hakmana.model;

public class SystemUser {
    private String userName;
    private String fullName;
    private String post;
    private String empId;
    private String pwd;
    private String email;
    private String phoneNum;
    private boolean isRemember;

    // Constructors
    public SystemUser() {
    }

    public SystemUser(String userName, String fullName, String post, String empId, String pwd, String email, String phoneNum) {
        this.userName = userName;
        this.fullName = fullName;
        this.post = post;
        this.empId = empId;
        this.pwd = pwd;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    // Setters and Getters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", post='" + post + '\'' +
                ", empId='" + empId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", isRemember=" + isRemember +
                '}';
    }
}
