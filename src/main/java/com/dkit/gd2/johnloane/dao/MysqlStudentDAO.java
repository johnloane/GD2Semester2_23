package com.dkit.gd2.johnloane.dao;

import com.dkit.gd2.johnloane.dto.Result;
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

    @Override
    public boolean registerStudent(Student s) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try
        {
            con = this.getConnection();
            String query = "INSERT INTO student (student_id, first_name, last_name) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, s.getStudentID());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            result = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DAOException("registerStudent() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return result == 1;
    }

    @Override
    public boolean deleteStudent(String studentID) throws DAOException
    {
        MysqlResultDAO resultDAO = new MysqlResultDAO();
        resultDAO.deleteResult(studentID);

        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try
        {
            con = this.getConnection();
            String query = "DELETE FROM student WHERE student_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, studentID);
            result = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DAOException("deleteStudent() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return result == 1;
    }

    public boolean updateStudent(Student s) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        try
        {
            con = this.getConnection();
            String query = "UPDATE student SET first_name = ?, last_name = ? WHERE student_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, s.getStudentID());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            result = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DAOException("updateStudent() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return result == 1;
    }

    public boolean updateStudentID(Student s, String previousID) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;

        MysqlResultDAO resultDAO = new MysqlResultDAO();
        List<Result> tempResults = resultDAO.getAllResults(previousID);
        resultDAO.deleteResult(previousID);

        try
        {
            con = this.getConnection();
            String query = "UPDATE student SET student_id = ?, first_name = ?, last_name = ? WHERE student_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, s.getStudentID());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            ps.setString(4, previousID);
            result = ps.executeUpdate();

            for(Result r : tempResults)
            {
                resultDAO.registerResult(r, s.getStudentID());
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("updateStudent() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return result == 1;
    }

}
