public class FileServer extends ExecutingNode {

    public FileServer() { super(); }
    public FileServer(String anAddress) { super(anAddress); }

    public void execute(Packet packet) {
        System.out.println("Saving content");
    }
}
