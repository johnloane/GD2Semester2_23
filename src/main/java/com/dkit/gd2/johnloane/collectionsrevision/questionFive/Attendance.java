package com.dkit.gd2.johnloane.collectionsrevision.questionFive;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//Populate an ArrayList of Lectures (called lectures !) with two Lecture objects that contain sensible data. Populate each lecture with 3 or 4 student attendees.
//
//Write functions to achieve the following:
//1.	Display details of each lecture, including the students (ids) who attended them.
//2.	Find and display the IDs of students who attended all lectures.
//3.	Find and display all students to attended the first lecture only.
//4.	Display IDs of students who attended one or more lectures.

public class Attendance
{
    private ArrayList<Lecture> lectures;

    public Attendance()
    {
        this.lectures = new ArrayList<>();
    }
    public static void main(String[] args)
    {
        Attendance gd2Attendance = new Attendance();
        gd2Attendance.populateLectures();
        gd2Attendance.printLectures();
        gd2Attendance.fullAttendance();
        gd2Attendance.firstLectureOnly();
        gd2Attendance.oneOrMoreLectures();

    }

    private Set<String> oneOrMoreLectures()
    {
        Set oneOrMoreLectures = new HashSet();
        for(Lecture lecture : lectures)
        {
            oneOrMoreLectures.addAll(lecture.getStudents());
        }
        System.out.println("Students who attended one or more lectures: " + oneOrMoreLectures);
        return oneOrMoreLectures;
    }

    private void firstLectureOnly()
    {
        Set firstLectureOnly = new HashSet();
        firstLectureOnly.addAll(lectures.get(0).getStudents());
        for(int i=1; i < lectures.size(); i++)
        {
            firstLectureOnly.removeAll(lectures.get(i).getStudents());
        }
        System.out.println("Students who attended first lecture only: " + firstLectureOnly);
    }

    private void fullAttendance()
    {
        Set fullAttendance = new HashSet();
        fullAttendance = oneOrMoreLectures();
        for(Lecture lecture : lectures)
        {
            fullAttendance.retainAll(lecture.getStudents());
        }
        System.out.println("Students who attended all lectures: " + fullAttendance);
    }

    private void printLectures()
    {
        for(Lecture lecture : lectures)
        {
            System.out.println(lecture);
        }
    }

    private void populateLectures()
    {
        Date lecture1Date = new Date("01/01/2020");
        Date lecture2Date = new Date("02/01/2020");

        Lecture lecture1 = new Lecture(lecture1Date, "Java", "John");
        Lecture lecture2 = new Lecture(lecture2Date, "Java", "John");
        lecture1.addStudent("D00111111");
        lecture1.addStudent("D00222222");
        lecture1.addStudent("D00333333");
        lecture2.addStudent("D00111111");
        lecture2.addStudent("D00222222");
        lecture2.addStudent("D00444444");
        lectures.add(lecture1);
        lectures.add(lecture2);
    }
}


