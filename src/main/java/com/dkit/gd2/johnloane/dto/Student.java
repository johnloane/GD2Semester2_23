package com.dkit.gd2.johnloane.dto;

public class Student
{
    private String studentID;
    private String firstName;
    private String lastName;

    public Student(String studentID, String first_name, String last_name)
    {
        this.studentID = studentID;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public String getFirst_name()
    {
        return firstName;
    }

    public String getLast_name()
    {
        return lastName;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }
}
