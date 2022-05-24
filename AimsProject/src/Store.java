
public class Store {
	private int MAX_NUMBERS_ORDERED = 100000;
    private DigitalVideoDisc itemsInStore[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0 ; 
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED) {
    		System.out.println("The store is almost full ") ;
    	} else {
    		qtyOrdered += 1 ;
    		for (int i = 0 ;i < MAX_NUMBERS_ORDERED;i++) {
    			if (itemsInStore[i]== null)  {
    				itemsInStore[i] = disc ;
    	    		System.out.println("The disc has been added");
    	    		break ;
    			}
    		}
    	}
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	for(int i = 0 ; i < MAX_NUMBERS_ORDERED; i++) {
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
}
