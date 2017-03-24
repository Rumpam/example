package com.company;

public class Painter {
    Graphics graphics;
    void setGraphics(Graphics g){
        graphics = g;
    }
    void draw() {
        graphics.draw();
    }
}
