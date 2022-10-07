abstract public class ExecutingNode extends Node {

    public ExecutingNode() { super(); }
    public ExecutingNode(String anAddress) { super(anAddress); }

    abstract public void execute(Packet p);

    public void receive(Packet p) {
        System.out.println(getClass().getSimpleName() + " " + address + " has received a packet");
        if (address.equals(p.getDestinationAddress())) {
            System.out.println("Packet was meant for this " + getClass().getSimpleName());
            execute(p);
        } else {
            System.out.println("Packet was not meant for this " + getClass().getSimpleName());
            System.out.println("Sending packet to the next node: " + nextNode.getClass().getSimpleName() +
                    " " + nextNode.getAddress());
            nextNode.receive(p);
        }
    }
}
