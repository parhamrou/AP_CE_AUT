public class Follower extends Person implements Observer{

    public Follower(String name, String nationalCode, int age) {
        super(name, nationalCode, age);
    }


    @Override
    public void updates(News news) {
        System.out.println(">>>>>>>>>>");
        System.out.printf("Follower's name: %s\n", getName());
        System.out.print(news);
        System.out.println("<<<<<<<<<<");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nName: " + getName());
        stringBuilder.append("\nAge: " + getAge());
        stringBuilder.append("\nNational code: " + getNationalCode());
        return stringBuilder.toString();
    }
    
}
