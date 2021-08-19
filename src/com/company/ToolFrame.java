package com.company;

import javax.swing.*;

public class ToolFrame extends JFrame {
    ToolFrame (){
        super("Tools");

        JPanel tpanel = new ToolPanel();
        add(tpanel);
    }
}
