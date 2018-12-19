package data;

import business.Promotion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PromotionDB {

    public static List<Promotion> getPromotions() {

        List<Promotion> promotions = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Promotions";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerID = rs.getString("beerID");
                String promotionID = rs.getString("promotionID");
                double discount = rs.getDouble("discount");
                Date dateStartString = rs.getDate("dateStart");
                LocalDate dateStart = dateStartString.toLocalDate();
                Date dateEndString = rs.getDate("dateEnd");
                LocalDate dateEnd = dateEndString.toLocalDate();

                Promotion p = new Promotion(beerID, promotionID, discount, dateStart, dateEnd);
                promotions.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return promotions;
    }

    public static Promotion getPromotion(String beerID) {
        Promotion p = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Promotions where beerID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, beerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String promotionID = rs.getString("promotionID");
                double discount = rs.getDouble("discount");
                Date dateStartString = rs.getDate("dateStart");
                LocalDate dateStart = dateStartString.toLocalDate();
                Date dateEndString = rs.getDate("dateEnd");
                LocalDate dateEnd = dateEndString.toLocalDate();

                p = new Promotion(beerID, promotionID, discount, dateStart, dateEnd);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return p;
    }

    public static boolean updatePromotion(Promotion p) {

        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Update Promotions Set discount=?,"
                + "dateStart = ? ,"
                + "dateEnd = ? "
                + "Where beerID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setDouble(1, p.getDiscount());
            ps.setDate(2, p.getDateStartFormatted());
            ps.setDate(3, p.getDateEndFormatted());
            ps.setString(4, p.getBeerID());

            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }

        return t;
    }

    public static boolean deletePromotion(String beerID) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        String sqlString = "Delete Promotions Where beerID = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, beerID);
            ps.executeUpdate();

            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean insertPromotion(Promotion p) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Insert into Promotions Values(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, p.getBeerID());
            ps.setString(2, p.getPromotionID());
            ps.setDouble(3, p.getDiscount());
            ps.setDate(4, p.getDateStartFormatted());
            ps.setDate(5, p.getDateEndFormatted());

            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static List<Promotion> search(String textsearch) {
        List<Promotion> promotions = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Promotions where beerID LIKE '%" + textsearch + "%'"
                + " or promotionID LIKE '%" + textsearch + "%' or discount LIKE '%" + textsearch + "%'"
                + "or dateStart LIKE '%" + textsearch + "%' or dateEnd LIKE '%" + textsearch + "%'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String beerID = rs.getString("beerID");
                String promotionID = rs.getString("promotionID");
                double discount = rs.getDouble("discount");
                Date dateStartString = rs.getDate("dateStart");
                LocalDate dateStart = dateStartString.toLocalDate();
                Date dateEndString = rs.getDate("dateEnd");
                LocalDate dateEnd = dateEndString.toLocalDate();

                Promotion p = new Promotion(beerID, promotionID, discount, dateStart, dateEnd);
                promotions.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return promotions;
    }
}
