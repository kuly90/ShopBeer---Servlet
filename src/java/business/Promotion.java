
package business;

import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Promotion {
    private String beerID;
    private String promotionID;
    private double  discount;
    private LocalDate dateStart;
    private LocalDate dateEnd;

    public Promotion() {
    }

    public Promotion(String beerID, String promotionID, double discount, LocalDate dateStart, LocalDate dateEnd) {
        this.beerID = beerID;
        this.promotionID = promotionID;
        this.discount = discount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Promotion(String beerID, double discount, LocalDate dateStart, LocalDate dateEnd) {
        this.beerID = beerID;
        this.discount = discount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    
    public String getBeerID() {
        return beerID;
    }

    public void setBeerID(String beerID) {
        this.beerID = beerID;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }
    
     public String getFormattedDiscount(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String discountFormatted = currency.format(discount);
        return discountFormatted;
    }
    
     public Date getDateStartFormatted() {
        dateStart = getDateStart();       
        return java.sql.Date.valueOf(dateStart);
     }
     
     public Date getDateEndFormatted() {
        dateEnd = getDateEnd();       
        return java.sql.Date.valueOf(dateEnd);
     }
}
