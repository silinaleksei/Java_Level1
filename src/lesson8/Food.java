package lesson8;

import java.util.Random;

import static lesson8.GameSnake.*;

public class Food extends Cell { // класс расшир€ет класс €чейки
  private final Random random;
  private final Snake snake;
  private Poison poison;
  // конструктор
  public Food(Snake snake) {
    super(-1, -1, GameSnake.CELL_SIZE, FOOD_COLOR); // конструктор суперкласса
    random = new Random();
    this.snake = snake;
  }

  public boolean isFood(int x, int y) {
    return (getX() == x) && (getY() == y);
  }
  // метод проверки съеденной еды по отрицательной координете
  public boolean isEaten() {
    return (getX() == -1);
  }

  public void eat() {
    set(-1, -1); // еда вне пол€
  }
  // метод по€влени€ еды
  public void appear() {
    int x, y;
    do {
      x = random.nextInt(CANVAS_WIDTH);
      y = random.nextInt(CANVAS_HEIGHT);
    } while (snake.isInSnake(x, y) || poison.isPoison(x, y));
    set(x, y);
  }

  public void setPoison(Poison poison) {
    this.poison = poison;
  }
}
