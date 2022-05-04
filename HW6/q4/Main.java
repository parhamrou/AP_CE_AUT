import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        // creating Barcelona club instance and its players
        ArrayList<Player> BarcelonaPlayers = new ArrayList<>();
        BarcelonaPlayers.add(new Player("Ansu Fati", "10239", 19, 14, 36)); 
        BarcelonaPlayers.add(new Player("Gerard Pique", "01293", 35, 57, 656));
        Club Barcelona = new Club("Barcelona", BarcelonaPlayers);


        // creating Real Madrid club instance and its players
        ArrayList<Player> RealMadridPlayers = new ArrayList<>();
        RealMadridPlayers.add(new Player("Toni Kroos", "0129309", 32, 64, 624));
        RealMadridPlayers.add(new Player("Karim Benzema", "0192093", 34, 401, 768));
        Club RealMadrid = new Club("Real Madrid", RealMadridPlayers);

        // creating LiverPool club instance and its players
        ArrayList<Player> LiverpoolPlayers = new ArrayList<>();
        LiverpoolPlayers.add(new Player("Mohamamd Salah", "0902913", 29, 232, 498));
        LiverpoolPlayers.add(new Player("Sadio Mane", "010923", 30, 189, 447));
        Club Liverpool = new Club("Liverpool", LiverpoolPlayers);

        // creating some Matches
        Match match1 = new Match(Barcelona, RealMadrid, LocalDate.now(), "Camp Nou");
        Match match2 = new Match(Liverpool, Barcelona, LocalDate.now().plusDays(5), "Anfield");
        Match match3 = new Match(RealMadrid, Liverpool, LocalDate.now().plusDays(10), "Santiago Bernabeu");

        // adding matches to clubs
        Barcelona.addMatch(match1);
        Barcelona.addMatch(match2);
        RealMadrid.addMatch(match1);
        RealMadrid.addMatch(match3);
        Liverpool.addMatch(match3);
        Liverpool.addMatch(match2);

        // creating some followers and adding to the clubs
        Follower Parham = new Follower("Parham", "01923", 19);
        Follower Ali = new Follower("Ali", "02193", 28);
        Follower Hossein = new Follower("Hossein", "201932", 40);
        Barcelona.registerFollower(Parham, true, true, false);
        Liverpool.registerFollower(Ali, false, true, true);
        RealMadrid.registerFollower(Hossein, true, false, true);
        Liverpool.registerFollower(Parham, true, true, true);


        // adding some news to the clubs
        Liverpool.addClubNews(new News("Jurgen Klopp contract", "Jurgen Klopp could extend his Liverpool contract beyond 2024 as FSG hopeful of agreeing new deal with manager"));
        Barcelona.addClubNews(new News("Koeman Slams Xavi's Work And FC Barcelona Then Speaks On De Jong Sale", "Ex-FC Barcelona coach Ronald Koeman has criticized successor Xavi Hernandez's work, the way he was treated by the club, and whether it will sell star midfielder Frenkie de Jong."));
        RealMadrid.addClubNews(new News("Place in final to be decided at Bernabeu", "A Benzema brace and a sublime Vini Jr. effort leave the tie wide open and Madrid needing to stage a fightback in front of the home fans next Wednesday."));
        Liverpool.addPlayersNews(new News("Mohamed Salah for FWA Footballer of the Year", "It has been a privilege to be in the stadium to witness three very different Liverpool performances this past month, just two weeks apart. Mohamed Salah was the constant."));
    }
}
