package lesson7;

public class Cat {
  private final String name; // Кличка кота
  private final int appetite; // Аппетит кота
  private boolean satiety = false; // Сытость кота

  public Cat(String name, int appetite) {
    this.name = name;
    this.appetite = appetite;
  }
  // Метод кормления кота едой из тарелки Plate с проверкой достаточности еды
  public void eat(Plate p) {
    if ((p.getFood() - appetite) >= 0) { // // если еды коту не достаточно, кормление невозможно
      p.decreaseFood(appetite);
      satiety = true; // Если коту хватило еды, сытость = true.
    } else {
      System.out.println("There is not enough food! Add food!");
    }
    if (p.getFood() == 0) {
      System.out.println("Plate is empty!!!");
    }
  }
  // Метод проверяющий сытость кота
  public boolean isCatFull() {
    return satiety;
  }

  public String getName() {
    return name;
  }
}
