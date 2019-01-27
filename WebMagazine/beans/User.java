/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbfteam.beans;
import java.io.Serializable;

/**
 *
 * @author Nikos Ksygkis
 */
public class User{
    
    private int id;
    private String username;
    private String password;
    private String email;
    private String fname;
    private String lname;
    private String birthdate;
    private String gender;
    private String reg_date;
    private String is_active;
    private Boolean is_admin;
    
    // GETTERS
    
    public int getId(){return this.id;}  
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
    public String getEmail(){return this.email;}
    public String getFname(){return this.fname;}
    public String getLname(){return this.lname;}
    public String getBirthdate(){return this.birthdate;} 
    public String getGender(){return this.gender;}

    public String getReg_date(){return this.reg_date;}
    public String getIs_active(){return this.is_active;}
    public Boolean getIs_admin(){return this.is_admin;}  
    
    // SETTERS
    public void setId(int id){this.id = id;}
    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}
    public void setEmail(String email){this.email = email;}
    public void setFname(String fname){this.fname = fname;}
    public void setLname(String lname){this.lname = lname;}
    public void setBirthdate(String birthdate){this.birthdate = birthdate;}
    public void setGender(String gender){this.gender = gender;}

    public void setReg_date(String reg_date){this.reg_date = reg_date;}
    public void setIs_active(String is_active){this.is_active = is_active;}
    public void setIs_admin(Boolean is_admin){this.is_admin = is_admin;}
}
