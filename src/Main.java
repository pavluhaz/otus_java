import animals.AbsAnimal;
import data.AnimalTypeData;
import data.ColorData;
import data.CommandsData;
import factory.AnimalFactory;
import tools.NumbersTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static data.ColorData.getColorByRussianName;


public class Main {

    public static void main(String... args) {
        List<AbsAnimal> animals = new ArrayList<>(); // создаем коллекцию животных

        Scanner scanner = new Scanner(System.in); // устройство ввода

        while (true) { // бесконечный цикл

            System.out.printf("Введите одну из команд: %s\n", String.join("/", getEnumNames())); // выводим список команд
            String commandUser = scanner.next().toLowerCase().trim(); // получаем команду пользователя
            scanner.nextLine(); // очищаем буфер

            boolean isCommandExist = false;
            for (CommandsData commandData : CommandsData.values()) { // перебираем все команды
                if (commandData.name().toLowerCase().equals(commandUser)) { // если команда введена верно
                    isCommandExist = true; // флаг что команда существует
                    break; // выходим из цикла
                }
            }
            if (!isCommandExist) { // если команда не найдена
                System.out.println("Команда не найдена");
                continue; // переходим к следующей итерации цикла
            }

            switch (commandUser) {
                case "add":
                    // Тип животного
                    AnimalTypeData type = null;
                    while (true) {
                        System.out.printf("Введите тип животного: %s\n", String.join(", ", AnimalTypeData.getNames()));
                        String animalTypeInput = scanner.nextLine();

                        try {
                            type = AnimalTypeData.valueOf(animalTypeInput.toUpperCase());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Неизвестный тип животного. Повторите ввод.");
                        }
                    }

                    // Имя
                    String name = "";
                    while (true) {
                        System.out.print("Введите имя животного: ");
                        name = scanner.nextLine();

                        if (name == null || name.trim().isEmpty()) {
                            System.out.println("Имя не может быть пустым. Повторите ввод.");
                            continue;
                        }

                        // Проверка на наличие только букв
                        String regex = "^[а-яА-ЯёЁa-zA-Z]+$"; // русские + английские буквы
                        if (!name.matches(regex)) {
                            System.out.println("Имя должно содержать только буквы. Повторите ввод.");
                            continue;
                        }

                        System.out.println("Имя успешно установлено.");
                        break;
                    }

                    // Возраст
                    int age;
                    while (true) {
                        System.out.print("Введите возраст животного: ");
                        String input = scanner.nextLine();

                        if (input.isEmpty()) {
                            System.out.println("Пустой ввод. Повторите.");
                            continue;
                        }

                        NumbersTools numberTools = new NumbersTools();
                        if (!numberTools.isNumber(input)) {
                            System.out.println("Некорректный возраст. Введите число от 1 до 99.");
                            continue;
                        }

                        try {
                            age = Integer.parseInt(input);
                            if (age < 0) {
                                System.out.println("Возраст не может быть отрицательным.");
                                continue;
                            }
                            System.out.println("Возраст успешно установлен.");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка при преобразовании числа.");
                        }
                    }
                    // Вес
                    int weight;
                    while (true) {
                        System.out.print("Введите вес животного (кг): ");
                        String input = scanner.nextLine();

                        if (input.isEmpty()) {
                            System.out.println("Пустой ввод. Повторите.");
                            continue;
                        }

                        NumbersTools numberTools = new NumbersTools();
                        if (!numberTools.isNumber(input)) {
                            System.out.println("Некорректный вес. Введите число от 1 до 99.");
                            continue;
                        }

                        try {
                            weight = Integer.parseInt(input);
                            if (weight < 0) {
                                System.out.println("Вес не может быть отрицательным.");
                                continue;
                            }
                            System.out.println("Вес успешно установлен.");
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка при преобразовании числа.");
                        }
                    }
                    // Цвет
                    ColorData colorData = null;
                    while (true) {
                        System.out.printf("Введите цвет животного: %s\n", String.join(", ", ColorData.getNames()));
                        String colorName = scanner.nextLine();
                        colorData = getColorByRussianName(colorName);

                        if (colorData != null) {
                            System.out.println("Цвет успешно установлен.");
                            break;
                        } else {
                            System.out.println("Неизвестный цвет. Попробуйте выбрать из списка");
                        }
                    }

                    // Создаём животное через фабрику
                    AnimalFactory animalFactory = new AnimalFactory();
                    AbsAnimal animalFromFactory = animalFactory.create(type, name, age, weight, colorData);

                    // Добавляем в список
                    animals.add(animalFromFactory);
                    System.out.println("Животное добавлено.");

                    System.out.print("Животное говорит: ");
                    animalFromFactory.say(); // реализация метода say() для каждого животного
                    break;

                case "list":
                    for (AbsAnimal animal : animals) {
                        System.out.println(animal.toString()); // выводим список животных
                    }
                    break;

                case "exit":
                    System.out.println("Goodbye"); // выводим сообщение до выхода
                    System.exit(0);
            }
        }
    }

    private static List<String> getEnumNames() { // получаем список имен команд из Enum
        List<String> names = new ArrayList<>();
        for (CommandsData command : CommandsData.values()) {
            names.add(command.name().toLowerCase());
        }
        return names;
    }
}