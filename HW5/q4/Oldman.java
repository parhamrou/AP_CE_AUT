public class Oldman extends Character {
    
    private boolean isFast;

    // constructor
    public Oldman() {
        super(75, 20, 2, "Old Man");
        isFast = false;
    }

    @Override
    public void action(Game game) {
        isFast = true;
        setSpeed(getSpeed() * 2);
        System.out.println("Now the speed is twice for the next round!");
        useAbility();
    }

    /**
     * This method is overrided from the super class and 
     * does the functions that is required for using the ability of this character.
     */
    @Override
    public void move() {
        setDistancePassed(getDistancePassed() + getSpeed());
        if (isFast) {
            setSpeed(getSpeed() / 2 - 2);
            isFast = false;
        }
    }
}
