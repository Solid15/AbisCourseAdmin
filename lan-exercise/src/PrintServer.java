public class PrintServer extends ExecutingNode {

// the attributes:

	
// the constructors (do not touch!):
	public PrintServer() {
		super();
	}
	public PrintServer(String anAddress) {
		super(anAddress);
	}

// the get & set methods:

// the other methods:

	public void execute(Packet p) {
		System.out.println("Printing content");
		System.out.println(p.getContents());
		}


}