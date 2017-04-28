package com.company;

import javax.swing.text.Position;

import java.security.Key;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

public class AbstarctFactoryApp {
    public static void main(String[] args) {
        DeviceFactory deviceFactory = getFactoryByContryCode("RU");
        Mouse m = deviceFactory.getMouse();
        KeyBoard k = deviceFactory.getKeyBoard();
        Touchpad t = deviceFactory.getPosition();

        m.click();
        k.pressButton();
        t.position(1, 3);
    }

    private static DeviceFactory getFactoryByContryCode(String lang){
        switch (lang){
            case "RU":
                return new  RuDevicesFactory();
            default:
                throw new RuntimeException("bla bla bla" + lang);
        }
    }

interface Mouse{
    void click();
        void doubleClick();
}
interface KeyBoard{
        void pressButton();
}
interface Touchpad{
        void position(int deltaX, int deltaY);
}
interface DeviceFactory{
        Mouse getMouse();
        KeyBoard getKeyBoard();
        Touchpad getPosition();
}

static class RuDevicesFactory implements DeviceFactory{
    public Mouse getMouse() {
        return new Rumouse();
    }
    public KeyBoard getKeyBoard() {
        return new RuKeyBoard();
    }
    public Touchpad getPosition() {
        return new RuTouchpad();
    }
}
static class Rumouse implements Mouse {
    public void click() {
        System.out.println("Было нажатие на мышку, русской локализации");
    }
    public void doubleClick() {
        System.out.println("Было двойное нажатие на мышку, русской локализации");
    }
}
static class RuKeyBoard implements KeyBoard{
        public void pressButton(){
            System.out.println("Было нажатие на клавиатуру русской локализации");
        }
}
static class RuTouchpad implements Touchpad{
        public void position(int deltaX, int deltaY){
            System.out.println("Куда то передвился курсор");
        }
}

}
