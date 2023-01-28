import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;

public class queries {

    public static void browseSeances(EntityManager entityManager){
        Query browseSeances = entityManager.createNativeQuery("SELECT * FROM seat WHERE seanceid=:seanceId");
        browseSeances.setParameter("seanceId", 50);
        System.out.println(Arrays.deepToString(browseSeances.getResultList().toArray()));
    }

    public static void findSeance(EntityManager entityManager){
        Query findSeance = entityManager.createNativeQuery("SELECT * FROM seance WHERE \"Date\"=TO_DATE(:day, 'yyyy/mm/dd')");
        findSeance.setParameter("day", "2023/02/01");
        System.out.println(Arrays.deepToString(findSeance.getResultList().toArray()));
    }

    public static void deleteReservation(EntityManager entityManager){
        Query deleteReservation = entityManager.createNativeQuery("DELETE FROM reservation WHERE id =:reservationId");
        deleteReservation.setParameter("reservationId", 9);
        deleteReservation.executeUpdate();
    }

    public static void addReservation(EntityManager entityManager){
        Query addReservation = entityManager.createNativeQuery("INSERT INTO reservation(clientid, seatid, \"Date\", time) VALUES (:clientId, :seatId, CURRENT_DATE, CURRENT_TIME)");
        addReservation.setParameter("clientId", 1);
        addReservation.setParameter("seatId", 221);
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
}
