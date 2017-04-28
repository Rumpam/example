package com.company;

public class Main {
    public static void main(String[] args) {
        /* Делегирование */
        Painter painter = new Painter();
        painter.setGraphics(new Tringle());
        painter.draw();

        painter.setGraphics(new Circle());
        painter.draw();

        painter.setGraphics(new Square());
        painter.draw();
    }
}

interface Graphics{
    void draw();
}
class Tringle implements Graphics {
    public void draw() {
        System.out.println("Нарисовал треугольник");
    }
}
class Square implements Graphics {
    public void draw(){
        System.out.println("Нарисовался квадрат");
    }
}
class Circle implements Graphics {
    public void draw() {
        System.out.println("Нарисовался круг");
    }
}
/*
        class Class_A {
            void f(){
                System.out.println("f");
            }
        }

        class Class_B{
            Class_A a1 = new Class_A();
            void f(){
                a1.f();
            }
        }*/