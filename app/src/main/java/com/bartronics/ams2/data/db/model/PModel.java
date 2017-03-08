package com.bartronics.ams2.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by anand.chandaliya on 21-02-2017.
 */

@Entity(nameInDb = "profile")
public class PModel {


    @Expose
    @SerializedName("id")
    @Id(autoincrement = true)
    private Long keyId;

    @Expose
    @SerializedName("emp_name")
    @Property(nameInDb = "emp_name")
    private String empName;

    @Expose
    @SerializedName("emp_description")
    @Property(nameInDb = "emp_description")
    private String empDescriton;

    @Expose
    @SerializedName("emp_number")
    @Property(nameInDb = "emp_number")
    String empNumber;

    @Expose
    @SerializedName("emp_id")
    @Property(nameInDb = "emp_id")
    private int empId;

    @Expose
    @SerializedName("emp_pin")
    @Property(nameInDb = "emp_pin")
    private int empPin;

   /* @Expose
    @SerializedName("emp_in_time")
    @Property(nameInDb = "emp_in_time")
    private String empInTime;

    @Expose
    @SerializedName("emp_out_time")
    @Property(nameInDb = "emp_out_time")
    private String empOutTime;

    @Expose
    @SerializedName("emp_in_date")
    @Property(nameInDb = "emp_in_date")
    private String empInDate;

    @Expose
    @SerializedName("emp_location")
    @Property(nameInDb = "emp_location")
    private String empLocation;

    @Expose
    @SerializedName("emp_department")
    @Property(nameInDb = "emp_department")
    private String empDepartment;*/

    @Expose
    @SerializedName("emp_work_location")
    @Property(nameInDb = "emp_work_location")
    private String empWorkLocation;

    @Expose
    @SerializedName("emp_designation")
    @Property(nameInDb = "emp_designation")
    private String empDesignaiton;


    @Generated(hash = 1287496220)
    public PModel() {
    }


    @Generated(hash = 1574877296)
    public PModel(Long keyId, String empName, String empDescriton, String empNumber,
            int empId, int empPin, String empWorkLocation, String empDesignaiton) {
        this.keyId = keyId;
        this.empName = empName;
        this.empDescriton = empDescriton;
        this.empNumber = empNumber;
        this.empId = empId;
        this.empPin = empPin;
        this.empWorkLocation = empWorkLocation;
        this.empDesignaiton = empDesignaiton;
    }


    public Long getKeyId() {

        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDescriton() {
        return empDescriton;
    }

    public void setEmpDescriton(String empDescriton) {
        this.empDescriton = empDescriton;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpPin() {
        return empPin;
    }

    public void setEmpPin(int empPin) {
        this.empPin = empPin;
    }

   /* public String getEmpInTime() {
        return empInTime;
    }

    public void setEmpInTime(String empInTime) {
        this.empInTime = empInTime;
    }

    public String getEmpOutTime() {
        return empOutTime;
    }

    public void setEmpOutTime(String empOutTime) {
        this.empOutTime = empOutTime;
    }

    public String getEmpInDate() {
        return empInDate;
    }

    public void setEmpInDate(String empInDate) {
        this.empInDate = empInDate;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }*/

    public String getEmpWorkLocation() {
        return empWorkLocation;
    }

    public void setEmpWorkLocation(String empWorkLocation) {
        this.empWorkLocation = empWorkLocation;
    }

    public String getEmpDesignaiton() {
        return empDesignaiton;
    }

    public void setEmpDesignaiton(String empDesignaiton) {
        this.empDesignaiton = empDesignaiton;
    }
}
