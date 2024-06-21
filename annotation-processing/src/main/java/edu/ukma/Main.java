package edu.ukma;

import edu.ukma.generated.GeneratedPerson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);

        // Create proxy and call @LogExecution methods
        Humanbeing proxyPerson = LogExecutionProcessor.createProxy(person);
        proxyPerson.introduce();

        GeneratedPerson generatedPerson = new GeneratedPerson();
        generatedPerson.printName();
    }
}