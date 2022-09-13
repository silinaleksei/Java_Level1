package lesson5;

public class Employee {
  //  1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
  private String surname;
  private String name;
  private String patronymic;
  private String position;
  private String email;
  private String phone;
  private int salary;
  private int age;
  // 2. Конструктор класса должен заполнять эти поля при создании объекта.
  public Employee(
      String surname,
      String name,
      String patronymic,
      String position,
      String email,
      String phone,
      int salary,
      int age) {
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
    this.position = position;
    this.email = email;
    this.phone = phone;
    this.salary = salary;
    this.age = age;
  }
  // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
  public void info() {
    System.out.println(
        "Surname: "
            + surname
            + ", Name: "
            + name
            + ", patronymic: "
            + patronymic
            + ", Position: "
            + position
            + ", email: "
            + email
            + ", phone: "
            + phone
            + ", salary: "
            + salary
            + ", age: "
            + age);
  }

  public int getAge() {
    return age;
  }

  public static void main(String[] args) {
    // 4.	Создать массив из 5 сотрудников.
    Employee[] emplArray = new Employee[5];

    emplArray[0] =
        new Employee(
            "Ivanov", "Ivan", "Ivanovich", "Engineer", "ivanov@mail.com", "892312312", 50000, 39);
    emplArray[1] =
        new Employee(
            "Petrov", "Petr", "Petrovich", "Developer", "petrov@mail.com", "892312311", 100000, 40);
    emplArray[2] =
        new Employee(
            "Sidorov", "Ivan", "Petrovich", "Devops", "sidorov@mail.com", "892312342", 80000, 41);
    emplArray[3] =
        new Employee(
            "Sokolova",
            "Svetlana",
            "Petrovna",
            "Accountant",
            "sokolova@mail.com",
            "892312333",
            70000,
            55);
    emplArray[4] =
        new Employee(
            "Nikolaev",
            "Aleksei",
            "Alekseevich",
            "Chief",
            "nikolaev@mail.com",
            "892377333",
            120000,
            52);
    // 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
    // foreach loop
    for (Employee emp : emplArray) {
      if (emp.getAge() > 40) {
        emp.info();
      }
    }
    // for loop
    // for (int i = 0; i < emplArray.length; i++) {
    //   if (emplArray[i].getAge() > 40) {
    //     emplArray[i].info();
    //   }
    // }
  }
}
