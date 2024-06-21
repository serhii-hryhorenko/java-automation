package edu.ukma;

@GenerateClass(
    methodName = "printName"
)
public class Person implements Humanbeing {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
