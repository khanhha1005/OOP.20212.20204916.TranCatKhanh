package hust.soict.dsai.aims.utils.DVDUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

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
			return ("The Discs "+dvd1.getTitle() + " and " + dvd2.getTitle()+ " have the same price");
		} 
		else if (dvd1.getCost() > dvd2.getCost()) {
			return ("The Disc "+dvd1.getTitle()+" has higher cost than "+ dvd2.getTitle());
		} else {
			return ("The Disc "+dvd2.getTitle()+" has higher cost than "+ dvd1.getTitle());
		}
	}
	public static String compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (dvd1.getTitle().equals(dvd2.getTitle())){
            return ("The two Discs have the same Title");
        } else {
        	return ("The two Discs have the different Title ");
        }
	} 
	public static DigitalVideoDisc[] sortByCost (DigitalVideoDisc [] dvdList) {
		for (int i = 0; i < dvdList.length - 1; i++) {
		    for (int j = i + 1; j < dvdList.length; j++) {
		        if (dvdList[i].getCost()<dvdList[j].getCost()) {
		            DigitalVideoDisc temp_dvdList12 = dvdList[i];
		            dvdList[i] = dvdList[j];
		            dvdList[j] = temp_dvdList12;
		        }
		    }
		}
		return dvdList;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList12) {
		for (int i = 0; i < dvdList12.length - 1; i++) {
		    for (int j = i + 1; j < dvdList12.length; j++) {
		        if (dvdList12[i].getTitle().compareTo(dvdList12[j].getTitle()) > 1) {
		            DigitalVideoDisc temp_dvdList12 = dvdList12[i];
		            dvdList12[i] = dvdList12[j];
		            dvdList12[j] = temp_dvdList12;
		        }
		    }
		}
		return dvdList12;
	}
}