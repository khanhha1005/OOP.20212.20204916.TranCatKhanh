package hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS=100000;
    private static DigitalVideoDisc itemsInStore[]= new DigitalVideoDisc[MAX_NUMBERS];
    private static int qtyOrdered = 0 ; 
    public static void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (qtyOrdered == MAX_NUMBERS) {
    		System.out.println("The store is almost full ") ;
    	} else {
    		qtyOrdered += 1 ;
    		for (int i = 0 ;i < MAX_NUMBERS;i++) {
    			if (itemsInStore[i]== null)  {
    				itemsInStore[i] = disc ;
    	    		System.out.println("The disc has been added");
    	    		break ;
    			}
    		}
    	}
    }
    public static void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	for(int i = 0 ; i < MAX_NUMBERS; i++) {
    		if (itemsInStore[i].getTitle().equals(disc.getTitle()) ) {
    			itemsInStore[i] = null ;
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
			System.out.println(itemsInStore[i].toString());
		}
	}

	public static  DigitalVideoDisc searchByTitle(String title) {
		DigitalVideoDisc DVD = null;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsInStore[i].isMatch(title)) {
				DVD = itemsInStore[i];
			}
		}
		return DVD;
	}
}
