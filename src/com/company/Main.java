package com.company;
import javax.swing.*;
import java.util.Scanner;

public class Main {
    protected static MyFrame frame = new MyFrame();
    public static int Xres;
    public static int Yres;
    public static void main(String[] args) {
        //Scanner myObj = new Scanner(System.in);
        //System.out.printf("Input frame resolution (like 1280,720):");
        //String userName = myObj.nextLine();
        //String res[] = userName.split(",");
        System.out.printf("Loading ");
        //Xres = Integer.parseInt(res[0]);
        //Yres = Integer.parseInt(res[1]);
        //Настройка фрейма-холста
        //frame = new MyFrame();//Объявление фрейма
        //frame.setSize(Xres,Yres);
        frame.setDefaultCloseOperation(3);
        frame.setSize(1280,720);
        frame.setResizable(true);
        frame.setVisible(true);
        //Завершение настройки

        System.out.printf("---");

        //Настройка фрейма с инструментарием
        JFrame tframe = new ToolFrame();//Объявление фрейма
        tframe.setBounds(770,60,440,270);
        tframe.setSize(440,270);
        tframe.setDefaultCloseOperation(3);
        tframe.setAlwaysOnTop(true);
        tframe.setResizable(false);
        tframe.setVisible(true);
        //Завершение настройки

        System.out.printf(" OK !");
    }

}
