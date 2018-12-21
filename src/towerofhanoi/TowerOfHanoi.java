/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.util.Stack;

/**
 *
 * @author florenthaxha
 */
public class TowerOfHanoi {

    private static int totalTurns = 0;

    public static void main(String[] args) {
        Stack<Disk> begin = new Stack();
        Stack<Disk> mid = new Stack();
        Stack<Disk> end = new Stack();
        int numberOfDisks = 8;

        setupDisks(begin, numberOfDisks);
        move(numberOfDisks, begin, mid, end);

        System.out.println("First Tower " + begin.size());
        System.out.println("Middle Tower " + mid.size());
        System.out.println("Last Tower " + end.size());
        System.out.println("Total Turns: " + totalTurns);

    }

    public static void setupDisks(Stack peg, int disks) {
        for (int i = 0; i < disks; i++) {
            int size = i + 1;
            Disk temp = new Disk(size);
            peg.push(temp);
        }

    }

    public static void move(int disks, Stack begin, Stack mid, Stack end) {
        if (disks > 0) {
            totalTurns++;
            move(disks - 1, begin, end, mid);
            end.push(begin.pop());
            move(disks - 1, mid, begin, end);
        }
    }
}
