package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static StringBuilder log = new StringBuilder();

    public static void main(String[] args) throws IOException {

        makeDir("d:/games/src");
        makeDir("d:/games/res");
        makeDir("d:/games/savegames");
        makeDir("d:/games/temp");
        makeDir("d:/games/src/main");
        makeDir("d:/games/src/test");
        makeDir("d:/games/res/drawables");
        makeDir("d:/games/res/vectors");
        makeDir("d:/games/res/icons");
        makeFile("d:/games/src/main/main.java");
        makeFile("d:/games/src/main/utils.java");
        makeFile("d:/games/temp/temp.txt");
        try (FileWriter logOut = new FileWriter("d:/games/temp/temp.txt", true)) {
            logOut.append(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            log.append(ex);
            System.out.println(log);
        }


    }

    static void makeDir(String nameDir) throws IOException {
        File file = new File(nameDir);
        if (file.mkdir()) {
            log.append("Каталог " + nameDir + " создан\n");
        } else {
            if (file.exists()) {
                log.append("Такой каталог " + nameDir + " уже существует\n");
            } else {
                log.append("Ошибка при создании каталога " + nameDir + ". Каталог не создан. Проверьте права доступа и правильность указанного пути\n");
            }
        }
    }

    static void makeFile(String s) {
        File file = new File(s);
        try {
            if (file.createNewFile()) {
                log.append("Файл " + s + " был создан\n");
            } else {
                if (file.exists()) {
                    log.append("Файл " + s + " уже есть в этой папке\n");
                } else {
                    log.append("Файл " + s + " не может быть создан. Проверьте правильно ли указан путь, а также права доступа к папке\n");
                }
            }
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }
    }
}
