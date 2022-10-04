/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisobject;

/**
 *
 * @author ACER
 */
public class Account {
    private int accid;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private int role;
    private int status;

    public Account() {
    }

    public Account(int accid, String email, String password, String fullname, String phone, int role, int status) {
        this.accid = accid;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public Account(int accid, String email, String password, String fullname) {
        this.accid = accid;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "accid=" + accid + ", email=" + email + ", password=" + password + ", fullname=" + fullname + ", phone=" + phone + ", role=" + role + ", status=" + status + '}';
    }
    
    
}
