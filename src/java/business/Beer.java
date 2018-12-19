
package business;

import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Beer implements Serializable {
    private String beerID;
    private String beerName;
    private double price;
    private String image;
    private int quantityInS;
    private String brandID;
    private LocalDate dateJoin;
    private String detail;
    private double discount;
    private String information;
            
    public Beer(){
        
    }

    public Beer(String beerID, String beerName, double price) {
        this.beerID = beerID;
        this.beerName = beerName;
        this.price = price;
    }
    

    public Beer(String beerName, double price, String image, double discount) {
        this.beerName = beerName;
        this.price = price;
        this.image = image;
        this.discount = discount;
    }

    public Beer(String beerID, String beerName, double price, String image, int quantityInS, String brandID, LocalDate dateJoin, String detail) {
        this.beerID = beerID;
        this.beerName = beerName;
        this.price = price;
        this.image = image;
        this.quantityInS = quantityInS;
        this.brandID = brandID;
        this.dateJoin = dateJoin;
        this.detail = detail;
    }
    
    public Beer(String beerID, String beerName, double price, String image, int quantityInS, String brandID, LocalDate dateJoin, String detail, double discount) {
        this.beerID = beerID;
        this.beerName = beerName;
        this.price = price;
        this.image = image;
        this.quantityInS = quantityInS;
        this.brandID = brandID;
        this.dateJoin = dateJoin;
        this.detail = detail;
        this.discount = discount;
    }

    public Beer(String beerID, String beerName, double price, String image, int quantityInS, String brandID, LocalDate dateJoin, String detail, double discount, String information) {
        this.beerID = beerID;
        this.beerName = beerName;
        this.price = price;
        this.image = image;
        this.quantityInS = quantityInS;
        this.brandID = brandID;
        this.dateJoin = dateJoin;
        this.detail = detail;
        this.discount = discount;
        this.information = information;
    }

    public Beer(String beerID, String beerName, double price, String image, int quantityInS, String brandID, LocalDate dateJoin, String detail, String information) {
        this.beerID = beerID;
        this.beerName = beerName;
        this.price = price;
        this.image = image;
        this.quantityInS = quantityInS;
        this.brandID = brandID;
        this.dateJoin = dateJoin;
        this.detail = detail;
        this.information = information;
    }
    
    

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    

    public int getQuantityInS() {
        return quantityInS;
    }

    public void setQuantityInS(int quantityInS) {
        this.quantityInS = quantityInS;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }
    
    
    public Beer(String beerName, double price, String image) {
        this.beerName = beerName;
        this.price = price;
        this.image = image;
    }
   

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBeerID() {
        return beerID;
    }

    public void setBeerID(String beerID) {
        this.beerID = beerID;
    }

    public LocalDate getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(LocalDate dateJoin) {
        this.dateJoin = dateJoin;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public double getSalePrice(){
        price = getPrice();
        discount = getDiscount();
        return (price - discount);
    }
    
    public String getFormattedSalePrice(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String priceFormatted = currency.format(price - discount);
        return priceFormatted;
    }
    
    public String getFormattedPrice(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String priceFormatted = currency.format(price);
        return priceFormatted;
    }
    
    public String getFormattedDPrice(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String priceFormatted = currency.format(discount);
        return priceFormatted;
    }
    
    public Date getDateJoinFormatted() {
        dateJoin = getDateJoin();       
        return java.sql.Date.valueOf(dateJoin);
    }
}
