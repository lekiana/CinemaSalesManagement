package entity2;

import javax.persistence.*;

@Entity
@Table(name = "payment", schema = "public", catalog = "Kino2")
public class PaymentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "reservationid")
    private int reservationid;
    @Basic
    @Column(name = "employeeid")
    private Integer employeeid;
    @Basic
    @Column(name = "amount")
    private int amount;
    @Basic
    @Column(name = "ispaid")
    private int ispaid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationid() {
        return reservationid;
    }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIspaid() {
        return ispaid;
    }

    public void setIspaid(int ispaid) {
        this.ispaid = ispaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntity that = (PaymentEntity) o;

        if (id != that.id) return false;
        if (reservationid != that.reservationid) return false;
        if (amount != that.amount) return false;
        if (ispaid != that.ispaid) return false;
        if (employeeid != null ? !employeeid.equals(that.employeeid) : that.employeeid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + reservationid;
        result = 31 * result + (employeeid != null ? employeeid.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + ispaid;
        return result;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", reservationid=" + reservationid +
                ", employeeid=" + employeeid +
                ", amount=" + amount +
                ", ispaid=" + ispaid +
                '}';
    }
}
