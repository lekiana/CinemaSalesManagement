package entity2;

import javax.persistence.*;

@Entity
@Table(name = "room", schema = "public", catalog = "Kino2")
public class RoomEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "seats")
    private int seats;
    @Basic
    @Column(name = "cinemaid")
    private int cinemaid;
    @Basic
    @Column(name = "nr")
    private int nr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(int cinemaid) {
        this.cinemaid = cinemaid;
    }

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

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id=" + id +
                ", seats=" + seats +
                ", cinemaid=" + cinemaid +
                ", nr=" + nr +
                '}';
    }
}
