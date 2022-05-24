import java.util.Collections;
import java.util.Comparator;

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
	public void sortByCostCart (DigitalVideoDisc [] dvdList) {
		System.out.println(" Sort by Cost in Cart :") ;
		for (int i = 0; i < dvdList.length - 1; i++) {
		    for (int j = i + 1; j < dvdList.length; j++) {
		        if (dvdList[i].getCost()<dvdList[j].getCost()) {
		            DigitalVideoDisc temp_dvdList12 = dvdList[i];
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
	public void sortByTitleCart(DigitalVideoDisc[] dvdList12) {
		System.out.println(" Sort by Title in Cart :") ;
		for (int i = 0; i < dvdList12.length - 1; i++) {
		    for (int j = i + 1; j < dvdList12.length; j++) {
		        if (dvdList12[i].getTitle().compareTo(dvdList12[j].getTitle()) > 1) {
		            DigitalVideoDisc temp_dvdList12 = dvdList12[i];
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
			if  (itemsOrdered[i] != null) {
				if (itemsOrdered[i].getId() == id) {
					k += 1 ;
					System.out.println(itemsOrdered[i].toString());
					break;
				}
			}
		}
		if (k == 0) {
			System.out.println(" no match is found");
		}
	}
	public boolean compareto(DigitalVideoDisc o,DigitalVideoDisc j ){
		if (o.getTitle().compareTo(j.getTitle()) > 1){
			return true ;
		}else if (o.getCost()<j.getCost()){
			return true ;
		} else if (o.getLength()< j.getLength()) {
			return true ;
		}
		return false;
	}
	public void print() {
		System.out.println(" Sort by Title,Cost,Length  in Cart :") ;
		int l = 0; 
		for (int i = 0; i < MAX_NUMBERS_ORDERED-1; i++) {
		    for (int j = i + 1; j < MAX_NUMBERS_ORDERED; j++) {
		    	if (itemsOrdered[j]!= null) {
		    		l += 1 ;
		        }
		    }
		}
		DigitalVideoDisc itemsOrdered1 [] = new DigitalVideoDisc[l];
		for (int i = 0; i < itemsOrdered1.length - 1; i++) {
		    for (int j = i + 1; j < itemsOrdered1.length; j++) {
		        if (compareto(itemsOrdered1[i],itemsOrdered1[j]) ) {
		            DigitalVideoDisc temp_dvdList12 = itemsOrdered1[i];
		            itemsOrdered1[i] = itemsOrdered1[j];
		            itemsOrdered1[j] = temp_dvdList12;
		        }
		    }
		}
        for(int i1=0;i1<itemsOrdered1.length;i1++){
            System.out.println(itemsOrdered1[i1].toString());
        	}
        }        
	}

