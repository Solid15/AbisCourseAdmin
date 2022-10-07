public class Node {
	
// the attributes:
	String address;
	Node nextNode;

// the constructors (do not touch!):
	public Node ( ) {
	}
	public Node (String anAddress) {
	address = anAddress;
	}

// the get & set methods:
	public String getAddress() {
		return address;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setAddress(String anAddress) {
		address = anAddress;
	}
	public void setNextNode(Node aNode) {
		nextNode = aNode;
	}


// the other methods:
	public void receive(Packet p) {
		System.out.println(getClass().getSimpleName() + " " + address + " has received a packet");
		send(p);      															// this.send(p);
	
	//this is default behaviour for all kinds of nodes;
	//subclasses will probably override this method to do something special
	}

	public void send(Packet p) {
		if (nextNode != null) {
			System.out.println("Sending packet to the next node: " + nextNode.getClass().getSimpleName() +
					" " + nextNode.getAddress());
			nextNode.receive(p);
		} else {
			System.out.println("No next node found, packet halted. Please fix network.");
		}
	//this is default behaviour for all kinds of nodes.
	}
	
	

}
