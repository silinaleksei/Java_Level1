package lesson7;

public class Plate {
  private int food; // ���������� ��� � �������

  public Plate(int food) {
    this.food = food;
  }
  // ����� ��������� ��������� ����� ���
  public void decreaseFood(int n) {
    food -= n;
  }
  // ����� ���������� ��� � ������� � ������� ���������� ����������� ���
  public void increaseFood(int n) {
    food += n;
    System.out.println("Added " + n + " food");
  }

  // ����� ������������ ������� ��� � �������
  public void infoPlate() {
    System.out.println("There's " + food + " food left");
  }

  public int getFood() {
    return food;
  }
}
