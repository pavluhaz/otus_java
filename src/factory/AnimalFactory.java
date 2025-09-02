package factory;

import animals.AbsAnimal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import data.AnimalTypeData;
import data.ColorData;

public class AnimalFactory {

        public AbsAnimal create(AnimalTypeData type, String name, int age, int weight, ColorData colorData) {
            switch (type) {
                case CAT:
                    return new Cat(name, age, weight, colorData);
                case DOG:
                    return new Dog(name, age, weight, colorData);
                case DUCK:
                    return new Duck(name, age, weight, colorData);
                default:
                    throw new IllegalArgumentException("Неизвестный тип животного: " + type);
            }
        }
    }