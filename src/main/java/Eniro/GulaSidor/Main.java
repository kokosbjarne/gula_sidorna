package Eniro.GulaSidor; 

public class Main {

    public static void main(String[] args) {
        
        /**
         * Kallar på GUI
         */
    	RandomizeContacts rc = new RandomizeContacts();
    	rc.go();
		GUI gui = new GUI();
		gui.RunGui();
    }
}