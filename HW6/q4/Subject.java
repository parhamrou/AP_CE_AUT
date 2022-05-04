public interface Subject {

    public void addFollower(Observer observer);
    public void removeFollower(Observer observer);
    public void notifyFollowers(News news);

}
