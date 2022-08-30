package lesson2;

public class Lesson2 {
  public static void main(String[] args) {
    System.out.println(checkSum(10, 10)); // true
    System.out.println(checkSum(10, 11)); // false
    checkNumberSign(0); // Number is positive
    checkNumberSign(-1); // Number is negative
    System.out.println(checkSignOfNumber(-1)); // true
    System.out.println(checkSignOfNumber(0)); // false
    System.out.println(checkSignOfNumber(5)); // false
    printString("Hello!", 0); // Print quantity = 0!
    printString("Hello!", 2); // Hello! Hello!
    System.out.println(isYearLeap(2024)); // true
    System.out.println(isYearLeap(2022)); // false
    listLeapYears(1900, 2024); // 1904, 1908, 1912 ... 2020, 2024
  }

  /* 1. �������� �����, ����������� �� ���� ��� ����� ����� � �����������,
  ��� �� ����� ����� � �������� �� 10 �� 20 (������������),
  ���� �� � ������� true, � ��������� ������ � false.
  */
  public static boolean checkSum(int num1, int num2) {
    int sum = num1 + num2;
    return sum >= 10 && sum <= 20 ? true : false;
  }

  /* 2. �������� �����, �������� � �������� ��������� ���������� ����� �����,
  ����� ������ ���������� � �������, ������������� �� ����� �������� ���
  �������������. ���������: ���� ������� ������������� ������.
  */

  public static void checkNumberSign(int num) {
    if (num >= 0) {
      System.out.println("Number is positive");
    } else {
      System.out.println("Number is negative");
    }
  }

  /* 3. �������� �����, �������� � �������� ��������� ���������� ����� �����.
  ����� ������ ������� true, ���� ����� �������������, � ������� false
  ���� �������������.
   */
  public static boolean checkSignOfNumber(int num) {
    return num < 0 ? true : false;
  }

  /* 4. �������� �����, �������� � �������� ���������� ���������� ������ � �����,
  ����� ������ ���������� � ������� ��������� ������, ��������� ���������� ���;
  */
  public static void printString(String str, int printQuantity) {
    for (int i = 0; i < printQuantity; i++) {
      System.out.println(str);
    }
    if (printQuantity == 0) {
      System.out.println("Print quantity = 0!");
    }
  }

  /* 5. * �������� �����, ������� ����������, �������� �� ��� ����������,
  � ���������� boolean (���������� - true, �� ���������� - false).
  ������ 4-� ��� �������� ����������, ����� ������� 100-��,
  ��� ���� ������ 400-� � ����������.
  */
  public static boolean isYearLeap(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? true : false;
  }

  // �����, ��������� ������ ���������� ����� � �������� ��������� ���
  public static void listLeapYears(int startRange, int endRange) {
    for (int i = startRange; i <= endRange; i++) {
      if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
        System.out.println(i);
      }
    }
  }
}
