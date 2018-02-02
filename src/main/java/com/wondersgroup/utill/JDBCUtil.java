package com.wondersgroup.utill;

import java.sql.*;

/**
 * 传统jdbc方式访问数据库工具类
 */
public class JDBCUtil {
    /**
     * 等到Connection连接
     */
    public static Connection getConnection() throws Exception {
        String url="jdbc:mysql:///spring_data";
        String user="root";
        String password="123456";
        String driverClass="com.mysql.jdbc.Driver";
        Class.forName(driverClass);
        Connection connection=DriverManager.getConnection(url,user,password);
        return connection;
    }

    /**
     * 释放jdbc连接
     * @param connection
     * @param statement
     * @param resultSet
     */
    public  static void  release(Connection connection, Statement statement, ResultSet resultSet){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {

            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
