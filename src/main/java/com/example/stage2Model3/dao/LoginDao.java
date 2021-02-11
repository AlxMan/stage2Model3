package com.example.stage2Model3.dao;

import com.example.stage2Model3.entity.Login;

import java.sql.*;

public class LoginDao {
    public static int login(Login login) {
        //登录成功与否的标识  -1:系统异常，0：用户名或密码有误，1：登录成功
        int flag=-1;
        int result =-1;
        Connection connection =null;
        PreparedStatement pstmt =null;
        ResultSet rs =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Ctrl+1自动返回
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&characterEncoding=utf-8","root","123456");
            String sql="Select count(*) from login where name=? and pwd =?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, login.getName());
            pstmt.setString(2, login.getPassWord());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                result =rs.getInt(1);
            }
            if(result>0) {
                flag= 1;
            }else {
                flag=0;
            }
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            flag=-1;
        }catch(SQLException e) {
            e.printStackTrace();
            flag=-1;
        }catch(Exception e) {
            e.printStackTrace();
            flag=-1;
        }finally {
            try {
                if(rs!=null) rs.close();
                if(pstmt!=null) pstmt.close();
                if(connection!=null) connection.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }catch(Exception e) {
                e.printStackTrace();
            }


        }
        return flag;
    }
}
