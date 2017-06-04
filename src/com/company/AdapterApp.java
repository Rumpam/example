package com.company;


import java.io.FileNotFoundException;
import java.security.PublicKey;

public class AdapterApp {
    public static void main(String[] args) throws FileNotFoundException {
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        VectorAdapterFromRaster2 g2 = new VectorAdapterFromRaster2();
        g2.drawRasterSquare();
        g2.drawRasterLine();
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
//1-й способ через наследованиее
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
     public void drawLine(){
         drawRasterLine();
     }
     public void drawSquare(){
         drawRasterSquare();
     }
}
// 2-й способ через композицию
class VectorAdapterFromRaster2 extends RasterGraphics implements VectorGraphicsInterface{
    RasterGraphics raster = new RasterGraphics();
    public void drawLine(){
        raster.drawRasterLine();
    }
    public void drawSquare(){
        raster.drawRasterSquare();
    }
}


