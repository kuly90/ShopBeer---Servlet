package business;

import java.text.NumberFormat;
import java.time.LocalDate;

public class NewOrder {

    private String custName;
    private String custAddress;
    private String custPhone;
    private String custEmail;
    private LocalDate orderDate;
    private String beerID;
    private int quantity;
    private double price;
    private double discount;
    private String orderID;
    
    public NewOrder() {

    }

    public NewOrder(String custName, String custAddress, String custPhone, String custEmail, LocalDate orderDate, String beerID, int quantity, double price, double discount, String orderID) {
        this.custName = custName;
        this.custAddress = custAddress;
        this.custPhone = custPhone;
        this.custEmail = custEmail;
        this.orderDate = orderDate;
        this.beerID = beerID;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
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
    
    public double getTotal(){
        return quantity * (price - discount);
    }
    
    public String getTotalFormatted(){
        NumberFormat currency= NumberFormat.getCurrencyInstance();
        String totalFormatted= currency.format(getTotal());
        return totalFormatted;
    }
}
