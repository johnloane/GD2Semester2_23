package com.dkit.gd2.johnloane.dao;

import com.dkit.gd2.johnloane.dto.Result;
import com.dkit.gd2.johnloane.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MysqlResultDAO extends MysqlDAO implements IResultDAOInterface
{
    @Override
    public boolean deleteResult(String studentID) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try
        {
            con = this.getConnection();
            String query = "DELETE FROM result WHERE student_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, studentID);
            int numRowsAffected = ps.executeUpdate();
            if(numRowsAffected >= 1)
            {
                result = true;
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("deleteResult() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return result;
    }

    @Override
    public List<Result> getAllResults(String studentID) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Result> results = new ArrayList<>();

        try
        {
            con = this.getConnection();
            String query = "SELECT * FROM result WHERE student_id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, studentID);
            rs = ps.executeQuery();

            while(rs.next())
            {
                String resultStudentID = rs.getString("student_id");
                String courseID = rs.getString("module_id");
                String grade = rs.getString("mark");

                Result r = new Result(resultStudentID, courseID, grade);
                results.add(r);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("getAllResults() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return results;
    }

    public boolean registerResult(Result r, String studentID) throws DAOException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try
        {
            con = this.getConnection();
            String query = "INSERT INTO result (student_id, module_id, mark) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, studentID);
            ps.setString(2, r.getCourseID());
            ps.setString(3, r.getGrade());
            int numRowsAffected = ps.executeUpdate();
            if(numRowsAffected >= 1)
            {
                result = true;
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("registerResult() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return result;
    }
}
