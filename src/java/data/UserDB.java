package data;

import business.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public static List<User> getUsers() {

        List<User> users = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select userName,roleName,status\n"
                + "from UserRole ";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("userName");
                String roleName = rs.getString("roleName");
                int status = rs.getInt("status");
                User u = new User(userName, roleName, null, status);
                users.add(u);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return users;
    }

    public static User getUser(String userName) {
        User u = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from UserRole where userName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String roleName = rs.getString("roleName");
                int status = rs.getInt("status");
                u = new User(userName, roleName, null, status);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return u;
    }

    public static boolean updateUser(String userName) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "update UserRole set status=0,password=123456 where userName=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, userName);
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean updateUser2(String userName) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Update UserRole Set status=1,password=12345 where userName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, userName);
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean add(User user) {
        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String SqlString = "INSERT into UserRole Values(?,?,?,?)";

        try {
            ps = con.prepareStatement(SqlString);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getRoleName());
            ps.setString(3, user.getPassword());
            int i = 1;
            ps.setInt(4, i);

            ps.executeUpdate();
            t = true;

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean deleteUser(String userName) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        String sqlString = "Delete UserRole Where userName = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, userName);
            ps.executeUpdate();

            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
}
