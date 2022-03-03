package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

/**
 * @author edmond
 */
public class UFClient {

    public UFClient() {
    }

    /**
     * @param n an integer value n from the command line to determine the number of "sites"
     * @return
     */
    public int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n, false);
        int count = 0; // The number of connection
        int a, b; // Random pairs of integers between 0 and n-1
        while (uf.components() > 1) {
            a = getRandomNum(n);
            b = getRandomNum(n);
            uf.connect(a, b);
            count++;
        }
        return count;
    }

    /**
     * @param n an integer value n from the command line to determine the number of "sites"
     * @return Then generates random number between 0 and n-1
     */

    private int getRandomNum(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    private static int getInputNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter n: ");

        //exception for no Num in
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter Integer! ");
            System.out.println("Please enter n: ");
            scanner = new Scanner(System.in);
        }
        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    private static int getMeanTime(int num){
        UFClient ufclient = new UFClient();
        int total = 0;
        int time = 100;
        for (int i = 0; i < time; i++) {
            total += ufclient.count(num);
        }
        return total/time;
    }

    public static void main(String[] args) {
        //Runs the experiment for input number
//        int num = getInputNumber();
//        int meanTime = getMeanTime(num);
//        System.out.println("n: " + num);
//        System.out.println("number of connection: " + meanTime);
//        System.out.println("1/2Nln(N) = " + 0.5 * num * Math.log(num));

        // Runs the experiment for a fixed set of n values
        System.out.println("number," + " connections number," + " 1/2Nln(N)");
        for(int i = 100; i <= 30000; i += 100){
            int meanTime = getMeanTime(i);
            System.out.println(i + "," + meanTime + "," + 0.5 * i * Math.log(i));
        }
    }




}
