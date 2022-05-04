import java.time.LocalDate;
public class Match {
    
    private Club team1;
    private Club team2;
    private LocalDate matchDate;
    private String stadium;


    // constructor
    public Match(Club team1, Club team2, LocalDate matchDate, String stadium) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchDate = matchDate;
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\n %s vs %s", team1.getName(), team2.getName()));
        stringBuilder.append("\n Match date: " + matchDate);
        stringBuilder.append("\nStadium: " + stadium);
        return stringBuilder.toString();
    }
}
