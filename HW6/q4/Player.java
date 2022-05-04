
public class Player extends Person{
    
    private int shirtNumber;
    private int GoalsNumber;
    private int MatchesNumber;

    // constructor
    public Player(String name, String nationalCode, int age, int GoalsNumber, int MatchesNumber) {
        super(name, nationalCode, age);
        this.GoalsNumber = GoalsNumber;
        this.MatchesNumber = MatchesNumber;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public int getGoalsNumber() {
        return GoalsNumber;
    }

    public int getMatchesNumber() {
        return MatchesNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nName: " + getName());
        stringBuilder.append("\nAge: " + getAge());
        stringBuilder.append("\nShirt number: " + shirtNumber);
        stringBuilder.append("\nGoals number: " + GoalsNumber);
        stringBuilder.append("\nMatches numebr: " + MatchesNumber);
        return stringBuilder.toString();
    }
}
