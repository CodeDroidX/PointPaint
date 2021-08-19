package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import static com.company.MyPanel.*;

public class ToolPanel extends JPanel {
    protected static JTextField col = new JTextField(10);
    protected static JTextField tolshina = new JTextField(2);
    protected static JTextField delstr = new JTextField(2);
    protected static JTextField path = new JTextField(20);
    protected static JLabel errorstate = new JLabel("OK");
    protected static JTextField fname = new JTextField(4);
    protected static JTextField ImageName = new JTextField(25);
    protected static JTextField fp = new JTextField(2);
    JButton op = new JButton("ExploreVector");
    JButton oprast = new JButton("ExploreRaster");
    JButton saveaspng = new JButton("SaveRaster");
    JButton loadaspng = new JButton("LoadRaster");
    JButton button = new JButton("Clear");
    JButton button2 = new JButton("Back");
    JButton buttonsave = new JButton("SaveVector");
    JButton buttonload = new JButton("LoadVector");
    JLabel toollabel = new JLabel("VectorTools:");
    JLabel imlabel = new JLabel("RasterTools:");
    JLabel ctoollabel = new JLabel("Color (red) / (rgb:255,0,0) :");
    JLabel ftoollabel = new JLabel(" for ");
    JLabel lstoollabel = new JLabel("LineSize: ");
    JLabel wptoollabel = new JLabel("VectorWorkPath (write \\ after path): ");
    JLabel fntoollabel = new JLabel("VectorFileName: ");
    JLabel fpl = new JLabel("Fps timeout bigger=slowler (Beta): ");
    JLabel err = new JLabel("ErrorState: ");

    ActionListener actionListener = new MyPanel.TestActionListener();
    ActionListener actionListener2 = new MyPanel.TestActionListener2();
    ActionListener actionListeners = new MyPanel.TestActionListenerSave();
    ActionListener actionListenerl = new MyPanel.TestActionListenerLoad();
    ActionListener opend = new MyPanel.opendir();
    ActionListener opr = new MyPanel.opendirrastr();


    //ActionListener loadas = new MyPanel.saveas();

    ToolPanel(){
        setLayout(null);
        JPanel pane = new JPanel();
        setBackground(Color.white);
        button.addActionListener(actionListener);
        button2.addActionListener(actionListener2);
        buttonsave.addActionListener(actionListeners);
        buttonload.addActionListener(actionListenerl);
        oprast.addActionListener(opr);
        op.addActionListener(opend);
        //ActionListener saveas = new MyPanel.saveas();
        saveaspng.addActionListener(SaveAsListener);
        loadaspng.addActionListener(loadAsListener);
        //pane.add(toollabel);
        pane.add(buttonsave);
        pane.add(buttonload);
        pane.add(saveaspng);
        pane.add(loadaspng);
        pane.add(op);
        pane.add(path);
        pane.add(fname);
        pane.add(oprast);
        pane.add(ImageName);

        pane.add(ctoollabel);
        pane.add(col);                                                                                           // Добавляем поле для ввода текста
        pane.add(lstoollabel);
        pane.add(tolshina);
        pane.add(button);
        pane.add(button2);
        pane.add(ftoollabel);
        pane.add(delstr);
        pane.add(err);
        pane.add(errorstate);
        pane.add(fpl);
        pane.add(fp);
        pane.setBounds(0,10,425,250);
        add(pane);
        tolshina.setText("12");
        delstr.setText("10");
        col.setText("black");
        path.setText("C:\\Users\\Public\\Documents\\PointPaint\\");
        fname.setText("draw1");
        ImageName.setText("C:\\Users\\Public\\Pictures\\Baobab.png");
        fp.setText("10");
    }


}
