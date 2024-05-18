package utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Cat;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {

        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        private static final Path PATH = Paths.get("src/data/cats.json");
        private static final String PATH_STR = "src/data/cats.json";


    public static List<Cat> readFile(){
        try (FileReader reader = new FileReader(PATH_STR)) {
            Type taskListType = new com.google.gson.reflect.TypeToken<List<Cat>>() {
            }.getType();
            return GSON.fromJson(reader, taskListType);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
        public static void writeFile(List<Cat> cats) {
            String newJson = GSON.toJson(cats);
            byte[] bytes = newJson.getBytes();
            try {
                Files.write(PATH, bytes);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }
    }
