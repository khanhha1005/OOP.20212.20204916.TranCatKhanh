package hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest{
    public static void main(String[]args){
            // Createanew cart
            Cart cart=new Cart();
            // Create new dvd objects and add them to the cart
            DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King",
                    "Animation","Roger Allers",87,19.95f);
            cart.addDigitalVideoDisc(dvd1);
            DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars",
                    "Science Fiction","George Lucas",87,24.95f);
            cart.addDigitalVideoDisc(dvd2);
            DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladin",
                    "Animation",18.99f);
            cart.addDigitalVideoDisc(dvd3);

    		DigitalVideoDisc dvd4 = new DigitalVideoDisc("King Kong", "Action", 20.99f);
    		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spider-Man", "Action", 20.99f);
            cart.addDigitalVideoDisc(dvd4);
            cart.addDigitalVideoDisc(dvd5);


            // Test the print method
            cart.print();
            // To-do:Test the search methods here
    }
}