package com.waterbuckettest.cli;

import com.waterbuckettest.core.BucketState;
import com.waterbuckettest.core.RiddleEntry;
import com.waterbuckettest.core.RiddleSolution;
import com.waterbuckettest.core.Solver;

import java.util.Iterator;
import java.util.Scanner;

class Cli {

    Cli(){

        welcome();
        printInstructions();
        RiddleEntry parameters = inputParameters();
        RiddleSolution solution = new Solver().solveRiddle(parameters.getBucket1(),parameters.getBucket2(),parameters.getMeasure());
        displaySolution(solution);
        reRun();
    }

    private void welcome(){
        System.out.println(CliConstants.WELCOME_MESSAGE);
    }

    private void printInstructions() {
        System.out.println(CliConstants.RIDDLE_INTRO);
    }

    private RiddleEntry inputParameters(){

        RiddleEntry parameters = new RiddleEntry();
        //Capacity bucket X
        System.out.print("Enter capacity bucket X: \n");
        parameters.setBucket1(inputPositiveInputParameter());

        //Capacity bucket Y
        System.out.print("Enter capacity bucket Y: \n");
        parameters.setBucket2(inputPositiveInputParameter());

        //Amount of gallons to get
        System.out.print("Enter amount Z of gallons: \n");
        parameters.setMeasure(inputPositiveInputParameter());

        return parameters;
    }

    /** Gets  positive integer parameter from console*/
    private int inputPositiveInputParameter(){

        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            try {
                int n = Integer.parseInt(line);
                if (n > 0) {
                    return n;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println(CliConstants.RE_ENTER);
        }
    }

    private void displaySolution(RiddleSolution solution){

        if(solution == null)
            System.out.println("No solution for this input.\n");
        else {
            Iterator<String> actionsIterator = solution.getActions().iterator();
            Iterator<BucketState> statesIterator = solution.getStates().iterator();
            BucketState bs;
            while (actionsIterator.hasNext() && statesIterator.hasNext()) {
                System.out.print(actionsIterator.next() + " -> ");
                bs = statesIterator.next();
                System.out.println("(" + bs.getBucketX() + "," + bs.getBucketY() + ")");
            }
        }
        System.out.println();
    }

    private void reRun(){

        System.out.print(CliConstants.RUN_AGAIN);
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals("y")) {
                new Cli();
            }
            if(line.equals("n")){
                System.out.print("Bye!!!");
                break;
            }
            System.out.print(CliConstants.RUN_AGAIN);
        }
    }
}
