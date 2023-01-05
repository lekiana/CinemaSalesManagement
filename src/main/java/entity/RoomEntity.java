package entity;

import javax.persistence.*;

@Entity
@Table(name = "room", schema = "public", catalog = "kino 2")
public class RoomEntity {
    private int id;
    private int seats;
    private int cinemaid;
    private int nr;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "seats")
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Basic
    @Column(name = "cinemaid")
    public int getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(int cinemaid) {
        this.cinemaid = cinemaid;
    }

    @Basic
    @Column(name = "nr")
    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (id != that.id) return false;
        if (seats != that.seats) return false;
        if (cinemaid != that.cinemaid) return false;
        if (nr != that.nr) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + seats;
        result = 31 * result + cinemaid;
        result = 31 * result + nr;
        return result;
    }
}
