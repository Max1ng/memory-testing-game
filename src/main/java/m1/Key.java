package m1;

import java.util.HashSet;
import java.util.Random;

public class Key {

    public int[] solution;

    public Key() {
        solution = new int[16];
        generateSolution();
    }

    private void generateSolution() {

        // make new hashset with possible button values
        HashSet<Integer> numList = new HashSet<Integer>();
        numList.add(0);
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);
        numList.add(7);
        numList.add(8);
        numList.add(9);
        numList.add(10);
        numList.add(11);
        numList.add(12);
        numList.add(13);
        numList.add(14);
        numList.add(15);

        int index = 0;
        Random rand = new Random();
        int randNum;
        // run while hashset has numbers in it
        while (!numList.isEmpty() && index < 16) {
            randNum = rand.nextInt(16);
            // if number is in hashset still set key[i] = to that value

            if (numList.contains(randNum)) {
                solution[index] = randNum;
                index++;
                // remove that number from hashset
                numList.remove(randNum);
            }

        }

        // replace top half of hashet with matching lower values
        for (int x = 0; x < solution.length; x++) {
            if (solution[x] == 8) {
                solution[x] = 0;
            } else if (solution[x] == 9) {
                solution[x] = 1;
            } else if (solution[x] == 10) {
                solution[x] = 2;
            } else if (solution[x] == 11) {
                solution[x] = 3;
            } else if (solution[x] == 12) {
                solution[x] = 4;
            } else if (solution[x] == 13) {
                solution[x] = 5;
            } else if (solution[x] == 14) {
                solution[x] = 6;
            } else if (solution[x] == 15) {
                solution[x] = 7;
            }

        }
    }
}
