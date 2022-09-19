package lesson7;

public class Plate {
  private int food; // Количество еды в тарелке

  public Plate(int food) {
    this.food = food;
  }
  // Метод вычитания съеденной котом еды
  public void decreaseFood(int n) {
    food -= n;
  }
  // Метод добавления еды в тарелку с выводом количества добавленной еды
  public void increaseFood(int n) {
    food += n;
    System.out.println("Added " + n + " food");
  }

  // Метод показывающий остаток еды в тарелке
  public void infoPlate() {
    System.out.println("There's " + food + " food left");
  }

  public int getFood() {
    return food;
  }
}
