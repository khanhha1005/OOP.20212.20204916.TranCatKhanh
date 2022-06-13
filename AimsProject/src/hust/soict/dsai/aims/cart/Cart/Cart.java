package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Media;

public class Cart{
    public static final int MAX_NUMBERS_ORDERED=20;
    private int qtyOrdered = 0 ; 
    private ArrayList<Media> itemsOrdered= new ArrayList<Media>();
    public void addMedia(Media disc) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED  ) {
    		System.out.println("The cart is almost full ") ;
    	} else {
    		qtyOrdered += 1 ;
    		itemsOrdered.add(disc) ;
        	System.out.println("The disc has been added");
   			}
    	}
    	
 
    public void removeMedia(Media disc) {
    	for(int i = 0 ; i < itemsOrdered.size(); i++) {
    		if (itemsOrdered.get(i).getTitle().equals(disc.getTitle()) ) {
    			itemsOrdered.remove(i);
    			qtyOrdered -= 1;
    			String var = ""+qtyOrdered ;
	    		System.out.println("The disc has been removed");
	    		System.out.println("The number of disc remained is "+var);
    			break ;
    		}
    	}
    }
    public float totalCost() {
		float cost = 0;
		for (int i = 0 ; i < itemsOrdered.size();i++) {
				cost += itemsOrdered.get(i).getCost();
		}
		return cost;
    }
    public float totalCostwithluckitems(Media dvd) {
    	float cost = 0 ;
    	for (int i = 0 ; i < itemsOrdered.size();i++) {
    		if (itemsOrdered.get(i) != dvd){
				cost += itemsOrdered.get(i).getCost();
    		}
    	}
		return cost;
    }
    public void addMedia(Media [] dvdList) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED  ) {
    		System.out.println("The cart is almost full ") ;
    	} else {
    		qtyOrdered += dvdList.length ;
    		int k = 0 ;
    		for (int i = 0 ;i < itemsOrdered.size();i++) {
    			if (k < dvdList.length) {
	    			if (itemsOrdered.get(i) == null )   {
	    				itemsOrdered.set(i,dvdList[k]) ;
	    				k+= 1 ;
	    			}
    			} else {
    				System.out.println("The discs have been added");
    				break;
    			}
    		}
    	}
    }
    public void addMedia(Media dvd1, Media dvd2) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED  ) {
    		System.out.println("The cart is almost full ") ;
    	} else {
    		qtyOrdered += 2 ;
    		if (itemsOrdered.size()== 0)  {
    			itemsOrdered.add(dvd2) ;
    			itemsOrdered.add(dvd1) ;
   	    		System.out.println("The discs have been added");
    		}
    	}
    }
	public boolean compareto(DigitalVideoDisc o, DigitalVideoDisc j ){
		if (o.getTitle().compareTo(j.getTitle()) > 1){
			return true ;
		}else if (o.getCost()>j.getCost()){
			return true ;
		} else if (o.getLength()< j.getLength()) {
			return true ;
		}
		return false;
	}
	public void sortByCostCart () {
		System.out.println(" Sort by Cost in Cart :") ;
		itemsOrdered.stream().sorted(Comparator.comparing(Media::getCost).thenComparing(Media::getTitle));
        for(int i=0;i<qtyOrdered;i++){
            System.out.println(itemsOrdered.get(i).toString());
        	
        }
	}
	public void sortByTitleCart() {
		System.out.println(" Sort by Title in Cart :") ;
		itemsOrdered.stream().sorted(Comparator.comparing(Media::getTitle).thenComparing(Media::getCost));
        for(int i=0;i<qtyOrdered;i++){
            System.out.println(itemsOrdered.get(i).toString());
        	
        }
	}
	public void searchById(int id) {
		System.out.println(" Search by Id :") ;
		int  k = 0 ;
		for (int i = 0 ; i < itemsOrdered.size();i++) {
			if (itemsOrdered.get(i).getId() == id) {
				k += 1 ;
				System.out.println(itemsOrdered.get(i).toString());
				break;
			}
			
		}
		if (k == 0) {
			System.out.println(" no match is found");
		}
	}
	public void searchByTitle(String title) {
		boolean found = false;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered.get(i).isMatch(title)) {
				System.out.println(itemsOrdered.get(i));
				found = true;
			}
		}
		if(!found) {
			System.out.println(" no match is found");
		}
	}
	public   Media searchById1(int id) {
		Media DVD = null;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered.get(i).getId() == id) {
				DVD = itemsOrdered.get(i);
			}
		}
		return DVD;
	}
	public   Media searchByTitle1(String title) {
		Media DVD = null;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered.get(i).isMatch(title)) {
				DVD = itemsOrdered.get(i);
			}
		}
		return DVD;
	}
	public Media getALuckyItem() {
		
		int l =(int) Math.random();
		if (itemsOrdered.size()>= 5 ) {
			return itemsOrdered.get(l);
		}
		return null;
		
	}

	public void print() {
		System.out.println(" Sort by Title,Cost,Length  in Cart :") ;
		System.out.println("**************************CART**************************");
		System.out.println("Ordered Items:");
		itemsOrdered.stream().sorted(Comparator.comparing(Media::getTitle).thenComparing(Media::getCost));

        for(int i=0;i<qtyOrdered;i++){
        	if (itemsOrdered.get(i) != null){
            System.out.println(String.format("%2d", i + 1)+"."+ itemsOrdered.get(i).toString());
        	}
        }
		System.out.println(String.format("Total cost: %.3f", this.totalCost()));
		System.out.println("*********************************************************");
	}
}

