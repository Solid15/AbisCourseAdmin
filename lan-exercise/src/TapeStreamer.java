public class TapeStreamer extends ExecutingNode {

    public TapeStreamer() { super(); }
    public TapeStreamer(String anAddress) { super(anAddress); }

    public void execute(Packet packet) {
        System.out.println("Streaming on tape");
    }
}
