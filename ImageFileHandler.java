public class ImageFileHandler implements Handler{
    Handler nextHandler;
    String name;

    public ImageFileHandler(String name) {
        this.name = name;
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void process(File file){
        if (file.fileType == "image") {
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
