package box_menu.banchen;

public class Form {
    int id;
    String item_name;
    String name;
    String type;
    String command;
    String command_form;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand_form() {
        return command_form;
    }

    public void setCommand_form(String command_form) {
        this.command_form = command_form;
    }

    public Form(int id, String item_name, String name, String type, String command, String command_form) {
        this.id = id;
        this.item_name = item_name;
        this.name = name;
        this.type = type;
        this.command = command;
        this.command_form = command_form;
    }
}
