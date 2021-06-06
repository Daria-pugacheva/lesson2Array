package ru.gb.pugacheva.lesson5;

import java.io.File;

public class ShowFiles {

    public static void main(String[] args) {
        File root = new File("C:\\Users\\dpuga\\Desktop\\АдскиеТаблицы\\IT обучение\\Базы Данных\\Лекции\\");
        viewDir("", root);
    }

    private static void viewDir (String prefix, File root){
        if(root.isFile()){
            System.out.println(prefix + "File: " + root.getName());
        }else {
            System.out.println(prefix + "Dir: " + root.getName());
            for (File file: root.listFiles()){
                viewDir(prefix+ " ", file);
            }
        }

    }
}
