package lesson8;

import java.awt.*;

public class Cell { // класс описывающий €чеки игрового пол€
  private int x; // координата по оси ’
  private int y; // координата по оси y
  private final int size; // размер €чейки
  private final Color color; // цвет €чейки
  // конструктор
  public Cell(int x, int y, int size, Color color) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.color = color;
  }
  // сеттер координат
  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }
  // геттеры координат по ос€м
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
  // метод дл€ отрисовки €чейки
  public void paint(Graphics2D graphics2D) { // класс Graphics2D дл€ отрисовки двумерных объектов
    graphics2D.setColor(color);
    graphics2D.fillOval(x * size, y * size, size, size); // кругла€ форма €чейки змейки
  }
}
