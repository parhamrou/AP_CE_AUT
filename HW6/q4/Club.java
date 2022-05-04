import java.util.ArrayList;

public class Club {
    
    private String name;
    private ArrayList<Match> aheadMatches;
    private ArrayList<Player> players;
    private ArrayList<Channel> channels;

    // constructor
    public Club(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
        aheadMatches = new ArrayList<>();
        channels = new ArrayList<>();
        createChannel();
    }


    private void createChannel() {
        channels.add(new Channel("Club Channel", this)); // index 0 : Club Channel
        channels.add(new Channel("Matches Channel", this)); // index 1 : Matches channel
        channels.add(new Channel("Players Channel", this)); // index 2: Players Channel
    }


    public void registerFollower(Observer observer, boolean ch1, boolean ch2, boolean ch3) {
        if (ch1) 
            channels.get(0).addFollower(observer);
        if (ch2) 
            channels.get(1).addFollower(observer);
        if (ch3)
            channels.get(2).addFollower(observer);
    }


    public void addToClubChannel(Observer observer) {
        channels.get(0).addFollower(observer);
    }


    public void addToMatchesChannel(Observer observer) {
        channels.get(1).addFollower(observer);
    } 


    public void addToPlayersChannel(Observer observer) {
        channels.get(2).addFollower(observer);
    }

    
    public void addPlayer(Player player) {
        players.add(player);
    }


    public void addMatch(Match match) {
        aheadMatches.add(match);
    }

    public void addClubNews(News news) {
        channels.get(0).addNews(news);
    }

    public void addMatchesNews(News news) {
        channels.get(1).addNews(news);
    }

    public void addPlayersNews(News news) {
        channels.get(2).addNews(news);
    }

    public String getName() {
        return name;
    }
}
