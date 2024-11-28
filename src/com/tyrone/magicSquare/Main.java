package com.tyrone.magicSquare;

public class Main {
    public static void main(String[] args) {
        int[][] magic = {
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 8}
        };

        boolean result = Magic.isValidSquare(magic);

        System.out.println(result);



    }
}
