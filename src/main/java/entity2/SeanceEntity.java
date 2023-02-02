package entity2;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "seance", schema = "public", catalog = "Kino2")
public class SeanceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "movieid")
    private int movieid;
    @Basic
    @Column(name = "roomid")
    private int roomid;
    @Basic
    @Column(name = "time")
    private Time time;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "Date")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeanceEntity that = (SeanceEntity) o;

        if (id != that.id) return false;
        if (movieid != that.movieid) return false;
        if (roomid != that.roomid) return false;
        if (price != that.price) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + movieid;
        result = 31 * result + roomid;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SeanceEntity{" +
                "id=" + id +
                ", movieid=" + movieid +
                ", roomid=" + roomid +
                ", time=" + time +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
