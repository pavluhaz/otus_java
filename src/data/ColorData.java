package data;


import java.util.ArrayList;
import java.util.List;

public enum ColorData {

    RED("красный"),
    GREEN("зеленый"),
    BLUE("синий"),
    YELLOW("желтый"),
    WHITE("белый");

    private final String name;


    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static ColorData getColorByRussianName(String name) {
        for (ColorData color : ColorData.values()) {
            if (color.getName().equalsIgnoreCase(name)) {
                return color;
            }
        }
        return null;
    }
    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (ColorData color : values()) {
            names.add(color.getName());
        }
        return names;
    }
}
