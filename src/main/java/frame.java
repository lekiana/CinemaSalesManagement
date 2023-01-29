import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {
    private Container c;
    private JLabel dateLabel;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JButton search;
    private JButton reservation;
    JTable j;
    String[][] dat = {};
    JScrollPane sp;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12"};
    private String years[]
            = { "2022", "2023"};

    // Column Names
    String[] columnNames = { "ID", "Tytuł", "Nr sali", "Godzina", "Cena", "Data" };

    frame () {

        c = getContentPane();
        c.setLayout(null);

        this.setTitle("Kino");
        setBounds(300, 90, 600, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.setSize(420,420);

        ImageIcon image = new ImageIcon("src/main/resources/G03-400x400.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(241, 236, 218, 169));

        dateLabel = new JLabel("Wybierz datę seansu: ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        dateLabel.setSize(200, 30);
        dateLabel.setLocation(10, 10);
        c.add(dateLabel);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(170, 15);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(235, 15);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(310, 15);
        c.add(year);

        search = new JButton("Szukaj");
        search.setFont(new Font("Arial", Font.PLAIN, 15));
        search.setSize(100, 20);
        search.setLocation(420, 15);
        search.addActionListener(this);
        c.add(search);

        this.setVisible(true);
    }

    frame (String data) {

        String[] seancesArray = data.split("],");  // tablica seansów
        String[] ids = new String[seancesArray.length];
        dat = new String[seancesArray.length][6];

        for (int i=0; i < seancesArray.length; i++) {
            String[] seanceArr = seancesArray[i].split(",");  // pojedyńczy seans
            dat[i] = seanceArr;
            int movieId = Integer.parseInt(seanceArr[1]);
            String title = queries.findMovies(movieId);
            dat[i][1] = title;
            ids[i] = dat[i][0];
        }

        c = getContentPane();
        //c.setLayout(null);

        this.setTitle("Kino");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.setSize(420,420);

        ImageIcon image = new ImageIcon("src/main/resources/G03-400x400.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(241, 236, 218, 169));

        dateLabel = new JLabel("Wybierz seans (id): ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        dateLabel.setSize(200, 30);
        dateLabel.setLocation(10, 120);
        c.add(dateLabel);

        date = new JComboBox(ids);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(70, 20);
        date.setLocation(150, 125);
        c.add(date);

        reservation = new JButton("Zarezerwuj miejsce na wybrany seans");
        reservation.setFont(new Font("Arial", Font.PLAIN, 15));
        reservation.setSize(300, 20);
        reservation.setLocation(300, 125);
        reservation.addActionListener(this);
        c.add(reservation);

        j = new JTable(dat, columnNames);
        j.setBounds(40, 100, 600, 300);
        //c.add(j);
        sp = new JScrollPane(j);
        c.add(sp);
//        this.add(sp);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == search) {
            String seanceDate
                    = (String)year.getSelectedItem()
                    + "/" + (String)month.getSelectedItem()
                    + "/" + (String)date.getSelectedItem();
            String seance = queries.findSeances(seanceDate);
            frame seanceFrame = new frame(seance);
            this.dispose();
            }

        if (e.getSource() == reservation) {

        }
    }
}



