import model.Cat;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<Cat> cats = new ArrayList<>();
    public void appRunner() {

        cats.add(new Cat("Murka"));
        cats.add(new Cat("UmpaLumpa"));
        cats.add(new Cat("Victus"));
        cats.add(new Cat("fewfer"));
        printCats();
    }
    public void printCats() {
        String headerStr = ("""
                ---+-------------+---------+----------+------------+---------+-----------------+
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
}

