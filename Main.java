public class Main {
    public static void main(String[] args) {
        TextFileHandler     textHandler     = new TextFileHandler("TextFileHandler");
        DocumentFileHandler documentHandler = new DocumentFileHandler("DocumentFileHandler");
        ImageFileHandler    imageHandler    = new ImageFileHandler("ImageFileHandler");

        textHandler.setNextHandler(documentHandler); // ทำ chain text -> doc
        documentHandler.setNextHandler(imageHandler); // ทำ chain doc -> image

        File file = new File("final_exam.txt","image","egg");
        TextFileHandler firsthandler = new TextFileHandler("egg");
        ImageFileHandler secondHandler = new ImageFileHandler("oil");
        firsthandler.setNextHandler(secondHandler);
        firsthandler.process(file);

        // Create files
        File textFile = new File("README.txt", "text", "/home/docs");
        File docFile = new File("Document.doc", "document", "/home/docs");
        File imageFile = new File("Picture.jpg", "image", "/home/images");
        File audioFile = new File("Song.mp3", "audio", "/home/audio");

        // Process files
        System.out.println("\nProcessing text file:");
        textHandler.process(textFile); // text  ไป text ทำได้เลย
        System.out.println("\nProcessing document file:");
        textHandler.process(docFile); // text -> doct
        System.out.println("\nProcessing image file:");
        textHandler.process(imageFile); // text -> doct -> image
        System.out.println("\nProcessing audio file:");
        textHandler.process(audioFile); //แปลงไฟล์ไปเรื่อย ๆ จนพบว่าไม่มี
    }
}