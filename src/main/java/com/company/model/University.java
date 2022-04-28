package com.company.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class University {
    private int universityid;
    private String name;
    private int accriditationlevel;
    private Date creationdate;
    private String address;
    private String phone;
    private int numberoffaculties;
    private int numberofstudents;


    public University() {
    }

    public University(int universityid, String name, int accditationlevel, Date creationdate,
                      String address, String phone, int numberoffaculties, int numberofstudents) {
        this.universityid = universityid;
        this.name = name;
        this.accriditationlevel = accditationlevel;
        this.creationdate = creationdate;
        this.address = address;
        this.phone = phone;
        this.numberoffaculties = numberoffaculties;
        this.numberofstudents = numberofstudents;

    }


    @Override
    public String toString() {
        return "University{" + "id=" + universityid + ", name=" + name +
                "accriditationlevel=" + accriditationlevel + ", creationdate=" + creationdate + ", address=" + address + ", " +
                "phone=" + phone + ", numberoffaculties=" + numberoffaculties + ", numberofstudents=" + numberofstudents + '}';
    }


    public int getUniversityid() {
        return universityid;
    }

    public void setUniversityid(int universityid) {
        this.universityid = universityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccriditationlevel() {
        return accriditationlevel;
    }

    public void setAccriditationlevel(int accriditationlevel) {
        this.accriditationlevel = accriditationlevel;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumberoffaculties() {
        return numberoffaculties;
    }

    public void setNumberoffaculties(int numberoffaculties) {
        this.numberoffaculties = numberoffaculties;
    }

    public int getNumberofstudents() {
        return numberofstudents;
    }

    public void setNumberofstudents(int numberofstudents) {
        this.numberofstudents = numberofstudents;
    }
}