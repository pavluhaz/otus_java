package animals.birds;

import animals.AbsAnimal;
import data.ColorData;

public class Duck extends AbsAnimal implements IFlying {
    public Duck(String name, int age, int weight, ColorData color) {
        super(name, age, weight, color);
    }
    @Override
    public void fly() { // реализация метода fly из интерфейса
        System.out.println("Я лечу");
    }
    public void say(){ // переопределение метода say
        System.out.println("Кря");
    }
}
