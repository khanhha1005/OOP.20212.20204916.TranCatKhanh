package hust.soict.dsai.aims.Aims;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Aims {
	public static int input(int Num) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		int m = 0 ;
		while(m != 1) {
			try {
				option = sc.nextInt();
		        if(option >= 0 && option <= Num){
		        	m = 1;
		        } 
		        else {
		        	System.out.println("Enter a number from 0 to " + Num);
		        }
		    } 
			catch (InputMismatchException e) {
		        System.out.println("Not valid number  ");
	        	System.out.println("Please enter again ");
		        sc.next();
		    }
	     }
		return option;
	}
    public static void main(String[] args) {

        Cart anOrder = new Cart();
		Scanner sc = new Scanner(System.in);
		Media DVD = null;
		String title1,title2 ,cate1,direc ; 
		int length;
		float cost ;
		int Menu = 1 ;
		int StoreMenu = 1 ;
		int UpdateStore = 1 ;
		int CartMenu = 1;
		int filterCart = 1;
		int sortCart = 1;

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        anOrder.searchById(4);

		Store store = new Store();
		store.addMedia(dvd3);
		store.addMedia(dvd2);
		while (Menu!= 0 ) {
			Aims.showMenu();
			int Option = Aims.input(3);
			if (Option == 0) {
				System.out.println("Application closed");
				Menu = 0;
			}
			if (Option == 2 ) {
				while (UpdateStore != 0) {
					Aims.updateStore();
					int updateOption = Aims.input(2);
					if (updateOption == 1) {
						System.out.println("Enter the title of Disc ");
						title1 = sc.nextLine();
						System.out.println("enter the category");
						cate1 = sc.nextLine();
						System.out.println("enter the director");
						direc = sc.nextLine() ;
						System.out.println("enter the length");
						length = sc.nextInt();
						System.out.println("enter the cost ") ;
						cost = sc.nextFloat();
						Store.addMedia(new DigitalVideoDisc(title1,cate1,direc,length,cost));
					} else if (updateOption == 2) {
						System.out.println("Enter the title of the movie you want to remove") ;
						title2 = sc.nextLine();
						DVD = Store.searchByTitle(title2);
						if (DVD == null) {
							System.out.println("No matching dvd in the store!");
						}
						else {
							Store.removeMedia(DVD);
						}					
					} else {
						UpdateStore = 0 ;
					}
					
				}
			}
			if (Option == 1) {
				while (StoreMenu != 0){
					Aims.storeMenu();
					int OptionStore = Aims.input(3);
					if (OptionStore == 1 ) {
						System.out.println("Enter the title of the Disc to search ");
						DVD = Store.searchByTitle(sc.nextLine());
						if (DVD == null) {
							System.out.println(" No matching dvd in the store!");
						}
						else {
							System.out.println(DVD.toString());
						}
					}else if (OptionStore == 2) {
						System.out.println("Enter the title of the Disc to add");
						if (DVD == null) {
							System.out.println("No matching dvd in the store!");
						}
						else {
							anOrder.addMedia(DVD);		
						}					
					} else if ( OptionStore == 3) {
						StoreMenu = 0 ;
					} else if (OptionStore == 0) {
						StoreMenu = 0 ;
					}
				}
			}
			if (Option == 3) {
				Aims.cartMenu();
				int CartOption = Aims.input(4) ;
				while (CartMenu != 1) {
					if (CartOption == 0) {
						CartMenu = 0 ;
					}
					if (CartOption == 4) {
						System.out.print("Your order has been placed");
						Media luckyitems = anOrder.getALuckyItem();
						if (luckyitems != null) {
							System.out.println("Your lucky items is "+luckyitems.toString());
						}
						anOrder = new Cart();
						CartOption = 0;
					}
					if (CartOption == 1) {
						Aims.filterCart();
						int filterOption = Aims.input(2);
						while (filterCart!= 0) {
							if (filterOption == 0) {
								filterCart = 0;
							}
							if (filterCart == 1) {
								System.out.println("Enter the ID of the DVD:");
								int id ;
								id = sc.nextInt();
								sc.nextLine();
								anOrder.searchById(id);
							}
							if (filterCart == 2) {
								System.out.println("Enter the Title of the DVD:");
								String title;
								title = sc.nextLine();
								anOrder.searchByTitle(title);
							}
						}
					}
					if (CartOption == 2) {
						Aims.sortCart();
						int sortOption = Aims.input(2);
						while (sortCart != 0) {
							if (sortOption == 0) {
								sortCart = 0;
							}
							if (sortOption == 1) {
								anOrder.sortByCostCart();
							}
							if (sortOption == 2) {
								anOrder.sortByTitleCart();
							}
						}
					}
				}
				
			}
		
		}
	}
    

	public static void showMenu(){
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1.View store");
		System.out.println("2.Update store");
		System.out.println("3. See current cart");
		System.out.println("0.Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number:0-1-2-3");
	}
	public static void storeMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1.See a DVD's details");
        System.out.println("2.Add a DVD to cart");
        System.out.println("3.See current cart");
        System.out.println("0.Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number:0-1-2-3");
	}
	public static void cartMenu(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1.Filter DVDs in cart");
		System.out.println("2.Sort DVDs in cart");
		System.out.println("3.Remove DVD from cart");
		System.out.println("4.Place order");
		System.out.println("0.Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number:0-1-2-3-4");
	}
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add DVD(s) to the store");
		System.out.println("2. Remove DVD(s) from the store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void filterCart() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVD(s) by id");
		System.out.println("2. Filter DVD(s) by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void sortCart() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort DVD(s) by title");
		System.out.println("2. Sort DVD(s) by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	}