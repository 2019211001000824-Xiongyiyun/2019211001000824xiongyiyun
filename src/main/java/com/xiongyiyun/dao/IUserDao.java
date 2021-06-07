package com.xiongyiyun.dao;

import com.xiongyiyun.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IUserDao {
    public boolean saveUser(Connection con, User user) throws SQLException;
    public int deleteUser(Connection con, User user) throws SQLException;
    public int updateUser(Connection con, User user) throws SQLException;


    public User findById(Connection con, Integer id) throws SQLException;
    public User findByUsernamePassword(Connection con, String username,String password) throws SQLException;
    public List<User> findByUsername(Connection con, String username) throws SQLException;
    public List<User> findByPassword(Connection con, String password) throws SQLException;
    public List<User> findByEmail(Connection con,String email) throws SQLException;
    public List<User> findBysex(Connection con,String sex) throws SQLException;
    public List<User> findBydate(Connection con, Date date) throws SQLException;
    public List<User> findAllUser(Connection con) throws SQLException;


}
