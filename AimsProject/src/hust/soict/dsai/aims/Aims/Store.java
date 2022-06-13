package hust.soict.dsai.aims.Aims;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    public static final int MAX_NUMBERS=100000;
    private static int qtyOrdered = 0 ; 
    private static ArrayList<Media> itemsInStore= new ArrayList<Media>();
    public void addMedia(Media disc) {
    	if (qtyOrdered == MAX_NUMBERS  ) {
    		System.out.println("The cart is almost full ") ;
    	} else {
    		qtyOrdered += 1 ;
    		itemsInStore.add(disc) ;
        	System.out.println("The disc has been added");
   			}
    	}
    	
 
    public static void removeMedia(Media disc) {
    	for(int i = 0 ; i < MAX_NUMBERS; i++) {
    		if (itemsInStore.get(i).getTitle().equals(disc.getTitle()) ) {
    			itemsInStore.remove(i);
    			qtyOrdered -= 1;
    			String var = ""+qtyOrdered ;
	    		System.out.println("The disc has been removed");
	    		System.out.println("The number of disc remained is "+var);
    			break ;
    		}
    	}
    }
	public static void display() {
		System.out.println("Display all the dvds available in the store");
		for (int i = 0; i < MAX_NUMBERS ; i++) {
			System.out.println(itemsInStore.get(i).toString());
		}
	}

	public static  Media searchByTitle(String title) {
		Media DVD = null;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsInStore.get(i).isMatch(title)) {
				DVD = itemsInStore.get(i);
			}
		}
		return DVD;
	}
}
