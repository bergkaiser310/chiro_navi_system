package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="reservations")
@NamedQueries({
    @NamedQuery(
            name="getAllReservations",
            query="SELECT r FROM Reservation AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name="getReservationsCount",
            query="SELECT COUNT(r) FROM Reservation AS r"
            ),
    @NamedQuery(
            name="getLatestReservation",
            query="SELECT rs FROM Reservation AS rs WHERE rs.customer = :customer AND rs.reserve_at BETWEEN :fromDate AND :toDate"
            ),
})
@Entity
public class Reservation {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name="customer_id",nullable=false)
    private Customer customer ;

    @Column (name="reserve_at",nullable=false)
    private Date reserve_at;

    @Column (name="created_at",nullable=false)
    private Timestamp created_at ;

    @Column (name="updated_at",nullable=false)
    private Timestamp updated_at ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getReserve_at() {
        return reserve_at;
    }

    public void setReserve_at(Date reserve_at) {
        this.reserve_at = reserve_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
