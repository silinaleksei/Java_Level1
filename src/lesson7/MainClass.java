package lesson7;

public class MainClass {
  public static void main(String[] args) {
    Plate p1 = new Plate(50);
    Cat c1 = new Cat("Murzik", 10);
    Cat c2 = new Cat("Barsik", 7);
    Cat c3 = new Cat("Objora", 35);
    Cat[] catArray = {c1, c2, c3}; // создаём массив котов

    for (Cat c : catArray) {
      do {
        c.eat(p1);
        if (c.isCatFull()) {
          System.out.println(c.getName() + " is full");
        } else {
          System.out.println(c.getName() + " is hungry!");
          p1.infoPlate();
          p1.increaseFood(1);
        }
      } while (!c.isCatFull());
    }
    System.out.println("Feeding is over!");
  }
}
