package lesson8;

import javax.swing.*; // ���������� (�����) Swing ��� ������ � ����������� �����������, �������� ����� JFrame (����)
import java.awt.*; // ����� ��� ������ � ����������� ����������� - ��� �������� �������� ����, �������� ����� COLOR
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameSnake extends JFrame { // ����������� �� ������ JFrame, ����� ���� ����������� � ��������� ����
  final String TITLE_OF_PROGRAM = "Classic Game Snake"; // ��������� ����
  final String GAME_OVER_MSG = "GAME OVER"; // ��������� "���� ���������"
  static final int CELL_SIZE = 20; // size of cell in pix
  static final int CANVAS_WIDTH = 30; // width in cells - ������ �������� ����
  static final int CANVAS_HEIGHT = 25; // height in cells - ������ �������� ����
  static final Color SNAKE_COLOR = Color.green; // ���� ������
  static final Color FOOD_COLOR = Color.darkGray;// ���� ���
  static final Color POISON_COLOR = Color.red;// ���� ���
  static final int KEY_LEFT = 37; // ��� ������ "������� �����"
  static final int KEY_UP = 38; // ��� ������ "������� �����"
  static final int KEY_RIGHT = 39; // ��� ������ "������� ������"
  static final int KEY_DOWN = 40; // ��� ������ "������� ����"
  final int START_SNAKE_SIZE = 5; // initialization data - ��������� ������ ������
  final int START_SNAKE_X = CANVAS_WIDTH / 2; //   for - ��������� ���������� ������ ������ �� ��� � - �������� ������� ����
  final int START_SNAKE_Y = CANVAS_HEIGHT / 2; //   snake - ��������� ���������� ������ ������ �� ��� Y - �������� ����
  final int SNAKE_DELAY = 150; // snake delay in milliseconds
  int snakeSize = 0; // current snake size
  static boolean gameOver = false; // a sign game is over or not

  Canvas canvas; // ���������� ���������� ���� ������ Canvas
  Snake snake; // ���������� ���������� ���� ������ Snake
  Food food; // ���������� ���������� ���� ������ Food
  Poison poison; // ���������� ���������� ���� ������ Poison
// ����������� ������ GameSnake
  public GameSnake() {
    setTitle(TITLE_OF_PROGRAM); // ����� ������ JFrame ��� ��������� ���������
    setDefaultCloseOperation(EXIT_ON_CLOSE); // ����� ������ JFrame ��� �������� ����

    canvas = new Canvas(); // ������ ������ ������ Canvas - �������� ����
    canvas.setBackground(Color.gray); // ����� �������� ����� ���� �������� ����, � ��������� ������ ������ Color
    canvas.setPreferredSize( // ����� �������� ������� �������� ����, � ��������� ������ ������ Dimension �� ������ awt
        new Dimension(CELL_SIZE * CANVAS_WIDTH,
                      CELL_SIZE * CANVAS_HEIGHT));

    addKeyListener( // ��������� ������� ������
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) { // Listener ����� ����������� ��� ������� ������
            snake.setDirection(e.getKeyCode()); // ��������� ���������� �������� �� ������� ������
          }
        });
    // ���������� � ����� awt ������
    add(canvas); // ��������� � ���� ��������� ������� ����
    pack(); // ����� ��� ������������ �������� �������� ���� � ����
    setLocationRelativeTo(null); // ��������� ����� ��������� ����: null - �� ������
    setResizable(false); // ��������� ����������� ��������� ������� ���� (������������) - ���
    setVisible(true); // ��������� ��������� - ��
  }

  public static void main(String[] args) {
    new GameSnake().game(); // ������ ������ ������ GameSnake � ������� game
  }

  private void game() {
    snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, KEY_RIGHT); // KEY_RIGHT - ��������� ����������� ��������
    food = new Food(snake);
    snake.setFood(food);

    poison = new Poison(snake);
    poison.setFood(food);
    food.setPoison(poison);
    snake.setPoison(poison);

    while (!gameOver) { // ���� ���� NOT gameOver
      snake.move(); // �������� ����� ��������

      if (snake.size() > snakeSize) {
        snakeSize = snake.size();
        setTitle(TITLE_OF_PROGRAM + ":" + snakeSize); // ��������� � ��������� ������
      }

      if (food.isEaten()) { // ���� ����� ���
        food.appear(); // ���������� ����� ���
        poison.add(); // ���������� ����� ��
        poison.add();
        poison.add();
        poison.add();

      }
      canvas.repaint();
      sleep(SNAKE_DELAY); // ��������
    }
    JOptionPane.showMessageDialog(this, GAME_OVER_MSG); // ����������� ���� "���� ���������"
  }
// ���� try-catch ��� ��������� ����������
  private void sleep(long ms) {
    try {                              // ���� ��� ���������� ����
      Thread.sleep(ms);
    } catch (InterruptedException e) { // ��� ��� ��������� ����������
      e.printStackTrace();
    }
  }
  // class for rendering (drawing) - ����� �������� �������� ����
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
