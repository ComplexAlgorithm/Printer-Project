/**
 * The next step will be to develop a Paper Tray class which represents the paper tray inside the
printer. This class should have attributes for the name of the tray, the color of paper that is
assigned to it, the amount of paper currently in the tray, and a constant that represents the
maximum amount of paper that will fit into that tray. The maximum for all trays should be 100
pieces of paper. This class should follow object-oriented methodology by making its instance
variables private and having appropriate accessor and mutator methods to allow access and
manipulation of the attributes of the Paper Tray class. Attempting to add more paper to tray than
it can hold will cause a PaperOverFlowException which should inherit from the Exception class.
The Paper Tray class should also override the toString method form the Object class to return in
String form all the information about a Paper Tray.

 * @author Joshua
 *
 */
public class PaperTray {
	String trayName;
	String colorOfPaper;
	int amountOfPaper;

	public static final int Max_Paper = 100;
	
	public PaperTray() {
		trayName = " " ;
		colorOfPaper = "White";
		amountOfPaper = Max_Paper;
		
	}
	public void setTrayName(String newName) {
		trayName = newName;
	}
	public String getTrayName() {
		return trayName;
	}
	
	public void setColorOfPaper(String newColorOfPaper) throws ColorPaperException {
		if(colorOfPaper.equals("White") || colorOfPaper.equals("Yellow")) {
			colorOfPaper = newColorOfPaper;
			
		}
		else {
			throw new ColorPaperException("Color of paper must be White or Yellow!");
		}
		
	}
	public String getColorOfPaper() {
		return colorOfPaper;
	}
	public void addPaper(int newPaper) throws PaperOverFlowException{
		if((amountOfPaper + newPaper) > 100) {
			throw new PaperOverFlowException("Too much paper added to the printer! Printer can only hold 100 sheets!");
			
		}
		else {
			amountOfPaper = amountOfPaper + newPaper;
		}
	}
	public void removePaper(int removedAmount) throws PaperUnderFlowException{
		if(amountOfPaper < removedAmount) {
			throw new PaperUnderFlowException("There isn't enough paper to process this job!");
		}
		else {
			amountOfPaper = amountOfPaper - removedAmount;
		}
	}
	
	public int getAmountOfPaper() {
		return amountOfPaper;
	}
	
	public String toString() {
		return "Name" + trayName + "Color of Paper" + colorOfPaper + "AmountOfPaper" + amountOfPaper;
	}
	
	

}
