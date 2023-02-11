package com.dkit.gd2.johnloane.dao;

import com.dkit.gd2.johnloane.dto.Result;
import com.dkit.gd2.johnloane.exceptions.DAOException;

import java.util.List;

public interface IResultDAOInterface
{
    public boolean deleteResult(String studentID) throws DAOException;
    public List<Result> getAllResults(String studentID) throws DAOException;
    public boolean registerResult(Result r, String studentID) throws DAOException;
}
