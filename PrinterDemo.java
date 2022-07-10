/**
 * Finally, develop a demo class that will allow the user to do try all of these options. Make sure to
test things such as trying to process a job when there is no job in the queue, or trying to process a
job when there isn’t enough paper to process that job, and also to load more paper into a tray
than it can handle to test to make sure your program can handle these exceptional situations. All
exceptions should be handled by using try/catch construct to prevent the program from ending
when an exception occurs. 
 * @author Joshua
 *
 */
import java.util.Scanner;
public class PrinterDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Printer currentPrinter = new Printer();
		int option;
		
		do {
			System.out.println("Press 1 to print the next document.");
			System.out.println("Press 2 to add another document to be printed.");
			System.out.println("Press 3 to look at all of the documents waiting to be printed.");
			System.out.println("Press 4 to check how much paper is in each paper tray.");
			System.out.println("Press 5 to load white paper.");
			System.out.println("Press 6 to load yellow paper.");
			System.out.println("Press 7 to end the program.");
			option = keyboard.nextInt();
			keyboard.nextLine();
			
			if(option == 1) {
				try {
					String result = currentPrinter.printNextJob();
					System.out.println(result);
				}
				catch(QueueEmptyException e) {
					System.out.println("Theres nothing to print.");
				}
			}
			else if(option == 2) {
				System.out.println("Whats is the name of the document you'd like to print?");
				String name = keyboard.nextLine();
				
				System.out.println("What is the text of the document you'd like to print?");
				String text = keyboard.nextLine();
				
				System.out.println("How many pages are in this print job?");
				int pages = keyboard.nextInt();
				keyboard.nextLine();
				
				System.out.println("What color of paper do you want printed on this document (White or Yellow)?");
				String color = keyboard.nextLine();
				
				PrintJob newJob = new PrintJob();
				newJob.setName(name);
				newJob.setText(text);
				try {
					newJob.setNumberOfPages(pages);
					newJob.setColorOfPaper(color);
					currentPrinter.addPrintJob(newJob);
				}
				catch(LessThanOneException e) {
					System.out.println(e.getMessage());
				}
				catch(ColorPaperException e) {
					System.out.println(e.getMessage());
				}
			}
			else if(option == 3) {
				currentPrinter.displayAllPrintJobs();
			}
			else if(option == 4) {
				System.out.println("The amount of white paper is: " + currentPrinter.checkPaperInWhiteTray());
				System.out.println("The amount of yellow paper is: " + currentPrinter.checkPaperInYellowTray());
			}
			else if(option == 5) {
				System.out.println("How much white paper would you like to load into the paper tray?");
				int morePaper = keyboard.nextInt();
				try {
					currentPrinter.loadPaperInWhiteTray(morePaper);
				}
				catch(PaperOverFlowException e) {
					System.out.println(e.getMessage());
				}
				
			}
			else if(option == 6) {
				System.out.println("How much yellow paper would you like to load into the paper tray?");
				int morePaper = keyboard.nextInt();
				try {
					currentPrinter.loadPaperInYelllowTray(morePaper);
				}
				catch(PaperOverFlowException e) {
					System.out.println(e.getMessage());
				}
			}
			else if(option == 7) {
				System.out.println("GoodBye!");
				
			}
			else {
				System.out.println("Error!");
			}
		}while(option != 7);
		

	}

}
