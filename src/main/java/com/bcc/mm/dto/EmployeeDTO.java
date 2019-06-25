package com.bcc.mm.dto;


import javax.persistence.*;

@Entity
@Table(name="employeedto")
public class EmployeeDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName = "";
    private String lastName = "";
    private String jobPosition = "";
    private int pin = 0;

    public EmployeeDTO(){


    }

    public EmployeeDTO(String firstName, String lastName, String jobPosition, int pin){

        this.firstName = firstName;
        this.lastName = lastName;
        this.jobPosition = jobPosition;
        this.pin = pin;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
