package com.example.tandemtechtest;

import java.util.ArrayList;

public class SubCommand {
    public ArrayList<String> values;
    public String value;
    public String command;

    SubCommand(String command) {
        this.values = new ArrayList<String>();
        this.command = command;
        filter();
    }

    public void filter(){
        if (command.contains("-")) {
            int start = Integer.parseInt(this.command.split("-")[0]);
            int end = Integer.parseInt(this.command.split("-")[1]);
            for (int i = start; i <= end; i++) {
                this.values.add(Integer.toString(i));
            }
        } else if (command.contains(",")) {
            String[] values = command.split(",");
            for (String str : values) {
                this.values.add(str);
            }
        } else if (command.contains("/")) {
            String[] extractednums = this.command.split("/");
            if (extractednums[0].equals("*")) {
                extractednums[0] = "0";
            }
            int incrementor = Integer.parseInt(extractednums[0]);
            int factor = Integer.parseInt(extractednums[1]);
            while (incrementor < 60) {
                this.values.add(Integer.toString(incrementor));
                incrementor += factor;
            }
        }
    }

    @Override
    public String toString() {
        if (!this.values.isEmpty()) {
            String values = "";
            for (int i = 0; i <= this.values.size() - 1; i++) {
                values += this.values.get(i) + " ";
            }
            return values;
        } else if (this.value != null) {
            return value;
        } else {
            return this.command;
        }
    }
}
