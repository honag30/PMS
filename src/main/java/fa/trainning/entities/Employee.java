package fa.trainning.entities;

import java.sql.Date;

public class Employee {
    private int employeeId;
    private String account;
    private String department;
    private String employeeAddress;
    private Date employeeBirthDate;
    private String employeeEmail;
    private String employeeName;
    private String employeePhone;
    private String password;
    private Gender sex;
    private String role;



    public Employee() {
    }

    public Employee( String account, String department, String employeeAddress, Date employeeBirthDate, String employeeEmail, String employeeName, String employeePhone, String password, Gender sex) {
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthDate = employeeBirthDate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.password = password;
        this.sex = sex;
    }

    public Employee(int employeeId, String account, String department, String employeeAddress, Date employeeBirthDate, String employeeEmail, String employeeName, String employeePhone, String password, Gender sex) {
        this.employeeId = employeeId;
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthDate = employeeBirthDate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.password = password;
        this.sex = sex;
    }

    public Employee(String account, String department, String employeeAddress, Date employeeBirthDate, String employeeEmail, String employeeName, String employeePhone, String password, Gender sex, String role) {
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthDate = employeeBirthDate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.password = password;
        this.sex = sex;
        this.role = role;
    }

    public Employee(int employeeId, String account, String department, String employeeAddress, Date employeeBirthDate, String employeeEmail, String employeeName, String employeePhone, String password, Gender sex, String role) {
        this.employeeId = employeeId;
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthDate = employeeBirthDate;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.password = password;
        this.sex = sex;
        this.role = role;
    }

    public Employee(int employeeId, String department, String employeeAddress, Date employeeBirthDate, String employeePhone, String employeeName) {
        this.employeeId = employeeId;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthDate = employeeBirthDate;
        this.employeePhone = employeePhone;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Date getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    public void setEmployeeBirthDate(Date employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public enum Gender {
        M, F
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("employeeId=").append(employeeId);
        sb.append(", account='").append(account).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append(", employeeAddress='").append(employeeAddress).append('\'');
        sb.append(", employeeBirthDate=").append(employeeBirthDate);
        sb.append(", employeeEmail='").append(employeeEmail).append('\'');
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append(", employeePhone='").append(employeePhone).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
