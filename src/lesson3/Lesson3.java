package lesson3;

import java.util.Arrays;

public class Lesson3 {

  public static void main(String[] args) {
    changeElement(); // Origin array:  [1, 1, 0, 0, 1, 0, 1, 1, 0, 0]
                     // Changed array: [0, 0, 1, 1, 0, 1, 0, 0, 1, 1]
    System.out.println("***************************");
    initializationOfArray(); // [1, 2, 3, ...,99, 100]
    System.out.println("***************************");
    multElements(); // Origin array:  [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]
                    // Changed array: [2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]
    System.out.println("***************************");
    squareArray();
    System.out.println("***************************");
    System.out.println(Arrays.toString(createArray(5,1))); // [1, 1, 1, 1, 1]
    System.out.println("***************************");
    minMax(); // Min element = -10, Max element = 57
    System.out.println("***************************");
    minMaxElement(); // Min element = -45, Max element = 103
    System.out.println("***************************");
    System.out.println(balance(new int[] {2, 2, 2, 1, 2, 2, 10, 1})); // true Left part: 11 Right part: 11
    System.out.println("***************************");
    shiftOneElementLeft(new int[] {1,2,3}); // [2, 3, 1]
  }

  /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
  Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
  С помощью цикла и условия заменить 0 на 1, 1 на 0; */
  public static void changeElement() {
    int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    System.out.println("Origin array:  " + Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        array[i] = 1;
      } else if (array[i] == 1) {
        array[i] = 0;
      }
    }
    System.out.println("Changed array: " + Arrays.toString(array));
  }
  /* 2. Задать пустой целочисленный массив длиной 100.
  С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100; */
  public static void initializationOfArray() {
    int[] array = new int[100];
    for (int i = 0, j = 1; i < array.length; i++, j++) {
      array[i] = j;
    }
    System.out.println(Arrays.toString(array));
  }
  /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
  пройти по нему циклом, и числа меньшие 6 умножить на 2; */
  public static void multElements() {
    int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    System.out.println("Origin array:  " + Arrays.toString(array));
    for (int i = 0; i < array.length; i++) {
      if (array[i] < 6) {
        array[i] = array[i] * 2;
      }
    }
    System.out.println("Changed array: " + Arrays.toString(array));
  }

  /* 4. Создать квадратный двумерный целочисленный массив
  (количество строк и столбцов одинаковое),
  и с помощью цикла(-ов) заполнить его диагональные элементы единицами
  (можно только одну из диагоналей, если обе сложно).
  Определить элементы одной из диагоналей можно по следующему принципу:
  индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]; */
  public static void squareArray() {
    int[][] array = new int[5][5];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (i == j) {
          array[i][j] = 1;
        }
        array[i][(array.length - 1) - i] = 1;
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
  }

  /* 5. Написать метод, принимающий на вход два аргумента:
  len и initialValue,  и возвращающий одномерный массив типа int
  длиной len, каждая ячейка которого равна initialValue; */
  public static int[] createArray(int len, int initialValue) {
    int[] array = new int[len];
    for (int i = 0; i < array.length; i++) {
      array[i] = initialValue;
    }
    return array;
  }

  /* 6. * Задать одномерный массив и найти в нем минимальный и
  максимальный элементы */
  // for loop
  public static void minMax() {
    int[] array = {1, 9, 3, 8, 2, -10, 57};
    int min = array[0];
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
      if (array[i] > max) {
        max = array[i];
      }
    }
    System.out.println("Min element = " + min + ", Max element = " + max);
  }

  // foreach loop
  public static void minMaxElement() {
    int[] array = {1, 9, -45, 103};
    int min = array[0];
    int max = array[0];
    for (int i : array) {
      if (i < min) {
        min = i;
      }
      if (i > max) {
        max = i;
      }
    }
    System.out.println("Min element = " + min + ", Max element = " + max);
  }

  /* 7. ** Написать метод, в который передается не пустой
  одномерный целочисленный массив, метод должен вернуть true,
  если в массиве есть место, в котором сумма левой и
  правой части массива равны.
  **Примеры:
  checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) ? true,
  т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
  checkBalance([1, 1, 1, ||| 2, 1]) ? true,
  т.е. 1 + 1 + 1 = 2 + 1
  граница показана символами |||, эти символы в массив не входят
  и не имеют никакого отношения к ИЛИ. */

  public static boolean balance(int[] array) {
    int sumLeft = 0;
    int sumRight = 0;

    for (int i = 0; i < array.length; i++) {
      sumLeft += array[i];
      sumRight = 0;
      for (int j = i + 1; j < array.length; j++) {
        sumRight += array[j];
      }
      if (sumLeft == sumRight) break;
    }
    System.out.println("Left part: " + sumLeft);
    System.out.println("Right part: " + sumRight);
    return sumLeft == sumRight;
  }

  /* 8. *** Написать метод, которому на вход подается одномерный
  массив и число n (может быть положительным, или отрицательным),
  при этом метод должен сместить все элементы массива на n позиций.
  Элементы смещаются циклично.
  Для усложнения задачи нельзя пользоваться вспомогательными массивами.
  Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
  [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
  При каком n в какую сторону сдвиг можете выбирать сами. */
  // Метод, сдвигающий элементы массива на один влево
  public static void shiftOneElementLeft(int[] array) {
    int a = array[0];
    for (int i = 0; i < array.length - 1; i++) {
      array[i] = array[i + 1];
    }
    array[array.length - 1] = a;
    System.out.print(Arrays.toString(array));
  }
}
