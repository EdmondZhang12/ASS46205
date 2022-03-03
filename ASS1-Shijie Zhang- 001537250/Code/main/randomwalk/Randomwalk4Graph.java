package edu.neu.coe.info6205.randomwalk;
import java.util.Random;

public class Randomwalk4Graph {
    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        // FIXME do move by replacing the following code
        // get the current position
        x += dx;
        y += dy;
        // END
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        // FIXME
        // randomMove of m steps
        while(m > 0){
            randomMove();
            m--;
        }
        // END
    }

    /**
     * Private method to generate a random move according to the rules of the situation.
     * That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
        int step = random.nextBoolean() ? 1 : -1;
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        // FIXME
        //get the distance from the origin
        double dist = Math.sqrt((x*x)+(y*y));
        return dist;
        // END
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++) {
            Randomwalk4Graph walk = new Randomwalk4Graph();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance / n;
    }

    public static void main(String[] args) {
        int n = 30;
        int times = 0;
        System.out.println(" n "+ " d");
        for(int m = 2; m < 201; m++){
            for(int i = 0; i < 10; i++){
                double meanDistance = randomWalkMulti(m,n);
                System.out.println(m + "  " + meanDistance);
                times += 1;
            }
        }
        System.out.println("The program has been ran " + times + " times");

    }

}
