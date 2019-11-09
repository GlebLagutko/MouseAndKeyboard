import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MyWindow2Task extends JFrame {
    JLabel textField;
    JButton runBtn;
    JButton staticButton;
    Random rnd = new Random(System.currentTimeMillis());
    JLabel label;


    public MyWindow2Task() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            setResizable(false);
            MyWindow2Task.this.setLocationRelativeTo(null);
        });
    }


    @Override
    protected JRootPane createRootPane() {
        JPanel panel = new JPanel();
        JRootPane pane = new JRootPane();
        setSize(700, 500);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                System.exit(0);
            }
        });
        textField = new JLabel("Вам нравится БГУ ?");
       /* BufferedImage image = null;
        BufferedImage mainImage = null;
        try {
            image = ImageIO.read(new File("C:/Users/Dell/Pictures/eblan.png"));
            mainImage = ImageIO.read(new File("C:/Users/Dell/Pictures/ochko.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        label = new JLabel();
        label.setSize(300, 200);
        Image dimg = image.getScaledInstance(label.getWidth(), label.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        label.setIcon(imageIcon);
        Image dimg2 = mainImage.getScaledInstance(700, 500,
                Image.SCALE_SMOOTH);
        JLabel lmainImage = new JLabel(new ImageIcon(dimg2));
        panel.add(lmainImage);
        lmainImage.setSize(700, 500);*/


        textField.setSize(200, 20);
        staticButton = createStaticButton("Да", "");
        runBtn = createRunButton("Нет");
        pane.setContentPane(panel);
        panel.setLayout(null);
        panel.add(textField);
        panel.add(staticButton);
        panel.add(runBtn);

        textField.setLocation(270, 150);
        staticButton.setLocation(270, 170);
        runBtn.setLocation(360, 170);

        return pane;
    }

    private JButton createRunButton(String name) {
        JButton btn = new JButton(name);
        btn.setSize(60, 30);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setLocation(Math.abs(rnd.nextInt() % 600) + 50, Math.abs(rnd.nextInt() % 300) + 50);
            }
        });
        return btn;
    }

    private JButton createStaticButton(String name, String message) {
        JButton btn = new JButton(name);
        btn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "...", "", JOptionPane.PLAIN_MESSAGE);
        });
        btn.setSize(50, 30);
        return btn;
    }

}


