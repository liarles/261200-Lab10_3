public interface Handler {
    public void process(File file);
    public void setNextHandler(Handler handler);
}
