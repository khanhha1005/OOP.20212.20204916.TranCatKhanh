package hust.soict.dsai.aims.screen.customer.screen.controller;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javax.naming.LimitExceededException;


public class ItemController {
	private Media media;
    private Cart cart ;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
        Alert a = new Alert(Alert.AlertType.NONE);
        Alert a1 = new Alert(Alert.AlertType.NONE,
                "Added to the Cart",ButtonType.OK);
        // show the dialog
        a1.show();
        ViewStoreController.getCart().addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.NONE);
        Alert a1 = new Alert(Alert.AlertType.NONE,
                "The Media "+media.getTitle()+" is playing", ButtonType.OK);
        a1.show();
    }
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost()+" $");
		if(media instanceof Playable) { 
			btnPlay.setVisible(true); 
		}
		else { 
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
		}
	}
}
