package hust.soict.dsai.aims.screen.customer.screen.controller;
import hust.soict.dsai.aims.exception.NonExistItemsException;
import javafx.collections.transformation.FilteredList;


import hust.soict.dsai.aims.Aims.Store;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;

import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static javax.accessibility.AccessibleState.MODAL;


public class CartController {
	private Cart cart;
    private Store store ;
    private boolean filter = true ;
	public CartController(Store store , Cart cart) {
		this.cart = cart ;
        this.store = store;
	}
    @FXML
    private TableColumn<Media,Integer > colMediaId;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;
    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    void ByIDSelected(ActionEvent event) {filter = true;
    }

    @FXML
    void ByTitleSelected(ActionEvent event) {
        filter = false;
    }
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.NONE);
        Alert a1 = new Alert(Alert.AlertType.NONE,
                "The Media "+media.getTitle()+" is playing",ButtonType.OK);
        // show the dialog
        a1.show();
    }
    @FXML
    void btnPlayOrderPressed(ActionEvent event) {
        cart = new Cart();
        Alert a = new Alert(Alert.AlertType.NONE);
        Alert a1 = new Alert(Alert.AlertType.NONE,
                "The Order has been placed",ButtonType.OK);
        // show the dialog
        a1.show();
        tblMedia.setItems(cart.getItemsOrdered());

        costLabel.setText(String.valueOf(cart.totalCost()));

    }
    @FXML
    void btnRemovePressed(ActionEvent event) throws NonExistItemsException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.NONE);
        Alert a1 = new Alert(Alert.AlertType.NONE,
                "Removed from the Cart",ButtonType.OK);
        // show the dialog
        a1.show();
        cart.removeMedia(media);
        costLabel.setText(String.valueOf(cart.totalCost()));

    }


    @FXML
    void btnViewStorePressed(ActionEvent event) throws IOException {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store,cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@FXML
	public void initialize() {
		colMediaId.setCellValueFactory(
				new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		if(cart.getItemsOrdered() != null )
			tblMedia.setItems(cart.getItemsOrdered());
        tblMedia.setItems(cart.sortByID1());


		btnPlay.setVisible(false); 
		btnRemove.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			public void changed(ObservableValue<? extends Media> observable, Media oldvalue, Media newvalue) {
				updateButtonBar(newvalue);
			}
		});
        costLabel.setText(String.valueOf(cart.totalCost()));
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldvalue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
	}
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    void showFilteredMedia(String newValue){
        if (filter == false) {
            FilteredList<Media> filteredMedia = new FilteredList(cart.getItemsOrdered(),p -> true);
            filteredMedia.setPredicate(media -> {
                if (media.getTitle().contains(newValue)) {
                    return true;
                }
                return false;
            });
            tblMedia.setItems(filteredMedia);
        } else {
            FilteredList<Media> filteredMedia = new FilteredList(cart.getItemsOrdered(),p -> true);
            filteredMedia.setPredicate(media -> {
                String lowerCaseFilter = newValue.toLowerCase();
                if (Integer.toString(media.getId()).contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
            tblMedia.setItems(filteredMedia);
        }
    }
}

