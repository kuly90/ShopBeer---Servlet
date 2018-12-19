package data;

import business.NewOrder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NewOrderDB {

    public static List<NewOrder> getNewOrder() {
        List<NewOrder> orders = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerID, quantity, price, discount, custName,custAddress, custPhone, custEmail, orderDate, b.orderID from Orderdetails b  join Orders o \n"
                + "on b.orderID = o.orderID\n"
                + "where b.orderID = (select max(orderID) as maxa from OrderDetails) ";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String beerID = rs.getString("beerID");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                String custName = rs.getString("custName");
                String custPhone = rs.getString("custPhone");
                String custAddress = rs.getString("custAddress");
                String custEmail = rs.getString("custEmail");
                Date orderDate = rs.getDate("orderDate");
                LocalDate dateJoin = orderDate.toLocalDate();
                String orderID = rs.getString("orderID");
                NewOrder no = new NewOrder(custName, custAddress, custPhone, custEmail, dateJoin, beerID, quantity, price, discount, orderID);
                orders.add(no);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return orders;
    }
}
