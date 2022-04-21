
public class StrongMan extends Character {
    
    private boolean isSafe;

    // constructor
    public StrongMan() {
        super(100, 20, 2, "Strong Man");
        isSafe = false;
    }

    @Override
    public void action(Game game) {
        isSafe = true;
        System.out.println("Now the strong man is safe for the next round!");
        useAbility();
    }

    /**
     * This method checks if the Strong Man is safe at the current round or not and returns 
     * a boolean value.
     * @return
     */
    public boolean isSafe() {
        if (isSafe) {
            return true;
        }
        return false;
    }

    /**
     * This method is overrided from the superclass and 
     * uses the ability of this character.
     */
    @Override
    public void move() {
        setDistancePassed(getDistancePassed() + getSpeed());
        if (isSafe) {
            isSafe = !isSafe;
        }
    }


}
