import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationConfirmationFrame extends JFrame implements ActionListener {

    private Container c;
    private JLabel label;
    private JButton okButton;


    public ReservationConfirmationFrame() {
        c = getContentPane();
        c.setLayout(null);

        this.setTitle("Potwierdzenie rezerwacji");
        setBounds(300, 90, 700, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);

        ImageIcon image = new ImageIcon("src/main/resources/G03-400x400.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(241, 236, 218, 169));

        label = new JLabel("Rezerwacja zostala zrealizowana!");
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setSize(300, 30);
        label.setLocation(85, 10);
        c.add(label);

        okButton = new JButton("Powrót");
        okButton.setFont(new Font("Arial", Font.PLAIN, 15));
        okButton.setSize(120, 30);
        okButton.setLocation(170, 45);
        okButton.addActionListener(this);
        c.add(okButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            frame seanceFrame = new frame();
            this.dispose();
        }
    }
}
