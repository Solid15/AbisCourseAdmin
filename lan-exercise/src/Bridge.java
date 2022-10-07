public class Bridge extends Node {

    Bridge nextBridge;
    boolean sendToNextBridge = true;

    public Bridge() { super(); }
    public Bridge(String anAddress) { super(anAddress); }

    public Bridge getNextBridge() {  return nextBridge; }
    public void setNextBridge(Bridge nextBridge) { this.nextBridge = nextBridge; }

    public void receive(Packet p) {
        System.out.println(getClass().getSimpleName() + " " + address + " has received a packet");
        if (sendToNextBridge) {
            nextBridge.sendToNextBridge = false;                    //
            sendToBridge(p);
        } else {
            sendToNextBridge = true;
            send(p);
        }
    }
/*
    public void receive(Packet p) {                                         // more efficient solution
    //  Bridge linkedBridge = this.getNextBridge();
        System.out.println("Crossing the bridge to Bridge ' + nextBridge.address);
        nextBridge.send(p);
    }
*/
    public void sendToBridge(Packet p) {
        System.out.println("Sending packet to the next node: " + nextBridge.getClass().getSimpleName() +
                " " + nextBridge.getAddress());
        nextBridge.receive(p);
    }
}
