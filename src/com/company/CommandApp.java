package com.company;

/*Command похож на Facade. Но Фасад использует ссылки на разные классы - power/dvd-rom/hdd.
* А Комманд использует ссылки только 1 класса - user*/

public class CommandApp {
    public static void main(String[] args){
        Comp c = new Comp();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));

        u.startComputer();
        u.stopComputer();
        u.resetComputer();
    }
}

interface Command {
    void execute();
}
//Reciver
class Comp {
    void start() {
        System.out.println("start");
    }
    void stop(){
        System.out.println("stop");
    }
    void reset(){
        System.out.println("reset");
    }
}

//Concrete Command
class StartCommand implements Command {
    Comp computer;
    public StartCommand(Comp computer) {
        this.computer = computer;
    }
    public void execute() {
        computer.start();
    }
}
class StopCommand implements Command {
    Comp computer;
    public StopCommand(Comp computer) {
        this.computer = computer;
    }
    public void execute() {
        computer.stop();
    }
}
class ResetCommand implements Command {
    Comp computer;
    public ResetCommand(Comp computer) {
        this.computer = computer;
    }
    public void execute() {
        computer.reset();
    }
}

//Invoker (умеет работать только с коммандами. Работает только с интерфейсом)
class User {
    Command start;
    Command stop;
    Command reset;
    public User(Command start, Command stop, Command reset){
       this.start = start;
       this.stop = stop;
       this.reset = reset;
    }
    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}