
package business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{
    private List<LineItem> items;
    
    public Cart(){
        items = new ArrayList<LineItem>();
    }
    
    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }
    
    public int getCount(){
        return items.size();
    }
    
     public void addItem(LineItem item){
        String beerName = item.getBeer().getBeerName();
        int quantity = item.getQuantity();
        for(LineItem li : items){
            if(li.getBeer().getBeerName().equals(beerName)){
                li.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    
    public void removeItem(LineItem item){
        String beerName = item.getBeer().getBeerName();
        for(LineItem li : items){
            if(li.getBeer().getBeerName().equals(beerName)){
                items.remove(li);
                return;
            }
        }
    }
    
    public void addQuantity(LineItem item){
        String beerName = item.getBeer().getBeerName();
        for(LineItem li : items){
            if(li.getBeer().getBeerName().equals(beerName)){
                li.setQuantity(li.getQuantity()+ 1);
                return;
            }
        }
        items.add(item);
    }
    
    public double getTotalAmount(){
        double sum = 0;
        for(LineItem li : items){
            sum = sum + li.getTotal();
        }
        return sum;
    }
    
    public String getTotalAmountFormatted(){
        NumberFormat currency= NumberFormat.getCurrencyInstance();
        String totalFormatted= currency.format(getTotalAmount());
        return totalFormatted;
    }
}
