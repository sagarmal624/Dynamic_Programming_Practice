package com.example.mongodbpoc.matrix;

public class MatrixDemo {
    public static void printDiagonal(int matrix[][], int row, int col) {

        for (int i = 0; i < row; i++) {
            System.out.println(matrix[i][i]);
        }
        for (int i = 0, j = col - 1; i < row; i++) {
            System.out.println(matrix[i][col]);
            col--;
        }

    }

    public static void main(String[] args) {

    }
}
