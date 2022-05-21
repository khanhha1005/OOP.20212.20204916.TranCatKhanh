public class TestPassingParameter{
     public static void main(String[]args){
          // TODO Auto-generated method stub
          DigitalVideoDisc jungleDVD =new DigitalVideoDisc("Jungle");
          DigitalVideoDisc cinderellaDVD =new DigitalVideoDisc("Cinderella");
          swap(jungleDVD,cinderellaDVD);
          System.out.println("jungle dvd title:"+jungleDVD.getTitle());
          System.out.println("cinderella dvd title:"+ cinderellaDVD.getTitle());
          changeTitle(jungleDVD,cinderellaDVD.getTitle());
          System.out.println("jungle dvd title:" +jungleDVD.getTitle());
     }
     public static void swap(DigitalVideoDisc  o1 , DigitalVideoDisc o2) {
    	 String  tmp = o1.getTitle() ;
    	 o1.setTitle(o2.getTitle());
    	 o2.setTitle(tmp) ;
     }
     public static void changeTitle(DigitalVideoDisc dvd , String title) {
    	 String oldTitle = dvd.getTitle();
    	 dvd.setTitle(title);
    	 dvd = new DigitalVideoDisc(oldTitle);
     }
}