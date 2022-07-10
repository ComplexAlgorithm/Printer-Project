/**
 * The fourth step in the development process is to create a Printer class that will represent the
printer that will receive and process Print Jobs. Since this printer will have two paper trays it
will have two instance variables of the Paper Tray class. One should handle requests for white
paper and the other for requests on yellow paper. They should be given an appropriate name and
the initial amount of paper for each tray will be set at 100. The Printer class will also have an
instance variable to handle all of the Print Jobs that come in. These should be stored in a queue
of the NodeBasedQueue<PrintJob>. The Printer class should have a few methods. One is to
print the next job in the queue. The next is to accept a Print Job and add it to the end of the
queue. It should be able to display all the Print Jobs in the queue. Methods for checking the
amount of paper in each in tray along with loading and removing paper in each tray should also
be part of the Printer class. 
 * @author Joshua
 *
 */
public class Printer {
	private String name;
	private PaperTray whiteTray;
	private PaperTray yellowTray;
	private UnBoundedQueueInterface<PrintJob> printQueue;
	
	public Printer() {
		name = "";
		whiteTray = new PaperTray();
		yellowTray = new PaperTray();
		printQueue = new NodeBasedQueue<PrintJob>();
		
		whiteTray.setTrayName("White");
		yellowTray.setTrayName("Yellow");
		try {
			whiteTray.setColorOfPaper("White");
			yellowTray.setColorOfPaper("Yellow");
		}catch(ColorPaperException e) {
		}
	}
	public String printNextJob() throws QueueEmptyException{
		PrintJob printNextJob = printQueue.dequeue();
		try {
			if(printNextJob.getColorOfPaper().equals("White")) {
				whiteTray.removePaper(printNextJob.getNumberOfPages());
			}
			else if(printNextJob.getColorOfPaper().equals("Yellow")) {
				yellowTray.removePaper(printNextJob.getNumberOfPages());
			}
		}catch(PaperUnderFlowException e) {
			printQueue.enqueue(printNextJob);
			return e.getMessage();
			
		}
		return "Print Job was successfully completed!";
		
	}
	public void addPrintJob(PrintJob newPrintJob) {
		printQueue.enqueue(newPrintJob);
	}
	public void displayAllPrintJobs() {
		System.out.println(printQueue.toString());
	}
	public int checkPaperInWhiteTray() {
		return whiteTray.getAmountOfPaper();
	}
	public int checkPaperInYellowTray() {
		return yellowTray.getAmountOfPaper();
	}
	
	public void loadPaperInWhiteTray(int newPaper) throws PaperOverFlowException{
		whiteTray.addPaper(newPaper);
	}
	public void loadPaperInYelllowTray(int newPaper) throws PaperOverFlowException{
		yellowTray.addPaper(newPaper);
	}

}
