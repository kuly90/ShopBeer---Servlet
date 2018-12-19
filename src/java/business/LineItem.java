
package business;

import java.io.Serializable;
import java.text.NumberFormat;

public class LineItem implements Serializable {
    private Beer beer;
    private int quantity;
    
    public LineItem() {
        
    }

    public LineItem(Beer beer, int quantity) {
        this.beer = beer;
        this.quantity = quantity;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotal(){
        return quantity * beer.getSalePrice();
    }
    
    public String getTotalFormatted(){
        NumberFormat currency= NumberFormat.getCurrencyInstance();
        String totalFormatted= currency.format(getTotal());
        return totalFormatted;
    }
}
