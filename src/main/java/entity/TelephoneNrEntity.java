package entity;

import javax.persistence.*;

@Entity
@Table(name = "telephone_nr", schema = "public", catalog = "kino 2")
public class TelephoneNrEntity {
    private int id;
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
}
