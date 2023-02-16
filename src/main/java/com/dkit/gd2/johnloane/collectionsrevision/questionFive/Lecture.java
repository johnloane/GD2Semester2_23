package com.dkit.gd2.johnloane.collectionsrevision.questionFive;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//An automatic student ID reader is used to record student attendances at Lectures.
//Create  a Lecture class that will store the date of the lecture, the topic, the lecturer name and an appropriate collection of student id numbers (String) called students identifying those who attended the lecture. (Choose the collection based on the operations required below).
public class Lecture
{
    private Date date;
    private String topic;
    private String lecturerName;
    private Set<String> students;

    public Lecture(Date date, String topic, String lecturerName)
    {
        this.date = date;
        this.topic = topic;
        this.lecturerName = lecturerName;
        this.students = new HashSet<>();
    }

    public Date getDate()
    {
        return date;
    }

    public String getTopic()
    {
        return topic;
    }

    public String getLecturerName()
    {
        return lecturerName;
    }

    public Set<String> getStudents()
    {
        return students;
    }

    public void addStudent(String studentId)
    {
        this.students.add(studentId);
    }

    public void removeStudent(String studentId)
    {
        this.students.remove(studentId);
    }

    public void clearStudents()
    {
        this.students.clear();
    }

    @Override
    public String toString()
    {
        return "Lecture{" +
                "date='" + date + '\'' +
                ", topic='" + topic + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", students=" + students +
                '}';
    }
}
