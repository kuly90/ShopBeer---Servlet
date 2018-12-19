package business;
public class OrderDetail {
    
    private String beerID;
    private int quantity;
    private double price;
    private double discount;
    private int orderID;
    
    public OrderDetail(){
        
    }

    public OrderDetail(String beerID, int quantity, double price, double discount, int orderID) {
        this.beerID = beerID;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.orderID = orderID;
    }

    public String getBeerID() {
        return beerID;
    }

    public void setBeerID(String beerID) {
        this.beerID = beerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    
}
