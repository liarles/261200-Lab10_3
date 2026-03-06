public class DocumentFileHandler implements Handler {
    Handler nextHandler;
    String name;

    public DocumentFileHandler(String name) {
        this.name = name;
    }
    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void process(File file) {
        if (file.fileType == "document") {
            System.out.println(this.toString() + ": Processing " + file.toString());
        } else {
            if (nextHandler != null) {
                System.out.println(this.toString() + ": Forwarding " + file.toString());
                nextHandler.process(file);
            } else {
                System.out.println("File not supported.");
            }
        }
    }

}
