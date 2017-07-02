package com.company;

import java.util.Date;

/*
* Фабричный метод - это паттерн, порождающий классы.
* Фабричный метод определяет интерфейс для создания объекта, но оставляет подклассам решение о том, какой класс инстанцировать.
* Фабричный метод позволяет классу делегировать инстанцирование подклассам.*/

public class FactoryMathodApp {
    public static void main(String[] args) {
        //Watch watch = new DigitalWatch();
        //watch.showTime();

        WatchMaker maker = getMarketByName("Rome");
        Watch watch = maker.createWatch();
        watch.showTime();
    }
    public static WatchMaker getMarketByName(String maker) {
        if (maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
            return new RomeWatchMaker();
        throw new RuntimeException("Не поддерживаемый производитель часов "+ maker);
    }
}

interface Watch{
    void showTime();
}
class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch {
    public void showTime(){
        System.out.println("VII");
    }
}

interface WatchMaker{
    Watch createWatch();
}
class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatch();
    }
}