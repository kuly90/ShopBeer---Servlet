package data;

import business.LineItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDB {

    public static boolean InsertOrderDetail(int orderID, List<LineItem> items) {
        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Insert into OrderDetails Values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            for (LineItem item : items) {
                ps.setString(1, item.getBeer().getBeerID());
                ps.setInt(2, item.getQuantity());
                ps.setDouble(3, item.getBeer().getPrice());
                ps.setDouble(4, item.getBeer().getDiscount());
                ps.setInt(5, orderID);
                ps.executeUpdate();
            }
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return t;
    }
}
