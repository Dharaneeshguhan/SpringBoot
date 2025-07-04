package com.example.Springbootfirstproject.Models;

public class Employee {
    private int Empid;
    private String Name;
    private String job;
    private int salary;

    public Employee(int empid, String name, String job, int salary) {
        Empid = empid;
        Name = name;
        this.job = job;
        this.salary = salary;
    }

    public int getEmpid() {
        return Empid;
    }

    public String getName() {
        return Name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmpid(int empid) {
        Empid = empid;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
