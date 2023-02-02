package entity2;

import javax.persistence.*;

@Entity
@Table(name = "seat", schema = "public", catalog = "Kino2")
public class SeatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "seanceid")
    private int seanceid;
    @Basic
    @Column(name = "isavailable")
    private int isavailable;
    @Basic
    @Column(name = "row")
    private int row;
    @Basic
    @Column(name = "nr")
    private int nr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeanceid() {
        return seanceid;
    }

    public void setSeanceid(int seanceid) {
        this.seanceid = seanceid;
    }

    public int getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(int isavailable) {
        this.isavailable = isavailable;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
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

        SeatEntity that = (SeatEntity) o;

        if (id != that.id) return false;
        if (seanceid != that.seanceid) return false;
        if (isavailable != that.isavailable) return false;
        if (row != that.row) return false;
        if (nr != that.nr) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + seanceid;
        result = 31 * result + isavailable;
        result = 31 * result + row;
        result = 31 * result + nr;
        return result;
    }

    @Override
    public String toString() {
        return "SeatEntity{" +
                "id=" + id +
                ", seanceid=" + seanceid +
                ", isavailable=" + isavailable +
                ", row=" + row +
                ", nr=" + nr +
                '}';
    }
}
