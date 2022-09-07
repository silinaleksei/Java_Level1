package lesson4;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
  public static char[][] map;
  public static final int SIZE = 3;
  public static final char DOT_EMPTY = '-';
  public static final char DOT_X = 'X';
  public static final char DOT_O = 'O';
  public static Scanner sc = new Scanner(System.in);
  public static Random rand = new Random();

  public static void main(String[] args) {

    initMap();
    printMap();
    while (true) {
      humanTurn();
      printMap();
      if (checkWin(DOT_X)) {
        System.out.println("Human won!");
        break;
      }
      if (isMapFull()) {
        System.out.println("DRAW!");
        break;
      }
      aiTurn();
      printMap();
      if (checkWin(DOT_O)) {
        System.out.println("AI won!");
        break;
      }
      if (isMapFull()) {
        System.out.println("DRAW!");
        break;
      }
    }
    System.out.println("GAME OVER!");
  }

  public static void humanTurn() {
    int x, y;
    do {
      System.out.println("Enter coordinates X: Y:");
      x = sc.nextInt() - 1;
      y = sc.nextInt() - 1;
    } while (!isCellValid(x, y));
    map[x][y] = DOT_X;
  }

  /* метод aiTurn переписан ниже с добавлением блокирующего условия
  public static void aiTurn() {
    int x, y;
    do {
      x = rand.nextInt(SIZE);
      y = rand.nextInt(SIZE);
    } while (!isCellValid(x, y));
    System.out.println("Turn AI X:" + (x + 1) + " Y:" + (y + 1));
    map[x][y] = DOT_0;
  }*/

  public static void initMap() {
    map = new char[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        map[i][j] = DOT_EMPTY;
      }
    }
  }

  public static void printMap() {
    System.out.print("X|Y ");
    for (int i = 1; i <= SIZE; i++) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i = 0; i < SIZE; i++) {
      System.out.print(i + 1 + "   ");
      for (int j = 0; j < SIZE; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static boolean isMapFull() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (map[i][j] == DOT_EMPTY) return false;
      }
    }
    return true;
  }

  public static boolean isCellValid(int x, int y) {
    if (x < 0 || x > SIZE || y < 0 || y > SIZE) return false;
    if (map[x][y] == DOT_EMPTY) return true;
    return false;
  }

  /* более короткая запись метода isCellValid:
  public static boolean isCellValid(int x, int y) {
    if (map[x][y] == DOT_EMPTY && !(x < 0 || x > SIZE || y < 0 || y > SIZE)) return true;
    return false;
  }*/

  // method checkWin with for loop
  public static boolean checkWin(char symb) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (map[i][0] == symb && map[i][1] == symb && map[i][2] == symb) return true;
        if (map[0][j] == symb && map[1][j] == symb && map[2][j] == symb) return true;
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
      }
    }
    return false;
  }
  /* метод checkWin переписан с использованием циклав (см. выше)
  public static boolean checkWin(char symb) {
  	if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
  	if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
  	if(map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
  	if(map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
  	if(map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
  	if(map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
  	if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
  	if(map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
  	return false;
  }*/

  // Smart method aiTurn() -с блокирующим ходом ai:
  public static void aiTurn() {
    int x, y;
    do {
      // row 0
      if (map[0][0] == DOT_X && map[0][1] == DOT_X && isCellValid(0, 2)) {
        x = 0;
        y = 2;
      } else if (map[0][1] == DOT_X && map[0][2] == DOT_X && isCellValid(0, 0)) {
        x = 0;
        y = 0;
      } else if (map[0][0] == DOT_X && map[0][2] == DOT_X && isCellValid(0, 1)) {
        x = 0;
        y = 1;
      }
      // row 1
      else if (map[1][0] == DOT_X && map[1][1] == DOT_X && isCellValid(1, 2)) {
        x = 1;
        y = 2;
      } else if (map[1][1] == DOT_X && map[1][2] == DOT_X && isCellValid(1, 0)) {
        x = 1;
        y = 0;
      } else if (map[1][0] == DOT_X && map[1][2] == DOT_X && isCellValid(1, 1)) {
        x = 1;
        y = 1;
      }
      // row 2
      else if (map[2][0] == DOT_X && map[2][1] == DOT_X && isCellValid(2, 2)) {
        x = 2;
        y = 2;
      } else if (map[2][1] == DOT_X && map[2][2] == DOT_X && isCellValid(2, 0)) {
        x = 2;
        y = 0;
      } else if (map[2][0] == DOT_X && map[2][2] == DOT_X && isCellValid(2, 1)) {
        x = 2;
        y = 1;
      }
      // column 0
      else if (map[0][0] == DOT_X && map[1][0] == DOT_X && isCellValid(2, 0)) {
        x = 2;
        y = 0;
      } else if (map[0][0] == DOT_X && map[2][0] == DOT_X && isCellValid(1, 0)) {
        x = 1;
        y = 0;
      } else if (map[2][0] == DOT_X && map[1][0] == DOT_X && isCellValid(0, 0)) {
        x = 0;
        y = 0;
      }
      // column 1
      else if (map[0][1] == DOT_X && map[1][1] == DOT_X && isCellValid(2, 1)) {
        x = 2;
        y = 1;
      } else if (map[0][1] == DOT_X && map[2][1] == DOT_X && isCellValid(1, 1)) {
        x = 1;
        y = 1;
      } else if (map[2][1] == DOT_X && map[1][1] == DOT_X && isCellValid(0, 1)) {
        x = 0;
        y = 1;
      }
      // column 2
      else if (map[0][2] == DOT_X && map[1][2] == DOT_X && isCellValid(2, 2)) {
        x = 2;
        y = 2;
      } else if (map[0][2] == DOT_X && map[2][2] == DOT_X && isCellValid(1, 2)) {
        x = 1;
        y = 2;
      } else if (map[2][2] == DOT_X && map[1][2] == DOT_X && isCellValid(0, 2)) {
        x = 0;
        y = 2;
      }
      // diagonal 1
      else if (map[0][0] == DOT_X && map[1][1] == DOT_X && isCellValid(2, 2)) {
        x = 2;
        y = 2;
      } else if (map[0][0] == DOT_X && map[2][2] == DOT_X && isCellValid(1, 1)) {
        x = 1;
        y = 1;
      } else if (map[2][2] == DOT_X && map[1][1] == DOT_X && isCellValid(0, 0)) {
        x = 0;
        y = 0;
      }
      // diagonal 2
      else if (map[0][2] == DOT_X && map[1][1] == DOT_X && isCellValid(2, 0)) {
        x = 2;
        y = 0;
      } else if (map[0][2] == DOT_X && map[2][0] == DOT_X && isCellValid(1, 1)) {
        x = 1;
        y = 1;
      } else if (map[2][0] == DOT_X && map[1][1] == DOT_X && isCellValid(0, 2)) {
        x = 0;
        y = 2;
      } else {
        x = rand.nextInt(SIZE);
        y = rand.nextInt(SIZE);
      }
    } while (!isCellValid(x, y));
    System.out.println("AI turn into X: " + (x + 1) + " Y: " + (y + 1));
    map[x][y] = DOT_O;
  }
}
