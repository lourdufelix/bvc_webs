package org.tirava.restfulapi.machinehelper.entity;

import java.util.ArrayList;

/**
 * Created by maheedharan on 3/5/17.
 */
public class CommandVO {

    private String name;
    private String command;
    private ArrayList<String> arguments;
    private boolean enable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
