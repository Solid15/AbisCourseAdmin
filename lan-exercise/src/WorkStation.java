public class WorkStation  extends  Node {

    public WorkStation() { super(); }
    public WorkStation(String anAddress) { super(anAddress); }


    public void originate(Packet packet) {
        System.out.println("A packet has been inserted onto the network through Workstation " + address);
        packet.originatingWorkStationAddress = this.address;
        send(packet);
    }

    public void receive(Packet p) {
        System.out.println(getClass().getSimpleName() + " " + address + " has received a packet");
        if (p.originatingWorkStationAddress.equals(this.address)) {
            System.out.println("This packet was originally inserted onto the network through " +
                    getClass().getSimpleName() + " " + address);
            System.out.println("This packet has no valid Node Destination Address");
            System.out.println("Packet will be halted and not send further to another node");
        }
        else {
            send(p);
        }
    }

}
