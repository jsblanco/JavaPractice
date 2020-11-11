package com.company;

import java.awt.*;
import java.awt.event.*;

public class MyWindow extends Frame {

        public MyWindow(String title) {
            super(title);
            setSize(500, 150);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    System.exit(0);
                }
            });
        }
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
                Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
                g.setFont(sansSerifLarge);
                g.drawString("Mi primera ventana programada",60, 60);
                g.setFont(sansSerifSmall);
                g.drawString("Bastante chapucero pero it shall do", 60, 100);
            }


}
