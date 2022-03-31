public class Card {
    
    private String name;
    private int normalKick;
    private int hardKick;
    private double currentEnergy;
    private double maxEnergy;
    private double elixir;
    private boolean isPicked;

    // constructor
    public Card(String name, int normalKick, int hardKick, double energy, double elixir) {
        this.name = name;
        this.normalKick = normalKick;
        this.hardKick = hardKick;
        this.currentEnergy = energy;
        this.maxEnergy = energy;
        this.elixir = elixir;
        this.isPicked = false;
    }

    // copy constructor
    public Card(Card card) {
        this.name = card.name;
        this.normalKick = card.normalKick;
        this.hardKick = card.hardKick;
        this.currentEnergy = card.currentEnergy;
        this.maxEnergy = card.maxEnergy;
        this.elixir = card.elixir;
        this.isPicked = card.isPicked;
    }

    public double getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(double currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public double getElixir() {
        return elixir;
    }

    public String getName() {
        return name;
    }

    public int getHardKick() {
        return hardKick;
    }
    
    public int getNormalKick() {
        return normalKick;
    }
    
    public void setPicked(boolean isPeacked) {
        this.isPicked = isPeacked;
    }

    public boolean getPicked() {
        return isPicked;
    }

    public void repair() {
        currentEnergy = maxEnergy;
    }

    public void setElixir(double elixir) {
        this.elixir = elixir;
    }

    public boolean isFull() {
        if (currentEnergy == maxEnergy) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Name: %s   Normal kick: %d    Hard kick: %d     Energy: %.2f    Elixir: %.2f\n", name, normalKick, hardKick, currentEnergy, elixir);
    }
}
