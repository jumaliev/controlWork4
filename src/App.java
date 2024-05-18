import model.Cat;
import utils.ReadAndWrite;

import java.io.IOException;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.*;

public class App {
    public Scanner sc = new Scanner(System.in);
    public List<Cat> cats = new ArrayList<>();

    public void appRunner(){

        cats.add(new Cat("Murka"));
        cats.add(new Cat("UmpaLumpa"));
        cats.add(new Cat("Victus"));
        cats.add(new Cat("fewfer"));
        printCats();
        while (true) {
            ReadAndWrite.writeFile(cats);
            interaction();
            System.out.println(ReadAndWrite.readFile());
            ReadAndWrite.writeFile(cats);
        }



    }

    public void interaction() {
        while (true) {
            System.out.print("""
                    \nДоступные действия:
                    1) Накормить кота
                    2) Поиграть с котом
                    3) Полечить кота
                    4) Добавить нового питоца
                    5) Следующий день
                    6) Чтобы отсортировать и вывезти на экран
                    Поле для ввода:""");
            String userAction = sc.nextLine();
            if (userAction.matches("[1-6]")) {
                int userActionInt = Integer.parseInt(userAction);
                switch (userActionInt) {
                    case 1:
                        Cat.feedCat(choiseCat());
                        printCats();
                        break;
                    case 2:
                        Cat.playCat(choiseCat());
                        printCats();
                        break;
                    case 3:
                        Cat.treatCat(choiseCat());
                        printCats();
                        break;
                    case 4:
                        addNewCat();
                        printCats();
                        break;
                    case 5:
                        nextDay();
                        printCats();
                        break;
                    case 6:
                        sorting();
                        break;
                }
                break;
            } else {
                System.out.println("Введено неправильное действие, попробуйте еще раз!!!");
            }
        }

    }


    public void addNewCat() {
        String name;
        String age;
        while (true) {
            System.out.print("Введите имя нового кота: ");
            name = sc.nextLine();
            if (name.matches("[a-zA-ZА-Яа-я]+")) {
                break;
            } else {
                System.out.println("Некорректная имя, введите еще раз!");
            }
        }
        while (true) {
            System.out.print("Введите возраст нового кота (от 1 до 18): ");
            age = sc.nextLine();
            if (age.matches("[1-9]+") && Integer.parseInt(age) <= 18 && Integer.parseInt(age) > 0) {
                break;
            } else {
                System.out.println("Введен неправильный возраст введите еще раз!!!");
            }
        }
        cats.add(new Cat(name, Integer.parseInt(age)));
    }

    public void printCats() {
        String headerStr = ("""
                \n---+-------------+---------+----------+------------+---------+-----------------+
                 # |     Имя     | Возраст | Здоровье | Настроение | Сытость | Средний уровень |
                ---+-------------+---------+----------+------------+---------+-----------------+""");
        System.out.println(headerStr);
        for (int i = 0; i < cats.size(); i++) {
            System.out.printf(" %-2d|  %-11s|   %-6d|    %-6.0f|    %-8.0f|   %-6.0f|       %-10.0f|\n", i + 1,
                    cats.get(i).getName(), cats.get(i).getAge(), cats.get(i).getHealthLevel(), cats.get(i).getMoodLevel(),
                    cats.get(i).getSatietyLevel(), cats.get(i).getAverageLevel());
            if (i == cats.size() - 1) {
                System.out.println("---+-------------+---------+----------+------------+---------+-----------------+");
            }
        }
    }

    public Cat choiseCat() {
        while (true) {
            System.out.print("Введите порядковый номер кота: ");
            String userChoise = sc.nextLine();
            if (userChoise.matches("[1-9]+") && Integer.parseInt(userChoise) <= cats.size()) {
                return cats.get(Integer.parseInt(userChoise) - 1);
            } else {
                System.out.println("Введен неправильный номер кота, попробуйте еще раз!");
            }
        }
    }

    public void nextDay() {
        for (Cat cat : cats) {
            cat.nextDay(cat);
        }
        System.out.println("Наступил следущий день!");
    }

    public void sorting() {
        while (true) {
            System.out.print("""
                Как отсортировать котов? \s
                1) По имени
                2) По возрасту
                3) По здоровью
                4) По настроению
                5) По сытости
                6) По среднему уровню
                """);
            String userChoiseStr = sc.nextLine();
            if (userChoiseStr.matches("[1-6]")) {
                int userChoise = Integer.parseInt(userChoiseStr);
                switch (userChoise) {
                    case 1:
                        cats.stream().sorted(Comparator.comparing(Cat::getName));
                        printCats();
                        break;
                    case 2:
                        cats.stream().sorted(Comparator.comparing(Cat::getAge));
                        printCats();
                        break;
                    case 3:
                        cats.stream().sorted(Comparator.comparing(Cat::getHealthLevel));
                        printCats();
                        break;
                    case 4:
                        cats.stream().sorted(Comparator.comparing(Cat::getMoodLevel));
                        printCats();
                        break;
                    case 5:
                        cats.stream().sorted(Comparator.comparing(Cat::getSatietyLevel));
                        printCats();
                        break;
                    case 6:
                        cats.stream().sorted(Comparator.comparing(Cat::getAverageLevel));
                        printCats();
                        break;
                }
                return;
            } else {
                System.out.println("Введено направильное действие, попробуйуте еще раз!");
            }
        }

    }
}

