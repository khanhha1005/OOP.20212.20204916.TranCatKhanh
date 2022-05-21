public class DVDUtils {
	public static String compareByCost( DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (dvd1 == dvd2){
            return ("The same Disc ");
        }
        if (dvd1 == null ) { 
        	return ("The Disc is not exist");
        }
        if (dvd2 == null ) { 
        	return ("The Disc is not exist");
        }
		if (dvd1.getCost() == dvd2.getCost()){
			return ("The Discs have the same price");
		} 
		else if (dvd1.getCost() > dvd2.getCost()) {
			return ("The Disc1 has higher cost than The Disc 2 ");
		} else {
			return ("The Disc2 has higher cost than The Disc 1 ");
		}
	}

}
