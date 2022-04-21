/**
 * This abstract class is the superclass for 5 different characters in the game. 
 */
public abstract class Character {
    
    private int elixir;
    private int speed;
    private int distancePassed;
    private int abilityCount; 
    private String name;

    // constructor
    public Character(int elixir, int speed, int abilityCount, String name) {
        this.elixir = elixir;
        this.speed = speed;
        this.abilityCount = abilityCount;
        this.name = name;
        distancePassed = 0;
    }
    
    public int getElixir() {
        return elixir;
    }

    public String getName() {
        return name;
    }

    public void setElixir(int elixir) {
        this.elixir = elixir;
    }
    
    public void reduceElixir(int amount) {
        elixir -= amount;
    }

    public int getDistancePassed() {
        return distancePassed;
    }

    public void move() {
        distancePassed += speed;
    }

    /**
     * This method checks if the character is alive or not.
     * @return If it's alive, true;  else, false.
     */
    public boolean isAlive() {
        if (getElixir() <= 0) {
            return false;
        }
         return true;
    }
    
    public void setDistancePassed(int distancePassed) {
        this.distancePassed = distancePassed;
    }

    /**
     * This method checks if the character can use his/her ability at the current round or not.
     * @return
     */
    public boolean canUseAbility() {
        if (abilityCount == 0) {
            return false;
        }
        return true;
    }

    public void useAbility() {
        abilityCount--;
    }

    /**
     * This method checks if the character is active or not. If the charcter is alive and hasn't passed
     * 200 meters, the character is active yet.
     * @return
     */
    public boolean isActive() {
        if (elixir <= 0 || distancePassed >= 200) {
            return false;
        }
        return true;
    }

    /**
     * This method checks if the character passed the 200 meters or not.
     * @return
     */
    public boolean isDistancePassed() {
        if (distancePassed >= 200) {
            return true;
        }
        return false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * This abstract method is implemented in all five characters and does 
     * the action of each character.
     * @param game This is the game object that the character is playing in.
     */
    public abstract void action(Game game);

}