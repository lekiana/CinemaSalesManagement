package entity2;

import javax.persistence.*;

@Entity
@Table(name = "telephone_nr", schema = "public", catalog = "Kino2")
public class TelephoneNrEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nr")
    private int nr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        TelephoneNrEntity that = (TelephoneNrEntity) o;

        if (id != that.id) return false;
        if (nr != that.nr) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nr;
        return result;
    }

    @Override
    public String toString() {
        return "TelephoneNrEntity{" +
                "id=" + id +
                ", nr=" + nr +
                '}';
    }
}
