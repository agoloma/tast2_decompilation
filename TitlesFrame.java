// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 20.10.2016 19:31:39
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TitlesFrame.java

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TitlesFrame extends JFrame
{

    public TitlesFrame()
    {
        initUI();
    }

    private void initUI()
    {
        setTitle("\u041A\u0440\u0438\u0432\u044B\u0435 \u0444\u0438\u0433\u0443\u0440\u044B");
        setDefaultCloseOperation(3);
        add(new TitlesPanel(31));
        setSize(350, 350);
        setLocationRelativeTo(null);
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {

            public void run()
            {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);
            }

        }
);
    }
}