package hust.soict.dsai.test.disc.TestPassingParameter;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter{
     public static void main(String[]args){
          // TODO Auto-generated method stub
          DigitalVideoDisc jungleDVD =new DigitalVideoDisc("Jungle");
          DigitalVideoDisc cinderellaDVD =new DigitalVideoDisc("Cinderella");
          discWrapper Obj1 = new discWrapper(jungleDVD);
          discWrapper Obj2 = new discWrapper(cinderellaDVD);
          swap(Obj1,Obj2);
          System.out.println("jungle dvd title:"+Obj1.innerObject.getTitle());
          System.out.println("cinderella dvd title:"+ Obj2.innerObject.getTitle());
          changeTitle(jungleDVD,cinderellaDVD.getTitle());
          System.out.println("jungle dvd title:" +jungleDVD.getTitle());
     }


     public static void changeTitle(DigitalVideoDisc dvd , String title) {
    	 String oldTitle = dvd.getTitle();
    	 dvd.setTitle(title);
    	 dvd = new DigitalVideoDisc(oldTitle);
     }
     static void swap(discWrapper Obj1, discWrapper Obj2) {
         DigitalVideoDisc temp;
         temp = Obj1.innerObject;
         Obj1.innerObject = Obj2.innerObject;
         Obj2.innerObject = temp;
     }


     static class discWrapper {
         DigitalVideoDisc innerObject;
         public discWrapper(DigitalVideoDisc objInnner) {
             this.innerObject = objInnner;
         }
     }
}