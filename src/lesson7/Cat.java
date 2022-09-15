package lesson7;

public class Cat {
  private final String name; // ������ ����
  private final int appetite; // ������� ����
  private boolean satiety = false; // ������� ����

  public Cat(String name, int appetite) {
    this.name = name;
    this.appetite = appetite;
  }
  // ����� ��������� ���� ���� �� ������� Plate � ��������� ������������� ���
  public void eat(Plate p) {
    if ((p.getFood() - appetite) >= 0) { // // ���� ��� ���� �� ����������, ��������� ����������
      p.decreaseFood(appetite);
      satiety = true; // ���� ���� ������� ���, ������� = true.
    } else {
      System.out.println("There is not enough food! Add food!");
    }
    if (p.getFood() == 0) {
      System.out.println("Plate is empty!!!");
    }
  }
  // ����� ����������� ������� ����
  public boolean isCatFull() {
    return satiety;
  }

  public String getName() {
    return name;
  }
}
