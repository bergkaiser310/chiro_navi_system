package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="products")
@NamedQueries({
    @NamedQuery(
            name="getAllProducts",
            query="SELECT p FROM Product AS p ORDER BY p.id DESC"
            ),
    @NamedQuery(
            name="getProductsCount",
            query="SELECT COUNT(p) FROM Product AS p"
            )
})


public class Product {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="name",nullable=false)
    private String name;

    @Column (name="model_code",nullable=true)
    private String modelCode;

    @Column (name="category",nullable=false)
    private String category ;

    @Column(name="stock" , nullable=true)
    private Integer stock ;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
