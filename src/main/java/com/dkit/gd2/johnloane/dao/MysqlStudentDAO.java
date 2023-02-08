package com.dkit.gd2.johnloane.dao;

import com.dkit.gd2.johnloane.dto.Student;
import com.dkit.gd2.johnloane.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlStudentDAO extends MysqlDAO implements IStudentDAOInterface
{
    @Override
    public List<Student> findAllStudents() throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try
        {
            con = this.getConnection();
            String query = "SELECT * FROM student";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next())
            {
                String studentID = rs.getString("student_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");

                Student s = new Student(studentID, first_name, last_name);
                students.add(s);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("findAllStudents() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return students;
    }

    @Override
    public Student findStudentByStudentID(String studentID) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student s = null;

        try
        {
            con = this.getConnection();
            String query = "SELECT * FROM student WHERE studentID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, studentID);
            rs = ps.executeQuery();

            if(rs.next())
            {
                String resultID = rs.getString("student_id");
                String firstName = rs.getString("name");
                String lastName = rs.getString("last_name");

                s = new Student(resultID, firstName, lastName);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("findStudentByStudentID() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return s;
    }
}
