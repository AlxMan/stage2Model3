package com.example.stage2Model3.dao;

import com.example.stage2Model3.entity.Student;

import java.sql.*;

public class StudentDao {
    private static final String URL="jdbc:mysql://localhost:3306/login?serverTimezone=UTC&characterEncoding=utf-8";
    private static final String UNAME="root";
    private static final String UPWD="123456";
    public static Connection getConn () {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, UNAME, UPWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try {
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(pstmt!=null)
                pstmt.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(rs!=null)
                rs.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void closePart(Connection conn,PreparedStatement pstmt)
    {
        try {
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(pstmt!=null)
                pstmt.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean AddStudent(Student student) {
        boolean flag = false;
        String sql="insert into student(sno,sname,sage,shobby) values(?,?,?,?)" ;
        Connection conn = StudentDao.getConn();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getBirthday());
            int count = pstmt.executeUpdate();
            if(count>0) {
                flag=true;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            StudentDao.closePart(conn, pstmt);
        }

        return flag;
    }

    public static boolean isExist(int sno) {
        return Query(sno)==null? false:true;
    }
    public static Student Query(int id) {
        Student student= null;
        String sql="select * from student where sno =?" ;
        Connection conn = StudentDao.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                int no=rs.getInt("id");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                String birthday=rs.getString("birthday");
                student= new Student(id,name,sex,birthday);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            StudentDao.closeAll(conn, pstmt, rs);
        }
        return student;
    }
}
