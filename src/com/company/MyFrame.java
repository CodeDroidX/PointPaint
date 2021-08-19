package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

//Холст-фрейм
public class MyFrame extends JFrame {//Наследник ЖФрейма
    static MyPanel mp;
    MyFrame () {
        super("Point");
        mp = new MyPanel(); //Объявление панели для графики
        add(mp);//Добавление ее во фрейм
    }
}
