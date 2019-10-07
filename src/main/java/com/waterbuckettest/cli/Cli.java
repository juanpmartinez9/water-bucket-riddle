package com.waterbuckettest.cli;

import com.waterbuckettest.core.*;

import java.util.Iterator;
import java.util.Scanner;

class Cli {

    Cli(){
        welcome();
        printInstructions();
        RiddleEntry parameters = inputParameters();
        Solution solution = new Solver().solveRiddle(parameters.getBucket1(),parameters.getBucket2(),parameters.getMeasure());
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
        System.out.print(CliConstants.BUCKET_X);
        parameters.setBucket1(inputPositiveInputParameter());

        //Capacity bucket Y
        System.out.print(CliConstants.BUCKET_Y);
        parameters.setBucket2(inputPositiveInputParameter());

        //Amount of gallons to get
        System.out.print(CliConstants.AMOUNT_Z);
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

    private void displaySolution(Solution solution){

        System.out.println("\n---- Solution ----");
        if(solution.getSteps() == 0)
            System.out.println(((NoSolution) solution).getErrorMessage());
        else {
            Iterator<String> actionsIterator = ((WaterBucketRiddleSolution)solution).getActions().iterator();
            Iterator<BucketState> statesIterator = ((WaterBucketRiddleSolution)solution).getStates().iterator();
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
