import java.util.ArrayList;

public class Channel implements Subject {

    private String channelName;
    private ArrayList<Observer> observers;
    private Club club;

    // constructor
    public Channel(String channelName, Club club) {
        observers = new ArrayList<>();
        this.channelName = channelName;
        this.club = club;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    @Override
    public void addFollower(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeFollower(Observer observer) {
        observers.remove(observer);
        System.out.printf("The fan is removed from %s's %s!\n", club.getName(), channelName);
    }

    @Override
    public void notifyFollowers(News news) {
        for (Observer observer : observers) {
            observer.updates(news);
        }
    }

    public void addNews(News news) {
           System.out.printf("\nFrom %s's %s: \n", club.getName(), channelName);
           notifyFollowers(news);
    }
}
