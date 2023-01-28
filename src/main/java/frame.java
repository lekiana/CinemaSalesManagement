import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {
    private Container c;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "2022", "2023"};

    frame () {

        c = getContentPane();
        c.setLayout(null);

        this.setTitle("Kino");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.setSize(420,420);

        ImageIcon image = new ImageIcon("src/main/resources/G03-400x400.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.white);

        dob = new JLabel("Wybierz datę seansu: ");
        dob.setFont(new Font("Arial", Font.PLAIN, 15));
        dob.setSize(200, 30);
        dob.setLocation(10, 10);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(170, 15);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(240, 15);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(310, 15);
        c.add(year);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

    }
}
