package com.dkit.gd2.johnloane.jsonwithgson;

public class Student
{
    private String name;
    private int pets;

    public Student(String name, int pets)
    {
        this.name = name;
        this.pets = pets;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", numberOfPets=" + pets +
                '}';
    }

}
