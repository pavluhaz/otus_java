package animals.Pets;

import animals.AbsAnimal;
import data.ColorData;

public class Cat extends AbsAnimal {
    public Cat(String name, int age, int weight, ColorData color) {
        super(name, age,weight,color);
    }
    @Override
    public void say() {
        System.out.println("Мяу");// переопределение метода родителя
    }

}
