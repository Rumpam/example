package com.company;


import java.io.FileNotFoundException;
import java.security.PublicKey;



/*
* Что такое адаптер.
* Это Структурный шаблон проектирования, предназначенный для исполь. функций объекта,
* не доступного для модификаций. Через спец. созд. интерфейс.
* Адаптер позволяет клиенту, через свой интерфейс, использовать методы другого интерфейса.*/
public class AdapterApp {
    public static void main(String[] args) throws FileNotFoundException {
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        VectorAdapterFromRaster2 g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){
        System.out.println("нарисовалось растовая линия");
    }
    void drawRasterSquare(){
        System.out.println("Нарисовался растровый квадрат");
    }
}
//1-й способ через наследованиее (extends - наследование | implements - реализация)
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
     public void drawLine(){
         drawRasterLine();
     }
     public void drawSquare(){
         drawRasterSquare();
     }
}
// 2-й способ через композицию
class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics raster = null;
    public VectorAdapterFromRaster2(RasterGraphics raster){
        this.raster = raster;
    }// внутри адаптора создали экземпляр растровой графики
    public void drawLine(){
        raster.drawRasterLine();
    }
    public void drawSquare(){
        raster.drawRasterSquare();
    }
}


