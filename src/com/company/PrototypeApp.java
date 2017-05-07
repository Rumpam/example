package com.company;


public class PrototypeApp {
    public static void main(String[] args){
        Human original = new Human(18, "Иннокентий");
        System.out.println(original);

        Human copy = (Human)original.copy();
        System.out.println(copy);

        FactoryHuman factoryHuman = new FactoryHuman(copy);
        Human h1 = factoryHuman.makeCopy();
        System.out.println(h1);
        factoryHuman.setTypePrototype(new Human(30,"Валерия"));
        Human h2 = factoryHuman.makeCopy();
        System.out.println(h2);

    }
}

interface Copyable{
    Object copy();
}

class Human implements Copyable{
    int age;
    String name;
    public Human(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return "Чловек по имени "+ name + ", возраста - " + age;
    }

    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }
}

class FactoryHuman{
    Human human;

    public FactoryHuman(Human human){
        setTypePrototype(human);
    }
    public void setTypePrototype(Human human){
        this.human = human;
    }

    Human makeCopy(){
        return (Human)human.copy();
    }
}
