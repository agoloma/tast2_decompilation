// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 20.10.2016 19:31:39
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TitlesPanel.java

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class describe key parameters for create panel.
 */
public class TitlesPanel extends JPanel
    implements ActionListener
{

    /**
     * Constructor create object TitlesPanel
     */
    public TitlesPanel(int _shape)
    {
        start_angle = 0;
        is_done = true;
        shape = _shape;
        animation = new Timer(50, this);
        animation.setInitialDelay(50);
        animation.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        if(is_done)
            repaint();
    }

    /**
     * Draw shapes in window.
     */
    private void doDrawing(Graphics g)
    {
        is_done = false;
        g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension size = getSize();
        Insets insets = getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        ShapeFactory shape = new ShapeFactory(this.shape);
        g2d.setStroke(shape.stroke);
        g2d.setPaint(shape.paint);
        double angle = start_angle++;
        if(start_angle > 360)
            start_angle = 0;
        double dr = 90D / ((double)w / ((double)shape.width * 1.5D));
        for(int j = shape.height; j < h; j = (int)((double)j + (double)shape.height * 1.5D))
        {
            for(int i = shape.width; i < w; i = (int)((double)i + (double)shape.width * 1.5D))
            {
                angle = angle <= 360D ? angle + dr : 0.0D;
                AffineTransform transform = new AffineTransform();
                transform.translate(i, j);
                transform.rotate(Math.toRadians(angle));
                g2d.draw(transform.createTransformedShape(shape.shape));
            }

        }

        is_done = true;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDrawing(g);
    }

    private Graphics2D g2d;
    private Timer animation;
    private boolean is_done;
    private int start_angle;
    private int shape;
}