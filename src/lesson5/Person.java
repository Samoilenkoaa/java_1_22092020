package lesson5;

public class Person {
    private String name;
    private String position;
    private String email;
    private String telephone;
    private String salary;
    private int age;

    public Person(String name, String position, String email, String telephone, String salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void printPerson() {
        System.out.printf("%s, %s, %s, %s, %s, %d\n", name, position, email, telephone, salary, age);
    }

    public int getAge() {
        return age;
    }
}
