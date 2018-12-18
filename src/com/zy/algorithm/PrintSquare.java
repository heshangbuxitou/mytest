package com.zy.algorithm;


enum Direction {
    GO_RIGHT,
    GO_DOWN,
    GO_LEFT,
    GO_UP;
}

/**
 * @ClassName PrintSquare
 * @Description 输出矩阵
 * @Author zhu.yong
 * @Date 2018/12/17 23:15
 * @Version 1.0
 */
public class PrintSquare {
    private int sideLength = 1;
    private String[][] elementList;

    public PrintSquare(int sideLength) {
        this.sideLength = sideLength;
        elementList = new String[sideLength][sideLength];
    }

    public void printSquareToConsole() {
        int row = 0;
        int col = 0;
        Direction direction = Direction.GO_RIGHT;
        for (int i = 1; i < sideLength * sideLength + 1; i++) {
            elementList[row][col] = String.valueOf(i);
            switch (direction) {
                case GO_RIGHT:
                    col++;
                    if (col == sideLength || elementList[row][col] != null) {
                        col--;
                        row++;
                        direction = Direction.GO_DOWN;
                    }
                    break;
                case GO_DOWN:
                    row++;
                    if (row == sideLength || elementList[row][col] != null) {
                        row--;
                        col--;
                        direction = Direction.GO_LEFT;
                    }
                    break;
                case GO_UP:
                    row--;
                    if (row == -1 || elementList[row][col] != null) {
                        row++;
                        col++;
                        direction = Direction.GO_RIGHT;
                    }
                    break;
                case GO_LEFT:
                    col--;
                    if (col == -1 || elementList[row][col] != null) {
                        col++;
                        row--;
                        direction = Direction.GO_UP;
                    }
                    break;
                default:
            }
        }

        printSquare();
    }

    private void printSquare() {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                System.out.print(elementList[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintSquare printSquare = new PrintSquare(9);
        printSquare.printSquareToConsole();
    }
}


