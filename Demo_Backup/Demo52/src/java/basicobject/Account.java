package basicobject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thanhtra
 */
public class Account {
    private int accid;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private int status;
    private int roles;

    public Account() {
    }

    public Account(int accid, String email, String password, String fullname, String phone, int status, int roles) {
        this.accid = accid;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.status = status;
        this.roles = roles;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Account{" + "accid=" + accid + ", email=" + email + ", password=" + password + ", fullname=" + fullname
                + ", phone=" + phone + ", status=" + status + ", roles=" + roles + '}';
    }

}
