public class News {
    
    private String title;
    private String bodyText;

    // constructor
    public News(String title, String bodytext) {
        this.title = title;
        this.bodyText = bodytext;
    }

    public String getBodyText() {
        return bodyText;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        System.out.println("News: ");
        return String.format(title.toUpperCase() + "\n" + bodyText + "\n");
    }
}
