package ru.vsu.cs.course1.Task9_20;

import org.apache.commons.cli.*;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.SwingUtils;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {


    public static void winMain(){
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static final String PROGRAM_NAME_IN_HELP = "program (-h | -w | (-r | -c) -i <in-file> [-o <out-file>])";

    public static void main(String[] args) throws FileNotFoundException {
        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("h", "help", false, "Show help");
        cmdLineOptions.addOption("w", "window", false, "Use window user interface");
        cmdLineOptions.addOption("i", "input-file", true, "Input file");
        cmdLineOptions.addOption("e", "execute", false, "Perform an operation");
        cmdLineOptions.addOption("o", "output-file", true, "Output file");

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
            int[] arr = ArrayUtils.readIntArrayFromFile(inputFilename);
            if (arr == null){
                System.err.printf("Can't read array from \"%s \"%n", inputFilename);
                System.exit(2);
            }

            final List<Integer> inputList = new ArrayList<>();
            for (Integer value : arr) {
                inputList.add(value);
            }
            final List<Integer> answerList = Task.createNewList(inputList);
            final Integer[] arrayOfInteger = answerList.toArray(new Integer[0]);

            PrintStream out = (cmdLine.hasOption("o")) ? new PrintStream(cmdLine.getOptionValue("o")) : System.out;
            out.println(Arrays.toString(ArrayUtils.toPrimitive(arrayOfInteger)));
            out.close();

        }
    }
}

