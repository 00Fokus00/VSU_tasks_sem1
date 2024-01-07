package ru.vsu.cs.course1.Task8;

import org.apache.commons.cli.*;
import ru.vsu.cs.util.*;

import java.util.Locale;

public class Program {


    public static void winMain(){
        Locale.setDefault(Locale.ROOT);
        ru.vsu.cs.util.SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | (-r | -c) -i <in-file> [-o <out-file>])";

    public static void main(String[] args){
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("h", "help", false, "Show help");
        cmdLineOptions.addOption("w", "window", false, "Use window user interface");
        cmdLineOptions.addOption("i", "input-file", true, "Input file");
        cmdLineOptions.addOption("e", "execute", false, "Perform an operation");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;
        try {
            cmdLine = parser.parse(cmdLineOptions, args);
        } catch (Exception e){
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }

        if (cmdLine.hasOption("h")){
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }
        if (cmdLine.hasOption("w")){
            winMain();
        } else {
            if (!(cmdLine.hasOption("i"))){
                new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
                System.exit(1);
            }
            String inputFilename = cmdLine.getOptionValue("i");
            int[][] arr = ArrayUtils.readIntArray2FromFile(inputFilename);
            if (arr == null){
                System.err.printf("Can't read array from \"%s \"%n", inputFilename);
                System.exit(2);
            }
            /*Task.spiralArray(arr);*/
            if (Task.spiralArray(arr)){
                System.out.print("Массив упорядочен");
            } else {
                System.out.print("Массив не упорядочен");
            }
        }
    }
}

