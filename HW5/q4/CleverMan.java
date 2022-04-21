public class CleverMan extends Character {
    
    // constructor
    public CleverMan() {
        super(75, 20, 2, "Clever Man");
    }

    @Override
    public void action(Game game) {
        setElixir(getElixir() + 25);
        System.out.println("The elixir of clever man is increased 25 numbers!");
        useAbility();
    }
}
