
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * Main class for initialise and create frame.
 */
public class TitlesFrame extends JFrame
{

    /**
     * Constructor of class TitlesFrame.
     */
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

    /**
     * Main method for start program.
     */
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