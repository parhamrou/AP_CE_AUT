public abstract class Person {
    
    private String name;
    private String nationalCode;
    private int age;

    // constructor
    public Person(String name, String nationalCode, int age) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationalCode() {
        return nationalCode;
    }
    
}
