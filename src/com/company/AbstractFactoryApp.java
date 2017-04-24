package com.company;

public class AbstractFactoryApp {
    public static void main (String[] args){
        DeviceFactory factory = getFactoryByContryCode("RU");
        Mouse m = factory.getMouse();
        KeyBoard k = factory.getKeyBoard();
        TouchPad t = factory.getTouchPad();

        m.click();
        m.dblclick();
        m.scroll(10);
        k.print();
        k.println();
        t.track(10,2);
    }
    private static DeviceFactory getFactoryByContryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code: " + lang);
        }
    }
}

interface Mouse{
    void click();
    void dblclick();
    void scroll(int direction);
}
interface KeyBoard {
    void print();
    void println();
}
interface TouchPad {
    void track(int deltaX, int deltaY);
}
interface DeviceFactory {
    Mouse getMouse();
    KeyBoard getKeyBoard();
    TouchPad getTouchPad();
}

class RuMouse implements Mouse{
    public void click(){System.out.println("Нажатие на мышку");}
    public void dblclick(){System.out.println("Двойное нажатие");}
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Проскролили - вверх");
        } else if (direction < 0) {
            System.out.println("Проскролили - вниз");
        } else {
            System.out.println("Не скролилил");
        }
    }
}
class RuKeyBoard implements KeyBoard{
     public void print(){System.out.println("Напечатали русскими буквами");}
     public void println(){System.out.print("Напечатали русскими буквами на следующей строке");}
     }
class RuTouchPad implements TouchPad{
     public void track(int deltaX, int deltaY){

     }
}
class RuDeviceFactory implements DeviceFactory{
    public Mouse getMouse(){return null;}
    public KeyBoard getKeyBoard(){return null;}
    public TouchPad getTouchPad(){return null;}
}
class EnDeviceFactory implements DeviceFactory{
    public Mouse getMouse(){return null;}
    public KeyBoard getKeyBoard(){return null;}
    public TouchPad getTouchPad(){return null;}
}

class EnMouse implements Mouse{
    public void click(){System.out.println("Кликнули по английской мышки");}
    public void dblclick(){System.out.println("Двойное нажатие по английской мышки");}
    public void scroll(int direction){
        if (direction < 0){
            System.out.println("Просколили английскую мышку - вверх");
        } else if (direction > 0) {
            System.out.println("Проскролили английскую мышку - вниз");
        } else {
            System.out.println("Не скролили английскую мышку");
        }
    }
}




