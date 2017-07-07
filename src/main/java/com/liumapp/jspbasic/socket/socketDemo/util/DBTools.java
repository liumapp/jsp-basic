package com.liumapp.jspbasic.socket.socketDemo.util;

import com.liumapp.jspbasic.socket.socketDemo.entity.FileEntity;
import com.liumapp.jspbasic.socket.socketDemo.entity.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class DBTools {

    DBUtil dbu = new DBUtil();
    private Connection conn = dbu.getConnection();

    public void close () throws SQLException {
        conn.close();
    }
    /**
     * 用户登录
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean login (User user) throws SQLException {
        String sql = "select * from users where username = ? and password = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1 , user.getUsername());
        ps.setString(2 , user.getPassword());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean register (User user) {
        String sql = "insert into users(username , password) value(? , ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1, user.getUsername());
            ps.setString( 2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 上传文件
     * @param fe
     * @return
     */
    public boolean uploadFile (FileEntity fe) {
        String sql = "insert into file(username , filename , filecontent) value(? , ? , ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1 , fe.getUserName());
            ps.setString( 2 , fe.getFileName());
            ps.setBytes( 3, fe.getFileContent());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 下载文件
     * @param fe
     * @return
     */
    public byte[] downloadFile (FileEntity fe) {
        String sql = "select filecontent from file where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1 , fe.getId());
            ResultSet rs = ps.executeQuery();
            InputStream is = null;
            if (rs.next()) {
                is = rs.getBinaryStream(1);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[is.available()];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer , 0 , len);
                }
                return buffer;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查看文件
     * @param fe
     * @return
     */
    public ArrayList<FileEntity> viewFile (FileEntity fe)  {
        ArrayList<FileEntity> fileList = new ArrayList<FileEntity>();
        String sql = "select id , filename from file where username = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1 , fe.getUserName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fileList.add(new FileEntity(rs.getInt(1) , rs.getString(2)));
            }
            return fileList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 删除文件
     * @param fe
     * @return
     */
    public boolean deleteFile (FileEntity fe) {
        String sql = "delete from file where id = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1 , fe.getId());
            ps.execute();
            if (ps.getUpdateCount() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
