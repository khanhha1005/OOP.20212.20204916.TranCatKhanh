import java.io.*;
import java.util.*;
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
    		for (int i = 1;i < MAX_NUMBERS_ORDERED;i++) {
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
    		if (itemsOrdered[i] == disc ) {
    			itemsOrdered[i] = null ;
	    		System.out.println("The disc has been removed");
    			break ;
    		}
    	}
    }
}
/*public void totalCost() {
	private int sum = 0;
	for (int i = 0 ; i < MAX_NUMBERS_ORDERED;i++) {
		if (itemsOrdered[i] != null) {
			sum += 
			return sum 
		}
	}
}*/