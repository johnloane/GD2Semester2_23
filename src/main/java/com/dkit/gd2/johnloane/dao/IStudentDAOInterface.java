package com.dkit.gd2.johnloane.dao;
import com.dkit.gd2.johnloane.dto.Student;
import com.dkit.gd2.johnloane.exceptions.DAOException;

import java.util.List;

public interface IStudentDAOInterface
{
    public List<Student> findAllStudents() throws DAOException;
    public Student findStudentByStudentID(String studentID) throws DAOException;
}
