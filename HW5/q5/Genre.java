/**
 * This enum holds the possible genres of films that one site can have.
 */
public enum Genre {
    DOCUMENTRY,
    DRAMA,
    ACTION,
    COMEDY,
    ADVENTURE;

    /**
     * This method gets on String value from the user and returs the matched 
     * enum value.
     * @param input
     * @return genre that is matched with the input string.
     */
    public static Genre genreChoice(String input) {
        Genre genre = null;
        while (true) {
            for (Genre genre2 : Genre.values()) {
                if (genre2.name().equalsIgnoreCase(input)) {
                    genre = genre2;
                    return genre;
                }
            }
            System.out.printf("This genre doesn't exist. Try again!\n> ");
            input = Site.scanner.nextLine();
        }
    }
}
