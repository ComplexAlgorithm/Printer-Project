/**
 * The first step in this process is to develop the Print Job class which would hold all the
information for the request. This class should follow object-oriented methodology by making its
instance variables private and having appropriate accessor and mutator methods to allow access
and manipulation of the attributes of the Print Job class. The number of sheets of paper required
for the job cannot be less than 1 and if a user enters a value less than one an exception should be
thrown to inform the user of this. This exception class should be developed as the
LessThanOneException which should inherit from the Exception class. The color of the paper
passed in can only be white or yellow, if any other color is passed an exception should be thrown
to inform the user of this. This exception class should be developed as the ColorPaperException
which should inherit from the Exception class. The Print Job class should also override the
toString method from the Object class to return in String form all the information about a Print
Job
 * @author Joshua
 *
 */
public class PrintJob {
	private String name;
	private String text;
	private int numberOfPages;
	private String colorOfPaper;
	
	public PrintJob() {
		name = " ";
		text = " ";
		numberOfPages = 1;
		colorOfPaper = "White";
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setText(String newText) {
		text = newText;
	}
	public String getText() {
		return text;
	}
	
	public void setNumberOfPages(int newNumberOfPages) throws LessThanOneException {
		if(numberOfPages < 1) {
			throw new LessThanOneException("Print Job must be at least one page long!");
			
		}
		else {
			numberOfPages = newNumberOfPages;
		}
	}
	public int getNumberOfPages() {
		return numberOfPages;
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
	
	public String toString() {
		return "Name: " + name + "Text: " + text + "Number of Pages: " + numberOfPages + "Color Of Paper: " + colorOfPaper;
	}

}
