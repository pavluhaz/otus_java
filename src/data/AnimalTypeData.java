package data;


import java.util.ArrayList;
import java.util.List;

public enum AnimalTypeData {
    CAT("Cat"),
    DOG("Dog"),
    DUCK("Duck");

    public final String name;


    AnimalTypeData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (AnimalTypeData type : values()) {
            names.add(type.getName());
        }
        return names;
    }
}
