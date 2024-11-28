package com.tyrone.magicSquare;

public class Magic {
    //check if magic square is valid
    private static int sum1 = 0;
    private static int sum2 = 0;
    private static int sum3 = 0;

    //check diagonal length
    private static boolean isValidDiagonal(int [][] magic){
        for (int i = 0; i < 3; i++) {
            sum1 += magic[i][i];
            sum2 += magic[2-i][i];
        }
        return sum1 == sum2;
    }
    private static boolean isValidRow(int [][] magic){
            for (int i = 0; i < 3; i++) {
                sum1 += magic[i][0];
                sum2 += magic[i][1];
                sum3 += magic[i][2];
            }
        return (sum1 == sum2) && (sum1 == sum3);
    }

    private static boolean isValidColumn(int [][] magic){
            for (int i = 0; i < 3; i++) {
                sum1 += magic[0][i];
                sum2 += magic[1][i];
                sum3 += magic[2][i];
                }
            return (sum1 == sum2) && (sum1 == sum3);
        }

        static boolean isValidSquare(int [][] magic) {
        return isValidRow(magic) && isValidColumn(magic) && isValidDiagonal(magic);
        }
    }
