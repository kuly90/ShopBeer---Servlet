
package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Compare implements Serializable{
    private List<LineItem> items;
    
    public Compare(){
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
}
