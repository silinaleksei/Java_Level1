package lesson8;

import javax.swing.*; // библиотека (пакет) Swing для работы с графическим интерфейсом, содержит класс JFrame (окно)
import java.awt.*; // пакет для работы с графическим интерфейсом - для создания игрового поля, содержит класс COLOR
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameSnake extends JFrame { // наследуемся от класса JFrame, чтобы игра открывалась в отдельном окне
  final String TITLE_OF_PROGRAM = "Classic Game Snake"; // заголовок игры
  final String GAME_OVER_MSG = "GAME OVER"; // сообщение "Игра закончена"
  static final int CELL_SIZE = 20; // size of cell in pix
  static final int CANVAS_WIDTH = 30; // width in cells - ширина игрового поля
  static final int CANVAS_HEIGHT = 25; // height in cells - высота игрового поля
  static final Color SNAKE_COLOR = Color.green; // цвет змейки
  static final Color FOOD_COLOR = Color.darkGray;// цвет еды
  static final Color POISON_COLOR = Color.red;// цвет яда
  static final int KEY_LEFT = 37; // код кнопки "Стрелка влево"
  static final int KEY_UP = 38; // код кнопки "Стрелка вверх"
  static final int KEY_RIGHT = 39; // код кнопки "Стрелка вправо"
  static final int KEY_DOWN = 40; // код кнопки "Стрелка вниз"
  final int START_SNAKE_SIZE = 5; // initialization data - начальный размер змейки
  final int START_SNAKE_X = CANVAS_WIDTH / 2; //   for - начальная координата головы змейки по оси Х - половина размера поля
  final int START_SNAKE_Y = CANVAS_HEIGHT / 2; //   snake - начальная координата головы змейки по оси Y - середина поля
  final int SNAKE_DELAY = 150; // snake delay in milliseconds
  int snakeSize = 0; // current snake size
  static boolean gameOver = false; // a sign game is over or not

  Canvas canvas; // объявление переменной типа класса Canvas
  Snake snake; // объявление переменной типа класса Snake
  Food food; // объявление переменной типа класса Food
  Poison poison; // объявление переменной типа класса Poison
// Конструктор класса GameSnake
  public GameSnake() {
    setTitle(TITLE_OF_PROGRAM); // метод класса JFrame для установки заголовка
    setDefaultCloseOperation(EXIT_ON_CLOSE); // метод класса JFrame для закрытия окна

    canvas = new Canvas(); // создаём объект класса Canvas - игоровое поле
    canvas.setBackground(Color.gray); // метод устаноки цвета фона игрового поля, в параметре объект класса Color
    canvas.setPreferredSize( // метод устаноки размера игрового поля, в параметре объект класса Dimension из пакета awt
        new Dimension(CELL_SIZE * CANVAS_WIDTH,
                      CELL_SIZE * CANVAS_HEIGHT));

    addKeyListener( // слушатель нажатия кнопок
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) { // Listener будет срабатывать при нажатии кнопки
            snake.setDirection(e.getKeyCode()); // изменение напраления движения по нажатию кнопок
          }
        });
    // встроенные в пакет awt методы
    add(canvas); // добавляем в окно программы игровое поле
    pack(); // метод для согласования размеров игрового поля и окна
    setLocationRelativeTo(null); // установка места появления окна: null - по центру
    setResizable(false); // установка способности изменения размера окна (растяшивание) - НЕТ
    setVisible(true); // установка видимости - ДА
  }

  public static void main(String[] args) {
    new GameSnake().game(); // создаём объект класса GameSnake с методом game
  }

  private void game() {
    snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, KEY_RIGHT); // KEY_RIGHT - начальное направление движения
    food = new Food(snake);
    snake.setFood(food);

    poison = new Poison(snake);
    poison.setFood(food);
    food.setPoison(poison);
    snake.setPoison(poison);

    while (!gameOver) { // цикл пока NOT gameOver
      snake.move(); // вызываем метод движения

      if (snake.size() > snakeSize) {
        snakeSize = snake.size();
        setTitle(TITLE_OF_PROGRAM + ":" + snakeSize); // добавляем к заголовку размер
      }

      if (food.isEaten()) { // если съели еду
        food.appear(); // появляется новая еда
        poison.add(); // появляется новый яд
        poison.add();
        poison.add();
        poison.add();

      }
      canvas.repaint();
      sleep(SNAKE_DELAY); // задержка
    }
    JOptionPane.showMessageDialog(this, GAME_OVER_MSG); // всплывающее окно "Игра закончена"
  }
// блок try-catch для обработки исключений
  private void sleep(long ms) {
    try {                              // блок для выполнения кода
      Thread.sleep(ms);
    } catch (InterruptedException e) { // код для обработки исключений
      e.printStackTrace();
    }
  }
  // class for rendering (drawing) - класс создания игрового поля
  class Canvas extends JPanel {
    @Override
    public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2D = (Graphics2D) g;
      g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      snake.paint(g2D);
      food.paint(g2D);
      poison.paint(g2D);
    }
  }
}
