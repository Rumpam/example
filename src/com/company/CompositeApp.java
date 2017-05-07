package com.company;

import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape trapecia1 = new Trapecia();
        Shape trapecia2 = new Trapecia();
        Shape trapecia3 = new Trapecia();

        Shape romb1 = new Romb();
        Shape triangle1 = new Triangle();


        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(trapecia1);
        composite1.addComponent(trapecia2);
        composite1.addComponent(trapecia3);

        composite2.addComponent(romb1);
        composite2.addComponent(triangle1);

        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.draw();
    }
}

interface Shape{
    void draw();
}

class Trapecia implements Shape {
    public void draw() {
        System.out.println("Нарисовалось трапеция");
    }
}
class Romb implements Shape{
        public void draw(){
            System.out.println("Нарисовался ромб");
    }
}
class Triangle implements Shape{
        public void draw(){
            System.out.println("Нарисовался треугольник");
        }
}

class Composite implements Shape{
        private List<Shape> components = new ArrayList<>();

        public void addComponent(Shape component){
            components.add(component);
        }
        public void removeComponent(Shape component){
            components.remove(component);
        }
        public void draw(){
            for (Shape component: components){
                component.draw();
            }
        }
}
