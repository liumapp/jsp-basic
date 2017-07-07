package com.liumapp.jspbasic.socket.socketDemo.util;

import java.sql.*;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class DBUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";

    private static final String NAME = "root";

    private static final String PASSWORD = "adminadmin";

    /**
     * 数据库连接
     * @return
     */
    public Connection getConnection () {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL , NAME , PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 数据库连接关闭
     * @param conn
     * @param ps
     * @param rs
     */
    public void close (Connection conn , PreparedStatement ps , ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
