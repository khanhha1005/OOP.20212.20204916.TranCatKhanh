package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    		if (itemsOrdered.size()== 0)  {
    			itemsOrdered.add(disc) ;
        		System.out.println("The disc has been added");
   			}
    	}
    	
    }
    public void removeMedia(Media disc) {
    	for(int i = 0 ; i < MAX_NUMBERS_ORDERED; i++) {
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
		for (int i = 0 ; i < MAX_NUMBERS_ORDERED;i++) {
			if (itemsOrdered.get(i) != null) {
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
    		for (int i = 0 ;i < MAX_NUMBERS_ORDERED;i++) {
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
	public boolean compareto(Media o,Media j ){
		if (o.getTitle().compareTo(j.getTitle()) > 1){
			return true ;
		}else if (o.getCost()>j.getCost()){
			return true ;
		} else if (o.getLength()< j.getLength()) {
			return true ;
		}
		return false;
	}
	public boolean compareto1(Media o,Media j ){
		if (o.getTitle().compareTo(j.getTitle()) > 1){
			return true ;
		}else if (o.getCost()>j.getCost()){
			return true ;
		}
		return false;
	}

	public boolean compareto3(Media o,Media j ){
		if (o.getCost()<j.getCost()){
			return true ;
		}else if (o.getCost()==j.getCost() && o.getTitle().compareTo(j.getTitle()) >= 1){
			return true ;
		}
		return false;
	}
	public void sortByCostCart (Media [] dvdList) {
		System.out.println(" Sort by Cost in Cart :") ;
		for (int i = 0; i < dvdList.length - 1; i++) {
		    for (int j = i + 1; j < dvdList.length; j++) {
		        if (compareto3(dvdList[i],dvdList[j])) {
		            Media temp_dvdList12 = dvdList[i];
		            dvdList[i] = dvdList[j];
		            dvdList[j] = temp_dvdList12;
		        }
		    }
		}
        for(int i=0;i<dvdList.length;i++){
        	if (dvdList[i] != null){
            System.out.println(dvdList[i].toString());
        	}
        }
	}
	public void sortByTitleCart(Media[] dvdList12) {
		System.out.println(" Sort by Title in Cart :") ;
		for (int i = 0; i < dvdList12.length - 1; i++) {
		    for (int j = i + 1; j < dvdList12.length; j++) {
		        if (compareto1(dvdList12[i],dvdList12[j])) {
		            Media temp_dvdList12 = dvdList12[i];
		            dvdList12[i] = dvdList12[j];
		            dvdList12[j] = temp_dvdList12;
		        }
		    }
		}
        for(int i=0;i<dvdList12.length;i++){
        	if (dvdList12[i] != null){
            System.out.println(dvdList12[i].toString());
        	}
        }
	}
	public void searchById(int id) {
		System.out.println(" Search by Id :") ;
		int  k = 0 ;
		for (int i = 0 ; i < MAX_NUMBERS_ORDERED;i++) {
			if  (itemsOrdered.get(i) != null) {
				if (itemsOrdered.get(i).getId() == id) {
					k += 1 ;
					System.out.println(itemsOrdered.get(i).toString());
					break;
				}
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
	

	public void print() {
		System.out.println(" Sort by Title,Cost,Length  in Cart :") ;
		System.out.println("**************************CART**************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered - 1; i++) {
		    for (int j = i + 1; j < qtyOrdered; j++) {
		        if (compareto(itemsOrdered[i],itemsOrdered[j])) {
		            Media temp_dvdList12 = itemsOrdered[i];
		            itemsOrdered[i] = itemsOrdered[j];
		            itemsOrdered[j] = temp_dvdList12;
		        }
		    }
		}
        for(int i=0;i<qtyOrdered;i++){
        	if (itemsOrdered[i] != null){
            System.out.println(String.format("%2d", i + 1)+"."+ itemsOrdered[i].toString());
        	}
        }
		System.out.println(String.format("Total cost: %.3f", this.totalCost()));
		System.out.println("*********************************************************");
	}
}

