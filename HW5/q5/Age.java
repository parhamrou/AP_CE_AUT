/**
 * This enum if for holding the possible types of age levels of the films.
 */
public enum Age {
    A,
    B,
    C,
    D;

    /**
     * This method gets a string from caller method and returns the matched Age enum value.
     * @param input
     * @return
     */
    public static Age ageChoice(String input) {   
        Age age = null;
        while (true) {
            for (Age age2 : Age.values()) {
                if (age2.name().equalsIgnoreCase(input)) {
                    age = age2;
                    return age;
                }
            }
            System.out.printf("This genre doesn't exist. Try again!\n> ");
            input = Site.scanner.nextLine();
        }
    }
}
