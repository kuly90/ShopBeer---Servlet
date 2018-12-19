package data;

import business.Beer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeerDB {

    public static List<Beer> getBeerHeineken() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName, price, image, discount from Beers b join Promotions p on b.beerID = p.beerID where brandID = 'HNK'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                Beer b = new Beer(beerName, price, image);
                beers.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getBeerTiger() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName, price, image, discount from Beers b join Promotions p on b.beerID = p.beerID where brandID= 'BVN1'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                double discount = rs.getDouble("discount");
                Beer b = new Beer(beerName, price, image, discount);
                beers.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getBeerLarue() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName, price, image, discount from Beers b join Promotions p on b.beerID = p.beerID where brandID = 'BVN'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                double discount = rs.getDouble("discount");
                Beer b = new Beer(beerName, price, image, discount);
                beers.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getBeerSG() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName, price, image, discount from Beers b join Promotions p on b.beerID = p.beerID where brandID = 'SG'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                double discount = rs.getDouble("discount");
                Beer b = new Beer(beerName, price, image, discount);
                beers.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getBeerHuda() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName, price, image, discount from Beers b join Promotions p on b.beerID = p.beerID where brandID= 'BH'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                double discount = rs.getDouble("discount");
                Beer b = new Beer(beerName, price, image, discount);
                beers.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getBeerKhac() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName, price, image, discount from Beers b join Promotions p on b.beerID = p.beerID where brandID = 'BK'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                double discount = rs.getDouble("discount");
                Beer b = new Beer(beerName, price, image, discount);
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
        String sqlString = "Select b.beerID, beerName, detail, quantityInStore,price, brandID ,image,dateJoin,discount,information from Beers b join Promotions p on b.beerID = p.beerID where beerName = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, beerName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String beerID = rs.getString("beerID");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                int quantityS = rs.getInt("quantityInStore");
                String brandID = rs.getString("brandID");
                String detail = rs.getString("detail");
                double discount = rs.getDouble("discount");
                String information = rs.getString("information");
                b = new Beer(beerID, beerName, price, image, quantityS, brandID, null, detail, discount, information);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return b;
    }

    public static List<Beer> search(String textsearch) {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select * from Beers where beerName LIKE '%" + textsearch + "%'";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");

                Beer b = new Beer(beerName, price, image);
                beers.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getHotBeer() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName,price, image\n"
                + "from Beers b join (select Top 3 beerID, sum(quantity) as TotalQuantity\n"
                + "				from Orderdetails\n"
                + "                group by beerID\n"
                + "                order by TotalQuantity desc) t\n"
                + "on b.beerID = t.beerID";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                Beer b = new Beer(beerName, price, image);
                beers.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getSaleBeer() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "Select beerName, price, image,discount\n"
                + "from Beers b join (select Top 3 beerID,discount\n"
                + "				from promotions\n"
                + "                order by discount desc) t\n"
                + "on b.beerID = t.beerID";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                double discount = rs.getDouble("discount");
                Beer b = new Beer(beerName, price, image, discount);
                beers.add(b);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return beers;
    }

    public static List<Beer> getNewBeer() {
        List<Beer> beers = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "select top 3 beerName,price,image,discount\n"
                + "from Beers b join Promotions p on b.beerID = p.beerID\n"
                + "ORDER BY dateJoin desc";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String beerName = rs.getString("beerName");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                double discount = rs.getDouble("discount");
                Beer b = new Beer(beerName, price, image, discount);
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
