package com.company;

public class BuilderApp {

    public static void main(String[] args){
/*
        Car car = new CarBuilder()

                .builderMake("MERCEDES")
                .builderSpeed(320)
                .builderTransmission(Transmission.AUTO)
                .builder();
*/

        Director director = new Director();
        director.setBuilder(new SubaryBuilder());
        Car car = director.BuildCar();
        System.out.println(car);
    }
}

    enum Transmission{
        AUTO, MANUAL
    }

    class Car{
        String make;
        Transmission transmission;
        int speed;

        public void setMake(String make){this.make = make;}
        public void setTransmission(Transmission transmission){this.transmission = transmission;}
        public void setSpeed(int speed){this.speed = speed;}

        public String toString(){
            return "Car[make" + make + ", transmission" + transmission + ", maxspeed" + speed + "]";
        }
}

abstract class CarBuilder{
    Car car;
    void createCar() {
        car = new Car();
    }

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildSpeed();

    Car getCar() {
        return car;
    }
}


class FordMoneoBuilder extends CarBuilder {
    void buildMake() {
        car.setMake("FordMondeo");
    }
    void buildTransmission(){
        car.setTransmission(Transmission.AUTO);
    }
    void buildSpeed(){
        car.setSpeed(200);
    }
}
class SubaryBuilder extends CarBuilder{
    void buildMake(){car.setMake("Subary");}
    void buildTransmission(){car.setTransmission(Transmission.MANUAL);}
    void buildSpeed(){car.setSpeed(320);}
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder b){
        builder = b;
    }

    Car BuildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildSpeed();
        Car car = builder.getCar();
        return car;
    }
}


/*
    class CarBuilder {
        String m = "Default";
        Transmission t = Transmission.MANUAL;
        int s = 120;

        CarBuilder builderMake(String m) {
            this.m = m;
            return this;
        }
        CarBuilder builderTransmission(Transmission t){
            this.t = t;
            return this;
        }
        CarBuilder builderSpeed(int s){
            this.s = s;
            return this;
        }
        Car builder(){
            Car car = new Car();
            car.setMake(m);
            car.setSpeed(s);
            car.setTransmission(t);
            return car;
        }
}
*/
