package Eniro.GulaSidor; 

public class Main {

    public static void main(String[] args) {
        
        /**
         * Skapar en instans av RandomizeContacts och kör en metod för att generera alla kontakter till ContactBook
         * som laddas in i GUI vid uppstart.
         * Kallar på GUI
         * @author Erik M
         */
    	RandomizeContacts rc = new RandomizeContacts();
    	rc.go();
		GUI gui = new GUI();
		gui.RunGui();
    }
}