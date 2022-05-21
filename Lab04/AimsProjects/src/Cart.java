
public class Cart{
    public static final int MAX_NUMBERS_ORDERED=20;
    private DigitalVideoDisc itemsOrdered[]=
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0 ; 
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED  ) {
    		System.out.println("The cart is almost full ") ;
    	} else {
    		qtyOrdered += 1 ;
    		for (int i = 0 ;i < MAX_NUMBERS_ORDERED;i++) {
    			if (itemsOrdered[i]== null)  {
    				itemsOrdered[i] = disc ;
    	    		System.out.println("The disc has been added");
    	    		break ;
    			}
    		}
    	}
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	for(int i = 0 ; i < MAX_NUMBERS_ORDERED; i++) {
    		if (itemsOrdered[i].getTitle().equals(disc.getTitle()) ) {
    			itemsOrdered[i] = null ;
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
			if (itemsOrdered[i] != null) {
				cost += itemsOrdered[i].getCost();
			}
		}
		return cost;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED  ) {
    		System.out.println("The cart is almost full ") ;
    	} else {
    		qtyOrdered += dvdList.length ;
    		int k = 0 ;
    		for (int i = 0 ;i < MAX_NUMBERS_ORDERED;i++) {
    			if (k < dvdList.length) {
	    			if (itemsOrdered[i]== null )   {
	    				itemsOrdered[i] = dvdList[k] ;
	    				k+= 1 ;
	    			}
    			} else {
    				System.out.println("The discs have been added");
    				break;
    			}
    		}
    	}
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	if (qtyOrdered == MAX_NUMBERS_ORDERED  ) {
    		System.out.println("The cart is almost full ") ;
    	} else {
    		qtyOrdered += 2 ;
    		for (int i = 1;i < MAX_NUMBERS_ORDERED;i++) {
    			if (itemsOrdered[i]== null)  {
    				itemsOrdered[i] = dvd1 ;
    				itemsOrdered[i+1] = dvd2 ;
    	    		System.out.println("The discs have been added");
    	    		break ;
    			}
    		}
    	}
    }
}