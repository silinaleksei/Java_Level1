package lesson6;
/* 1.	������� ������ ������ � ��� � ������������� �� ������ ��������.
2.	��� �������� ����� ������ � �����.
� �������� ��������� ������� ������ ���������� ����� �����������.
�����������	����������	��������	�����	������	�	�������.
(��������, dogBobik.run(150); -> '����� �������� 150 �.');
3.	� ������� ��������� ���� ����������� �� ��������:
���: ��� 200 �., ������ 500 �;
��������: ��� �� ����� �������, ������ 10 �
4.* �������� ������� ��������� �����, ����� � ��������.*/
public class Animal {
  String name;
  static int count;

  public Animal(String name) {
    this.name = name;
    count++;
  }

  public void run(int distance) {
    System.out.println(name + " ran " + distance + " m");
  }

  public void swim(int distance) {
    System.out.println(name + " swam " + distance + " m");
  }

  public static void main(String[] args) {
    Dog dog = new Dog("Sharik");
    dog.run(500); // Sharik ran 500 m
    dog.run(1000); // Sharik couldn't run 1000 m
    dog.swim(9); // Sharik swam 9 m
    dog.swim(20); // Sharik couldn't swam 20 m
    Cat cat = new Cat("Murzik");
    cat.run(100); // Murzik ran 100 m
    cat.swim(10); // Murzik couldn't swim 10 m. He can't swim!
    Animal animal = new Animal("Animal");
    animal.run(15); // Animal ran 15 m
    animal.swim(5); // Animal swam 5 m
    System.out.println(count); // 3 - created three objects
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  @Override
  public void run(int distance) {
    if (distance <= 500) {
      super.run(distance);
    } else {
      System.out.println(name + " couldn't run " + distance + " m");
    }
  }

  @Override
  public void swim(int distance) {
    if (distance <= 10) {
      super.swim(distance);
    } else {
      System.out.println(name + " couldn't swam " + distance + " m");
    }
  }
}

class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }

  @Override
  public void run(int distance) {
    if (distance <= 200) {
      super.run(distance);
    } else {
      System.out.println(name + " couldn't run " + distance + " m");
    }
  }

  @Override
  public void swim(int distance) {
    System.out.println(name + " couldn't swim " + distance + " m." + " He can't swim!");
  }
}
