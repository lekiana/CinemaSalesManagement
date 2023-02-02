import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame implements ActionListener {
    private Container c;
    private JLabel dateLabel;
    private JLabel seatLabel;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JComboBox seat;
    private JButton search;
    private JButton reservation;
    private JButton reservationSeat;
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

    String[] columnNamesSeats = { "ID", "Id filmu", "Dostepnosc", "Rząd", "Numer" };

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

    frame (int seanceId) {

        String room = queries.findRoom(seanceId);
        String seats = queries.findSeats(seanceId);
        System.out.println(seats);
        String[] seatsArray = seats.split("],");  // tablica siedzeń
        String[] ids = new String[seatsArray.length];
        dat = new String[seatsArray.length][5];

        for (int i=0; i < seatsArray.length; i++) {
            String[] seatArr = seatsArray[i].split(",");  // pojedyńcze siedzenie
            dat[i] = seatArr;
            dat[i][2] = "dostępne";
            ids[i] = dat[i][0];
        }

        c = getContentPane();
        //c.setLayout(null);
        //c.setLayout(null);

        this.setTitle("Siedzenia");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.setSize(420,420);

        ImageIcon image = new ImageIcon("src/main/resources/G03-400x400.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(241, 236, 218, 169));

        JTable table = new JTable(dat, columnNamesSeats);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        c.add(scrollPane, gbc);
        reservationSeat = new JButton("Zarezerwuj wybrane miejsce");
        reservationSeat.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        c.add(reservationSeat, gbc);
        seat = new JComboBox(ids);
        gbc.gridx = 0;
        gbc.gridy = -1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(seat, gbc);

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
            String seanceId = date.getSelectedItem().toString();
            System.out.println(seanceId);
            frame roomFrame = new frame(Integer.parseInt(seanceId));
            this.dispose();
        }

        if (e.getSource() == reservationSeat) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            try {
                transaction.begin();
                String seanceId = seat.getSelectedItem().toString();
                queries.addReservation(entityManager, Integer.parseInt(seanceId));
                ReservationConfirmationFrame ConfirmationFrame = new ReservationConfirmationFrame();
                ConfirmationFrame.setLocation(650, 450);
                ConfirmationFrame.setSize(400,130);  //set size of the frame
                ConfirmationFrame.setVisible(true);  //make form visible to the user
                this.dispose();
                transaction.commit();
            } finally {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                entityManager.close();
                entityManagerFactory.close();
            }


        }

    }
}
