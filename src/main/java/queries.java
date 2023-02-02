import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class queries {

    public static String findRoom(EntityManager entityManager, int seanceId){
        Query findRoom = entityManager.createNativeQuery("SELECT * FROM room WHERE id=:seanceId");
        findRoom.setParameter("seanceId", seanceId);
        Object[] rooms = findRoom.getResultList().toArray();
        String roomsStr = Arrays.deepToString(rooms);
        String roomSt = roomsStr.replace("[", "");
        String roomS = roomSt.replace("]]", "");
        String room = roomS.replace(" ", "");

        return room;
    }

    public static String findSeats(EntityManager entityManager, int seanceId){
        Query findSeats = entityManager.createNativeQuery("SELECT * FROM seat WHERE seanceid=:seanceId AND isAvailable=1");
        findSeats.setParameter("seanceId", seanceId);
        Object[] seats = findSeats.getResultList().toArray();
        String seatsStr = Arrays.deepToString(seats);
        String seatSt = seatsStr.replace("[", "");
        String seatS = seatSt.replace("]]", "");
        String seat = seatS.replace(" ", "");

        return seat;
    }

    public static String findSeance(EntityManager entityManager, String day){
        Query findSeance = entityManager.createNativeQuery("SELECT * FROM seance WHERE \"Date\"=TO_DATE(:day, 'yyyy/mm/dd')");
        findSeance.setParameter("day", day);
        Object[] seances = findSeance.getResultList().toArray();
        String seancesStr = Arrays.deepToString(seances);
        String seanceSt = seancesStr.replace("[", "");
        String seanceS = seanceSt.replace("]]", "");
        String seance = seanceS.replace(" ", "");

        return seance;
    }

    public static String findMovie(EntityManager entityManager, int movieId){
        Query browseSeances = entityManager.createNativeQuery("SELECT title FROM movie WHERE id=:movieId");
        browseSeances.setParameter("movieId", movieId);
        return browseSeances.getSingleResult().toString();
    }

    public static void deleteReservation(EntityManager entityManager){
        Query deleteReservation = entityManager.createNativeQuery("DELETE FROM reservation WHERE id =:reservationId");
        deleteReservation.setParameter("reservationId", 9);
        deleteReservation.executeUpdate();
    }

    public static void addReservation(EntityManager entityManager, int seatId){
        Query addReservation = entityManager.createNativeQuery("INSERT INTO reservation(clientid, seatid, \"Date\", time) VALUES (:clientId, :seatId, CURRENT_DATE, CURRENT_TIME)");
        addReservation.setParameter("clientId", 1);
        addReservation.setParameter("seatId", seatId);
        addReservation.executeUpdate();
    }

    public static void addSeance(EntityManager entityManager){
        Query addSeance = entityManager.createNativeQuery("INSERT INTO seance(movieid, roomid, \"Date\", time, price) VALUES (:movieId, :roomId, TO_DATE(:date, 'yyyy/mm/dd'), TO_TIMESTAMP(:time, 'HH24:MI:ss'), :price)");
        addSeance.setParameter("movieId", 5);
        addSeance.setParameter("roomId", 3);
        addSeance.setParameter("date", "2023/02/01");
        addSeance.setParameter("time", "13:30:00");
        addSeance.setParameter("price", 33);
        addSeance.executeUpdate();
    }

    public static void confirmReservation(EntityManager entityManager){
        Query confirmReservation = entityManager.createNativeQuery("UPDATE payment SET ispaid = 1 WHERE reservationid =:reservationId");
        confirmReservation.setParameter("reservationId", 11);
        confirmReservation.executeUpdate();
    }

    public static void generateReport(EntityManager entityManager){
        Query generateReport = entityManager.createNativeQuery("SELECT COUNT(id) FROM seat WHERE isavailable = 0 AND seanceid =:seanceId");
        generateReport.setParameter("seanceId", 8);
        System.out.println("Liczba zarezerwowanych miejsc na wybrany seans: " + generateReport.getSingleResult());
    }

    public static void changePrice(EntityManager entityManager){
        Query changePrice = entityManager.createNativeQuery("UPDATE seance SET price =:price WHERE  id =:id");
        changePrice.setParameter("price", 26);
        changePrice.setParameter("id", 2);
        changePrice.executeUpdate();
    }

    public static String findSeances(String day) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            String sean = queries.findSeance(entityManager, day);
            transaction.commit();
            return sean;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static String findMovies(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            String sean = queries.findMovie(entityManager, id);
            transaction.commit();
            return sean;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static String findRoom(int seanceId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            String sean = queries.findRoom(entityManager, seanceId);
            transaction.commit();
            return sean;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static String findSeats(int seanceId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            String sean = queries.findSeats(entityManager, seanceId);
            transaction.commit();
            return sean;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}