package com.dkit.gd2.johnloane.dto;

public class Result
{
    private String studentID;
    private String courseID;
    private String grade;

    public Result(String studentID, String courseID, String grade)
    {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public String getCourseID()
    {
        return courseID;
    }

    public String getGrade()
    {
        return grade;
    }

    @Override
    public String toString()
    {
        return "Result{" +
                "studentID='" + studentID + '\'' +
                ", courseID='" + courseID + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
