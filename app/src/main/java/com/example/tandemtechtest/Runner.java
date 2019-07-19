package com.example.tandemtechtest;

import java.util.Scanner;

class Runner{
    public Scanner scanner;
    public String command;

    public Runner(){
        this.scanner = new Scanner(System.in);
    }

    public static void main(String [] args){
        Runner commandRunner = new Runner();
        commandRunner.start();
    }

    public void start(){
        String command;
        while(true){
            command = this.scanner.nextLine();
            break;
        }
        this.command = command;
        String[] sub_commands = command.split(" ");
        this.output(sort("min",sub_commands[0]), sort("hours",sub_commands[1]), sort("daysOfMon",sub_commands[2]), sort("mon",sub_commands[3]), sort("daysOfWeek",sub_commands[4]));
    }

    public SubCommand sort(String format, String subCommand){
        switch(format) {
            case "min":
                SubCommand mins = createSubCommand("1-60", subCommand);
                return mins;
            case "hours":
                SubCommand hours = createSubCommand("1-24", subCommand);
                return hours;
            case "daysOfMon":
                SubCommand daysOfMon = createSubCommand("1-31", subCommand);
                return daysOfMon;
            case "mon":
                SubCommand mon = createSubCommand("1-12", subCommand);
                return mon;
            case "daysOfWeek":
                SubCommand daysOfWeek = createSubCommand("1-7", subCommand);
                return daysOfWeek;
            default:
                return new SubCommand("0-59");
        }
    }

    public SubCommand createSubCommand(String range, String subCommand){
        if (subCommand.equals("*")){
            return new SubCommand(range);
        } else {
            return new SubCommand(subCommand);
        }
    }

    public void output(SubCommand...commands){
        System.out.println("***");
        System.out.print("Minutes: ");
        System.out.println(commands[0]);
        System.out.print("Hours: ");
        System.out.println(commands[1]);
        System.out.print("Day of Month: ");
        System.out.println(commands[2]);
        System.out.print("Month: ");
        System.out.println(commands[3]);
        System.out.print("Day of the Week: ");
        System.out.println(commands[4]);
        System.out.print("Command: ");
        String[] commandLine = this.command.split(" ");
        System.out.println(commandLine[commandLine.length -1]);
        System.out.println("***");
    }
}

//*/15 0 1,15 * 1-5 /usr/bin/find
//*/15 0 1,15 * 1-5 /usr/bin/find
//*/15 0 1,15 1,4,11 1-5 /usr/bin/find
//*/9 0 1,15 * 1-5 /usr/bin/find