package hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartTest{
    public static void main(String[]args){
            // Createanew cart
            Cart cart=new Cart();
            // Create new dvd objects and add them to the cart
            Media dvd1=new DigitalVideoDisc("The Lion King",
                    "Animation","Roger Allers",87,19.95f);
            cart.addMedia(dvd1);
            Media dvd2=new DigitalVideoDisc("Star Wars",
                    "Science Fiction","George Lucas",87,24.95f);
            cart.addMedia(dvd2);




            // Test the print method
            System.out.println(cart.totalCost());
            System.out.println(cart.totalCost());
            // To-do:Test the search methods here
    }
}