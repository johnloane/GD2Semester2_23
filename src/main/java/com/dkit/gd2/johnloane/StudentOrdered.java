package com.dkit.gd2.johnloane;

// A class that models a student. A student has a name and a percentage mark.
public class StudentOrdered implements Comparable<StudentOrdered>
{
    private String name;
    private int mark;

    public StudentOrdered(String name, int mark)
    {
        this.name = name;
        this.mark = mark;
    }

    public String getName()
    {
        return name;
    }

    public int getMark()
    {
        return mark;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }

    @Override
    public int compareTo(StudentOrdered otherStudent)
    {
        if(this.mark < otherStudent.mark)
        {
            return 1;
        }
        else if(this.mark > otherStudent.mark)
        {
            return -1;
        }
        else if(this.mark == otherStudent.mark && this.name.compareTo(otherStudent.name) < 0)
        {
            return -1;
        }
        else if(this.mark == otherStudent.mark && this.name.compareTo(otherStudent.name) > 0)
        {
            return 1;
        }
        else if(this.mark == otherStudent.mark && this.name.compareTo(otherStudent.name) == 0)
        {
            return 0;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        StudentOrdered student = (StudentOrdered) obj;
        return mark == student.mark && name.equals(student.name);
    }

    @Override
    public int hashCode()
    {
        return 31 * name.hashCode() + mark;
    }
}
