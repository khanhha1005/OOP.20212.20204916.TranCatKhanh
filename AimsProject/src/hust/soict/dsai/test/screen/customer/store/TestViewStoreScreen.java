package hust.soict.dsai.test.screen.customer.store;

import java.util.Arrays;
import java.util.List;

import hust.soict.dsai.aims.Aims.Store;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.NegativePriceException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.screen.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.naming.LimitExceededException;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;

	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store,cart);

		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();

		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main (String[] args) throws NegativePriceException, LimitExceededException {
		store = new Store();
		cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars 2", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars 3", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);
		List<String> list = Arrays.asList("one", "two", "three");
		Book c1 = new Book("Star Wars4", "Science Fiction", list, 24.95f,"George Lucas");
		store.addMedia(dvd2);
		store.addMedia(dvd1);
		store.addMedia(dvd3);
		store.addMedia(c1);
		store.addMedia(dvd4);
		store.addMedia(dvd5);
		store.addMedia(dvd10);
		cart.addMedia(dvd10);
		launch(args);
	}
}