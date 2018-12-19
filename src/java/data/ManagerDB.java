package data;

import business.Beer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ManagerDB {

    public static List<Beer> getBeers() {

        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Beers";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerID = rs.getString("beerID");
                String beerName = rs.getString("beerName");
                String detail = rs.getString("detail");
                int quantiyInstore = rs.getInt("quantityInStore");
                double price = rs.getDouble("price");
                String brandID = rs.getString("brandID");
                String image = rs.getString("image");
                Date dateJoinString = rs.getDate("dateJoin");
                LocalDate dateJoin = dateJoinString.toLocalDate();

                Beer b = new Beer(beerID, beerName, price, image, quantiyInstore, brandID, dateJoin, detail);
                beers.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static Beer getBeer(String beerName) {
        Beer b = null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Beers where beerName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, beerName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String beerID = rs.getString("beerID");
                String detail = rs.getString("detail");
                int quantiyInstore = rs.getInt("quantityInStore");
                double price = rs.getDouble("price");
                String brandID = rs.getString("brandID");
                String image = rs.getString("image");
                Date dateJoinString = rs.getDate("dateJoin");
                LocalDate dateJoin = dateJoinString.toLocalDate();

                b = new Beer(beerID, beerName, price, image, quantiyInstore, brandID, dateJoin, detail);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return b;
    }

    public static boolean updateBeer(Beer b) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Update Beers Set beerName=? ,"
                + "detail = ? ,"
                + "quantityInStore = ? ,"
                + "price = ? ,"
                + "brandID = ? ,"
                + "image = ? ,"
                + "dateJoin = ? "
                + "Where beerID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, b.getBeerName());
            ps.setString(2, b.getDetail());
            ps.setInt(3, b.getQuantityInS());
            ps.setDouble(4, b.getPrice());
            ps.setString(5, b.getBrandID());
            ps.setString(6, b.getImage());
            ps.setDate(7, b.getDateJoinFormatted());
            ps.setString(8, b.getBeerID());
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean deleteBeer(String beerName) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        String sqlString = "Delete Beers Where beerName = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, beerName);
            ps.executeUpdate();

            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean insertBeer(Beer b) {
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Insert into Beers Values(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, b.getBeerID());
            ps.setString(2, b.getBeerName());
            ps.setString(3, b.getDetail());
            ps.setInt(4, b.getQuantityInS());
            ps.setDouble(5, b.getPrice());
            ps.setString(6, b.getBrandID());
            ps.setString(7, b.getImage());
            ps.setDate(8, b.getDateJoinFormatted());
            ps.setString(9, b.getInformation());
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static List<Beer> search(String textsearch) {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Beers where beerID LIKE '%" + textsearch + "%'"
                + " or beerName LIKE '%" + textsearch + "%' or detail LIKE '%" + textsearch + "%'"
                + "or quantityInStore LIKE '%" + textsearch + "%' or price LIKE '%" + textsearch + "%'"
                + "or brandID LIKE '%" + textsearch + "%'     ";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String beerID = rs.getString("beerID");
                String beerName = rs.getString("beerName");
                String detail = rs.getString("detail");
                int quantiyInstore = rs.getInt("quantityInStore");
                double price = rs.getDouble("price");
                String brandID = rs.getString("brandID");
                String image = rs.getString("image");
                Date dateJoinString = rs.getDate("dateJoin");
                LocalDate dateJoin = dateJoinString.toLocalDate();

                Beer b = new Beer(beerID, beerName, price, image, quantiyInstore, brandID, dateJoin, detail);
                beers.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

}
