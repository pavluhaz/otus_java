package data;

public enum CommandsData {
    ADD("add"),
    LIST("list"),
    EXIT("exit");

    public final String name;


    CommandsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    } //
}
