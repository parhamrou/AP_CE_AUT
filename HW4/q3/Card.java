public class Card {
    
    private String name;
    private int normalKick;
    private int hardKick;
    private double energy;
    private double elixir;
    private boolean isPicked;

    // constructor
    public Card(String name, int normalKick, int hardKick, double energy, double elixir) {
        this.name = name;
        this.normalKick = normalKick;
        this.hardKick = hardKick;
        this.energy = energy;
        this.elixir = elixir;
        this.isPicked = false;
    }

    public double getEnergy() {
        return energy;
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

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setElixir(double elixir) {
        this.elixir = elixir;
    }

    @Override
    public String toString() {
        return String.format("Name: %s   Normal kick: %d    Hard kick: %d     Energy: %f    Elixir: %f\n", name, normalKick, hardKick, energy, elixir);
    }
}
