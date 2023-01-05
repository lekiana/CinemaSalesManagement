package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmployeeTelephoneNrEntityPK implements Serializable {
    private int employeeid;
    private int telephoneNrid;

    @Column(name = "employeeid")
    @Id
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Column(name = "telephone_nrid")
    @Id
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
}
