package com.company;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Random;
import java.util.zip.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import static com.company.ToolPanel.*;

public class MyPanel extends JPanel { //тут будет мейн код
    boolean f = false;
    int tol = 0;
    Random rnd = new Random();
    static ArrayList<Integer> X = new ArrayList<>();
    static ArrayList<Integer> Y = new ArrayList<>();
    static saveas SaveAsListener;
    static loadas loadAsListener;

    static ArrayList<String> COLORS = new ArrayList<>();
    static ArrayList<Integer> LINE = new ArrayList<>();
    static Image IMAGE;


    MouseListener list = new MouseListener() {                                                               //Тут разные события мышки
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            f = true;                                                                                       //Флажок истина если мышка нажата
        }


        @Override
        public void mouseReleased(MouseEvent e) {
            f = false;
            LINE.remove(LINE.size()-1);
            LINE.add(0);
        }                                                                                    // 0 если отпущена

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

    };

//В общем есть массивы X Y LINE COLORS


    public void draw(int a, int b, String c){                                                                         // Функция которая будет рисовать
        COLORS.add(c);                                                                         // Она добавляет Цвета
        X.add(a);                                                                                           // Она добавляет в массивы координаты точек
        Y.add(b);
    }
    //Добавление данных в массивы

    MyPanel(){
        addMouseListener(list);                                                                                 //Добавляем слушателямышки
        // Добавляем поле для ввода текста
        setBackground(Color.white);
        tolshina.setText("12");         //нада
        SaveAsListener = new MyPanel.saveas();
        loadAsListener = new MyPanel.loadas();
    }

    // Хоба пейнткомпонет
    public int wdth;
    public int hgth;
    public void paintComponent(Graphics g) {
        wdth = getWidth();
        hgth = getHeight();
        super.paintComponent(g);         // По букве Г мы будем обращаться к графике
        Graphics2D g2 = (Graphics2D) g;
        tol = 1;
        if (tolshina.getText().equals("")){tol = 1;}
        else{ tol = Integer.parseInt(tolshina.getText());}
        g.setColor(Color.black);// Черная графика по умолчанию

        //Еще один екземпляр графона
        if(f) {
            //Если мышка нажата тогда рисуем (добавляем координаты точек в массивы)
            Point p = new Point(MouseInfo.getPointerInfo().getLocation());//Координаты мыша
            SwingUtilities.convertPointFromScreen(p, this );//Зовем свинг чтобы он подогнал их под окно
            draw(p.x-tol/2, p.y-tol/2, col.getText());// подгон для рисования из середины точки
            LINE.add(tol);
        }
        g.drawImage(IMAGE,0,0,null);
        for(int b = 0;b<X.size();b++) {

            //Отрисовка всего массива из координат точек проходя по нему циклом

            errorstate.setText("OK");
            String[] sc = COLORS.get(b).split(":");
            if(sc[0].equals("rgb")){
                String[] rgbs = sc[1].split(",");
                if(rgbs.length == 3) {
                    if(Integer.parseInt(rgbs[0])<=255 & Integer.parseInt(rgbs[0])>=0){
                        if(Integer.parseInt(rgbs[1])<=255 & Integer.parseInt(rgbs[1])>=0){
                            if(Integer.parseInt(rgbs[2])<=255 & Integer.parseInt(rgbs[2])>=0){
                                g.setColor(new Color(Integer.parseInt(rgbs[0]), Integer.parseInt(rgbs[1]), Integer.parseInt(rgbs[2])));//ждем пока юзер позовет ргб:
                            }
                            else{
                                errorstate.setText("invalid Blue RGB value!");
                            }
                        }
                        else{
                            errorstate.setText("invalid Green RGB value!");
                        }
                    }
                    else{
                        errorstate.setText("invalid Red RGB value!");
                    }
                }
                else{
                    errorstate.setText("Not RGB form!");
                }
            }
            else{
                switch (COLORS.get(b)){                                                                             // Выбор цвета для каждой отдельной точки
                    case("pink"):
                        g.setColor(Color.pink);
                        break;
                    case("black"):
                        g.setColor(Color.black);
                        break;
                    case("nigga"):
                        g.setColor(Color.black);
                        break;
                    case("yellow"):
                        g.setColor(Color.yellow);
                        break;
                    case("green"):
                        g.setColor(Color.green);
                        break;
                    case("blue"):
                        g.setColor(Color.blue);            //Еще изврат
                        break;
                    case("red"):
                        g.setColor(Color.red);
                        break;
                    case("white"):
                        g.setColor(Color.white);
                        break;
                    case("magenta"):
                        g.setColor(Color.magenta);
                        break;
                    case("orange"):
                        g.setColor(Color.orange);
                        break;
                    case("cyan"):
                        g.setColor(Color.cyan);
                        break;
                    case("gray"):
                        g.setColor(Color.gray);
                        break;
                    case("purple"):
                        g.setColor(new Color(128, 0, 128));
                        break;
                    case("indigo"):
                        g.setColor(new Color(75, 0, 130));
                        break;
                    case("rand"):
                        Color[] colorss = {Color.red, Color.green, Color.blue, Color.yellow, Color.black, Color.magenta, Color.orange, Color.cyan}; //Трип-цвет
                        g.setColor(colorss[rnd.nextInt(colorss.length)]);
                        break;
                }}

            int t = LINE.get(b);
 //           g.fillOval(X.get(b),Y.get(b),t,t);                                                        //Точки(Не имеют смысла но можно)
            if(b > 2){                                                                                 //полоски между точками
                if(LINE.get(b-1) != 0){
                    g2.setStroke(new BasicStroke(t,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));//Закругленные края полосок
                    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //Анти-алиасинг(по приколу)
                    g2.setRenderingHints(rh);
                    g2.drawLine(X.get(b-1)+t/2+1,Y.get(b-1)+t/2+1,X.get(b)+t/2+1,Y.get(b)+t/2+1);//Линии с подгоном
                    g2.setStroke(new BasicStroke(1));//после отрисовки линий ставим графон на место чтоб не ломать длугие элементы интерфейса


                }
            }

        }
        int sl = 10;
        if(fp.getText().equals("")){}
        else{
            sl = Integer.parseInt(fp.getText());
        }
        try {
            Thread.sleep(sl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();                                                                                 // Это репэйнт-_-
    }

    protected static class TestActionListenerSave implements ActionListener { //Сохраняем, заливая в зип контейнер
        public void actionPerformed(ActionEvent e) {

            try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path.getText()+ fname.getText() +".ppx"));)
            {
                ZipEntry entry1=new ZipEntry(fname.getText() +".pp");
                zout.putNextEntry(entry1);

                String s = X.toString();
                s = s.substring(1, s.length()-1) + '\n';
                zout.write(s.getBytes());
                s = Y.toString();
                s = s.substring(1, s.length()-1) + '\n';
                zout.write(s.getBytes());
                s = LINE.toString();
                s = s.substring(1, s.length()-1) + '\n';
                zout.write(s.getBytes());
                s = COLORS.toString();
                s = s.substring(1, s.length()-1) + '\n';
                zout.write(s.getBytes());
                // запись по символам
                zout.closeEntry();
                zout.flush();
                zout.close();
                System.out.print("\n -Saved file " + path.getText() + fname.getText() + ".ppx");
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }

    static class TestActionListenerLoad implements ActionListener { //Загружаем, сначала распаковав а потом читая рр файл
        public void actionPerformed(ActionEvent e) {
            X.clear();
            Y.clear();
            LINE.clear();
            COLORS.clear();
            File f = new File(path.getText() + fname.getText() +".ppx");
            if(f.exists()) {


                try (ZipInputStream zin = new ZipInputStream(new FileInputStream(path.getText() + fname.getText() +".ppx"))) {
                    ZipEntry entry;
                    String name;

                    while ((entry = zin.getNextEntry()) != null) {
                        name = entry.getName(); // получим название файла

                        // распаковка
                        FileOutputStream fout = new FileOutputStream(path.getText() + name);
                        for (int c = zin.read(); c != -1; c = zin.read()) {
                            fout.write(c);
                        }
                        fout.flush();
                        zin.closeEntry();
                        fout.close();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                try {
                    FileReader reader = new FileReader(path.getText() + fname.getText() +".pp");
                    BufferedReader br = new BufferedReader(reader);
                    String s = br.readLine();
                    String[] aX = s.split(", ");
                    s = br.readLine();
                    String[] aY = s.split(", ");
                    s = br.readLine();
                    String[] aL = s.split(", ");
                    s = br.readLine();
                    String[] aC = s.split(", ");
                    if(aX.length != 1){
                        System.out.print("\n -Loaded file " + fname.getText() + ".ppx with " + aX.length + " points");
                        for (int i = 0; i < aX.length; i++) {
                            X.add(Integer.parseInt(aX[i]));
                            Y.add(Integer.parseInt(aY[i]));
                            LINE.add(Integer.parseInt(aL[i]));
                            COLORS.add(aC[i]);
                        }
                    }
                    else{
                        errorstate.setText("File is empty(");
                    }
                    reader.close();
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                File ff = new File(path.getText() + fname.getText() +".pp");//Удалим наш распакованный рр файл
                ff.delete();
            }
            else{
                errorstate.setText("File not found(");
            }

        }
    }

    protected static class TestActionListener implements ActionListener { //Фулл очистка
        public void actionPerformed(ActionEvent e) {

            X.clear();
            Y.clear();
            LINE.clear();
            COLORS.clear();
            IMAGE = null;
        }
    }

    protected static class TestActionListener2 implements ActionListener {// Удаление данных с конца
        public void actionPerformed(ActionEvent e) {
            if(delstr.getText().equals("")) {
            }else{
                for (int i = 0; i < Integer.parseInt(delstr.getText()); i++) {
                    if (X.size() > 1) {
                        X.remove(X.size() - 1);
                        Y.remove(Y.size() - 1);
                        LINE.remove(LINE.size() - 1);
                        COLORS.remove(COLORS.size() - 1);
                    }
                }
                if (X.size() > 1) {
                    LINE.remove(LINE.size() - 1);
                    LINE.add(0);
                }
            }
        }
    }
    protected static class opendir implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String com = "explorer \""+path.getText()+"\"";// Минус кросс-платформ
            try {
                Runtime.getRuntime().exec(com);//Але вин кмд
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    protected static class opendirrastr implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] sp = ImageName.getText().split("\\\\");
            String com = "explorer \""+sp[sp.length-2]+"\"";// Минус кросс-платформ
            try {
                Runtime.getRuntime().exec(com);//Але вин кмд
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public class saveas implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BufferedImage bufferedImage = new BufferedImage(wdth,hgth, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2 = bufferedImage.createGraphics();
                //RenderedImage rendImage = bufferedImage;
                paintComponent(g2);
                String[] spln = ImageName.getText().split("\\.");
                ImageIO.write(bufferedImage, spln[spln.length-1], new File(ImageName.getText()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public class loadas implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            File file = new File(ImageName.getText());
            try {
                Image i = ImageIO.read(file);
                IMAGE = i;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
    }


//Закрываем кучу скобочек ;)