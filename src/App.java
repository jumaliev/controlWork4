import model.Cat;

import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    public Scanner sc = new Scanner(System.in);
    public List<Cat> cats = new ArrayList<>();
    public void appRunner() {

        cats.add(new Cat("Murka"));
        cats.add(new Cat("UmpaLumpa"));
        cats.add(new Cat("Victus"));
        cats.add(new Cat("fewfer"));
        printCats();
        while (true) {
            interaction();
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
                Поле для ввода:""");
            String userAction = sc.nextLine();
            if (userAction.matches("[1-5]")) {
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


                }
                break;
            } else {
                System.out.println("Введено неправильное действие, попробуйте еще раз!!!");
            }
        }

    }


    public void addNewCat(){
        String name;
        String age;
        while (true) {
            System.out.print("Введите имя нового кота: ");
            name = sc.nextLine();
            if (name.matches("[a-zA-ZА-Яа-я]+")){
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
            }else {
                System.out.println("Введен неправильный возраст введите еще раз!!!");
            }
        }
        cats.add(new Cat(name, Integer.parseInt(age)));
    }

    public void printCats() {
        cats.sort(Comparator.comparing(Cat::getAverageLevel).reversed());
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
    public Cat  choiseCat() {
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
}

