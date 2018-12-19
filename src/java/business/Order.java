package business;

import java.sql.Date;
import java.time.LocalDate;

public class Order {
    private String orderID;
    private LocalDate dateOrder;
    private String custName;
    private String custMail;
    private String custPhone;
    private String custAddress;
    private String status;
    private Cart cart;
    
    public Order(){
        
    }

    public Order(String orderID, LocalDate dateOrder, String custName, String custMail, String custPhone, String custAddress, String status) {
        this.orderID = orderID;
        this.dateOrder = dateOrder;
        this.custName = custName;
        this.custMail = custMail;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.status = status;
    }
    
    public Order(LocalDate dateOrder, String custName, String custMail, String custPhone, String custAddress, Cart cart) {
        this.dateOrder = dateOrder;
        this.custName = custName;
        this.custMail = custMail;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.cart = cart;
    }        

    public Order(LocalDate dateOrder, String custName, String custMail, String custPhone, String custAddress) {
        this.dateOrder = dateOrder;
        this.custName = custName;
        this.custMail = custMail;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }   

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustMail() {
        return custMail;
    }

    public void setCustMail(String custMail) {
        this.custMail = custMail;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }   
    
    public Date dateOrderConvert(){
        dateOrder = getDateOrder();
        return java.sql.Date.valueOf(dateOrder);
    }
}
