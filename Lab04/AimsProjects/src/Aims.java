
public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        //print total cost of the items in the cart
        DigitalVideoDisc[] dvdList = {dvd1,dvd2,dvd3} ;
        anOrder.addDigitalVideoDisc(dvdList);
        anOrder.addDigitalVideoDisc(dvd1,dvd2);
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
