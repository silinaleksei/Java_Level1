package lesson8;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
  private final LinkedList<Cell> snake; // измен€емый двусв€зный массив (список) LinkedList объектов класса Cell
  private int direction; // голова змейки (направление движени€)
  private Food food;
  private Poison poison;
  // конструктор
  public Snake(int x, int y, int length, int direction) {
    snake = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      snake.add(new Cell(x - i, y, GameSnake.CELL_SIZE, Color.green)); //x - i - выстраивание €чеек вдоль координаты х
    }
    this.direction = direction;
  }
  // сеттер
  public void setFood(Food food) {
    this.food = food;
  }
  // получение размеров массива
  public int size() {
    return snake.size();
  }
  // сеттер
  public void setDirection(int direction) {
    if (Math.abs(this.direction - direction) != 2) { // 2 - разница между противоположнными кодами клавиш курсоров
      this.direction = direction;
    }
  }
  // метод проверки вхождени€ €чейки в змейку (наткнулись ли мы на еду или €д)
  public boolean isInSnake(int x, int y) {
    for (Cell cell : snake) {
      if (cell.getX() == x && cell.getY() == y) {
        return true;
      }
    }
    return false;
  }
  // метод движени€ змейки
  public void move() {
    int x = snake.getFirst().getX(); // переый элемент в списке по координате х
    int y = snake.getFirst().getY(); // переый элемент в списке по координате у
    switch (direction) {  // провер€ем текущее направление
      case GameSnake.KEY_LEFT -> { // если нажата кнопка влево, мен€ем координату по х влево (х--), по у не мен€ем
        x--;
        if (x < 0) x = GameSnake.CANVAS_WIDTH - 1; // по€вление змейки с противоположного кра€ пол€ после достижени€ левого кра€
      }
      case GameSnake.KEY_RIGHT -> {
        x++;
        if (x == GameSnake.CANVAS_WIDTH) x = 0;
      }
      case GameSnake.KEY_UP -> {
        y--;
        if (y < 0) y = GameSnake.CANVAS_HEIGHT - 1;
      }
      case GameSnake.KEY_DOWN -> {
        y++;
        if (y == GameSnake.CANVAS_HEIGHT) y = 0;
      }
    }
    if (isInSnake(x, y) || poison.isPoison(x, y)) {
      GameSnake.gameOver = true;
      return;
    }

    snake.addFirst(new Cell(x, y, GameSnake.CELL_SIZE, GameSnake.SNAKE_COLOR)); // перерисовка головы

    if (food.isFood(x, y)) { // если совпали координаты еды
      food.eat(); // устанавливаем координаты set(-1, -1); - еда пропадает с пол€
    } else {
      snake.removeLast(); // убираем хвост, но если еда съедена - оставл€ем
    }
  }

  public void paint(Graphics2D graphics2D) {
    for (Cell cell : snake) {
      cell.paint(graphics2D);
    }
  }

  public void setPoison(Poison poison) {
    this.poison = poison;
  }
}
