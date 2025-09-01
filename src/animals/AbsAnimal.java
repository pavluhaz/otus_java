package animals;

import data.ColorData;

import java.awt.*;

public abstract class AbsAnimal {

    private String name = "";
    private int age = -1;
    private int weight = -1;
    private ColorData colorData = null;

    public AbsAnimal(String name, int age, int weight, ColorData colorData) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.colorData = colorData;
    }

    public String getName() {
        return name;
    }

    public void say(){
        System.out.println("Я говорю");
        }
    public void eat() {
            System.out.println("Я ем");
        }
    public void drink(){
        System.out.println("Я пью");
        }
    public void go(){
        System.out.println("Я иду");
            }

    public String toString() { // переопределение метода toString , метод owerride необязателен
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s", name,age,getYearsCase(),weight,colorData.getName());
    }

    private String getYearsCase() { // Возвращает правильное окончание слова "год"
        int remains = age % 10;// Остаток от деления на 10

        if (age >= 11 && age <= 14) { // Если отстаток от деления на 10 равен 11, 12 или 13
            return "лет";
        }
        if (remains == 1) { // Если остаток от деления на 10 равен 1
            return "год";
        }
        if (remains >= 2 && remains <= 4) { // Если остаток от деления на 10 равен 2, 3 или 4
            return "года";
        }
        return "лет"; // Возвращаем пустую строку, если остаток от деления на 10 не равен 0, 1, 2, 3, 4, 5, 6, 7, 8 или 9
    }
}
