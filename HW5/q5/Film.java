import java.util.ArrayList;

/**
 * This abstract class is super class for 4 types of the film
 * that we can have in the site. It holds the common fields and methods.
 */
public abstract class Film {
    
    private String name;
    private String summary;
    private Genre genre;
    private String director;
    private Age age;
    private ArrayList<String> actors;
    private double rateSum;
    private int rateCount;


    public Film(String name, String summary, Genre genre, String director, Age age, ArrayList<String> actors) {
        this.name = name;
        this.summary = summary;
        this.genre = genre;
        this.director = director;
        this.age = age;
        this.actors = actors;
        this.rateSum = 0;
        this.rateCount = 0;
    }  

    public Age getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    /**
     * This method prints the information of the movie.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n>>>>>>>>>>");
        stringBuilder.append("\nName: " + name);
        stringBuilder.append("\nRate: " + getRate());
        stringBuilder.append("\nGenre: " + genre);
        stringBuilder.append("\nDirector: " + director);
        stringBuilder.append("\nSummary: " + summary);
        stringBuilder.append("\nAge: " + age);
        stringBuilder.append("\ncast: ");
        stringBuilder.append(actors.toString());
        stringBuilder.append("\n<<<<<<<<<<\n");
        return stringBuilder.toString();
    }

    /**
     * This method gets the rating number and updates the summand and the number
     * of the rates for the film.
     * @param rate
     */
    public void rate(int rate) {
        rateSum += rate;
        rateCount++;
    }

    /**
     * This method returns the rate of the film in String format.
     * @return
     */
    private String getRate() {
        if (rateCount == 0) {
            return "Nobody has rated this film yet!";
        }
        return String.format("%.2f", rateSum / rateCount);
    }
    
    public abstract void download();
}
