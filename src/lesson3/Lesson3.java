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

  /* 1. ������ ������������� ������, ��������� �� ��������� 0 � 1.
  ��������: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
  � ������� ����� � ������� �������� 0 �� 1, 1 �� 0; */
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
  /* 2. ������ ������ ������������� ������ ������ 100.
  � ������� ����� ��������� ��� ���������� 1 2 3 4 5 6 7 8 � 100; */
  public static void initializationOfArray() {
    int[] array = new int[100];
    for (int i = 0, j = 1; i < array.length; i++, j++) {
      array[i] = j;
    }
    System.out.println(Arrays.toString(array));
  }
  /* 3. ������ ������ [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
  ������ �� ���� ������, � ����� ������� 6 �������� �� 2; */
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

  /* 4. ������� ���������� ��������� ������������� ������
  (���������� ����� � �������� ����������),
  � � ������� �����(-��) ��������� ��� ������������ �������� ���������
  (����� ������ ���� �� ����������, ���� ��� ������).
  ���������� �������� ����� �� ���������� ����� �� ���������� ��������:
  ������� ����� ��������� �����, �� ���� [0][0], [1][1], [2][2], �, [n][n]; */
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

  /* 5. �������� �����, ����������� �� ���� ��� ���������:
  len � initialValue,  � ������������ ���������� ������ ���� int
  ������ len, ������ ������ �������� ����� initialValue; */
  public static int[] createArray(int len, int initialValue) {
    int[] array = new int[len];
    for (int i = 0; i < array.length; i++) {
      array[i] = initialValue;
    }
    return array;
  }

  /* 6. * ������ ���������� ������ � ����� � ��� ����������� �
  ������������ �������� */
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

  /* 7. ** �������� �����, � ������� ���������� �� ������
  ���������� ������������� ������, ����� ������ ������� true,
  ���� � ������� ���� �����, � ������� ����� ����� �
  ������ ����� ������� �����.
  **�������:
  checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) ? true,
  �.�. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
  checkBalance([1, 1, 1, ||| 2, 1]) ? true,
  �.�. 1 + 1 + 1 = 2 + 1
  ������� �������� ��������� |||, ��� ������� � ������ �� ������
  � �� ����� �������� ��������� � ���. */

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

  /* 8. *** �������� �����, �������� �� ���� �������� ����������
  ������ � ����� n (����� ���� �������������, ��� �������������),
  ��� ���� ����� ������ �������� ��� �������� ������� �� n �������.
  �������� ��������� ��������.
  ��� ���������� ������ ������ ������������ ���������������� ���������.
  �������: [ 1, 2, 3 ] ��� n = 1 (�� ���� ������) -> [ 3, 1, 2 ];
  [ 3, 5, 6, 1] ��� n = -2 (�� ��� �����) -> [ 6, 1, 3, 5 ].
  ��� ����� n � ����� ������� ����� ������ �������� ����. */
  // �����, ���������� �������� ������� �� ���� �����
  public static void shiftOneElementLeft(int[] array) {
    int a = array[0];
    for (int i = 0; i < array.length - 1; i++) {
      array[i] = array[i + 1];
    }
    array[array.length - 1] = a;
    System.out.print(Arrays.toString(array));
  }
}
