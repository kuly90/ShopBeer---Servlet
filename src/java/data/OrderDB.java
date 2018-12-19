package data;

import business.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDB {

    public static boolean confirmOrder(Order o) {
        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Insert into Orders Values(?,?,?,?,?,?)";
        try {
            String statusString = "Non-delivered";
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setDate(1, o.dateOrderConvert());
            ps.setString(2, o.getCustName());
            ps.setString(3, o.getCustMail());
            ps.setString(4, o.getCustPhone());
            ps.setString(5, o.getCustAddress());
            ps.setString(6, statusString);
            ps.executeUpdate();

            int orderID = getLastOrderID();

            if (!OrderDetailDB.InsertOrderDetail(orderID, o.getCart().getItems())) {
                return false;
            }
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static int getLastOrderID() {
        int i = 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select Max(orderID) as LastOrderID from Orders";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = rs.getInt("LastOrderID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return i;
    }

    public static List<Order> orderManagement() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        List<Order> orders = new ArrayList<>();
        String sqlString = "Select * from Orders";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String custName = rs.getString("custName");
                String custPhone = rs.getString("custPhone");
                String custAddress = rs.getString("custAddress");
                String custEmail = rs.getString("custEmail");
                Date orderDate = rs.getDate("orderDate");
                LocalDate dateJoin = orderDate.toLocalDate();
                String orderID = rs.getString("orderID");
                String status = rs.getString("status");
                Order o = new Order(orderID, dateJoin, custName, custEmail, custPhone, custAddress, status);
                orders.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return orders;
    }
    
    public static boolean updateStatus(int orderID) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Update Orders Set status= 'delivered' where orderID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, orderID);           
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
    
    public static boolean deleteOrder(int orderID) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        String sqlString = "Delete Orders Where orderID = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, orderID);
            ps.executeUpdate();

            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
    
    public static List<Order> search(String textsearch) {
        List<Order> orders = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Orders where custName LIKE '%" + textsearch + "%'"
                + " or custEmail LIKE '%"+textsearch+"%' or custPhone LIKE '%"+textsearch+"%'"
                + "or custAddress LIKE '%"+textsearch+"%' or orderDate LIKE '%"+textsearch+"%'"
                + "or orderID LIKE '%"+textsearch+"%'     ";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String custName = rs.getString("custName");
                String custPhone = rs.getString("custPhone");
                String custAddress = rs.getString("custAddress");
                String custEmail = rs.getString("custEmail");
                Date orderDate = rs.getDate("orderDate");
                LocalDate dateJoin = orderDate.toLocalDate();
                String orderID = rs.getString("orderID");
                String status = rs.getString("status");
                Order o = new Order(orderID, dateJoin, custName, custEmail, custPhone, custAddress, status);
                orders.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return orders;
    }
}
