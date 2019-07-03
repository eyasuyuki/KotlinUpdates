package org.javaopen.kotlin.updates;

public class Animal {
    public Animal(String name) {
        setName(name);
    }

    private String name;
    public String getName() { 
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void action(Animal animal) {
        if (animal instanceof Cat) {
            Cat cat = (Cat)animal;
            cat.scratch();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog)animal;
            dog.bark();
        }
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void scratch() {
        System.out.println("Scratch this!");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    public void bark() {
        System.out.println("Bow wow!");
    }
}
