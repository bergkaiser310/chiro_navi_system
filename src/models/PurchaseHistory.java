package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="purchase_history")
@NamedQueries({
    @NamedQuery(
            name="getAllPurchaseHsitory",
            query="SELECT h FROM PurchaseHistory AS h ORDER BY h.sold_at DESC"
            ),
    @NamedQuery(
            name="getPurchaseHistoryCount",
            query="SELECT COUNT(h) FROM PurchaseHistory AS h"
            ),
    @NamedQuery(
            name="getMyPurchaseHistory",
            query="SELECT h FROM PurchaseHistory AS h WHERE h.customer = :customer "
            ),
    @NamedQuery(
            name="getProductsHistory",
            query="SELECT h FROM PurchaseHistory AS h WHERE h.product = :product "
            ),
})



public class PurchaseHistory {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn (name="customer_id",nullable=false)
    private Customer customer;

    @Column (name="sold_at",nullable=false)
    private Date sold_at;

    @ManyToOne
    @JoinColumn (name="product_id",nullable=false)
    private Product product;

    @Lob
    @Column (name="content", length = 255,nullable=true)
    private String content ;

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

    public Date getSold_at() {
        return sold_at;
    }

    public void setSold_at(Date sold_at) {
        this.sold_at = sold_at;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
