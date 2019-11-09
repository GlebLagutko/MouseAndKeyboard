import javax.swing.*;
import java.awt.event.*;

public class MyWindow1Task extends JFrame {
    JButton button;
    JLabel showStatus;

    public MyWindow1Task() {

        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            setResizable(false);
            MyWindow1Task.this.setLocationRelativeTo(null);
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentHidden(ComponentEvent e) {
                    System.exit(0);
                }
            });
        });
    }

    @Override
    protected JRootPane createRootPane() {
        JPanel panel = new JPanel();
        JRootPane pane = new JRootPane();
        setSize(700, 500);

        showStatus = new JLabel();
        showStatus.setSize(100, 20);
        pane.setContentPane(panel);
        panel.setLayout(null);
        button = createButton();
        panel.add(button);
        panel.add(showStatus);

        showStatus.setLocation(0,440);
        button.setLocation(300, 200);


        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                showStatus.setText("X: " + e.getX() + " Y:" + e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.isControlDown()) {
                    button.setLocation(e.getX() - 50, e.getY() - 50);
                    showStatus.setText("x: " + e.getX() + ", y: " + e.getY());
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setLocation(e.getX() - 50, e.getY() - 50);
            }
        });

        return pane;
    }

    private JButton createButton() {
        JButton btn = new JButton("Hello");

        btn.setSize(100, 50);
        btn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (btn.getText().length() > 0)
                        btn.setText(btn.getText().substring(0, btn.getText().length() - 1));
                } else
                    btn.setText(btn.getText() + Character.toString(e.getKeyChar()));
            }
        });
        return btn;
    }

}
