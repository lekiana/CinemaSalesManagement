package entity2;

import javax.persistence.*;

@Entity
@Table(name = "employee_telephone_nr", schema = "public", catalog = "Kino2")
@IdClass(EmployeeTelephoneNrEntityPK.class)
public class EmployeeTelephoneNrEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employeeid")
    private int employeeid;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "telephone_nrid")
    private int telephoneNrid;

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public int getTelephoneNrid() {
        return telephoneNrid;
    }

    public void setTelephoneNrid(int telephoneNrid) {
        this.telephoneNrid = telephoneNrid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeTelephoneNrEntity that = (EmployeeTelephoneNrEntity) o;

        if (employeeid != that.employeeid) return false;
        if (telephoneNrid != that.telephoneNrid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeid;
        result = 31 * result + telephoneNrid;
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeTelephoneNrEntity{" +
                "employeeid=" + employeeid +
                ", telephoneNrid=" + telephoneNrid +
                '}';
    }
}
