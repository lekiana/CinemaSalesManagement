package entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "seance", schema = "public", catalog = "kino 2")
public class SeanceEntity {
    private int id;
    private int movieid;
    private int roomid;
    private Time time;
    private int price;
    private Date date;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movieid")
    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Basic
    @Column(name = "roomid")
    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    @Basic
    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Date")
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
}
