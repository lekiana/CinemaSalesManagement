package entity2;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class EmployeeTelephoneNrEntityPK implements Serializable {
    @Column(name = "employeeid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeid;
    @Column(name = "telephone_nrid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        EmployeeTelephoneNrEntityPK that = (EmployeeTelephoneNrEntityPK) o;

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
        return "EmployeeTelephoneNrEntityPK{" +
                "employeeid=" + employeeid +
                ", telephoneNrid=" + telephoneNrid +
                '}';
    }
}
