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
@Table(name="customers")
@NamedQueries({
    @NamedQuery(
            name="getAllCustomers",
            query="SELECT c FROM Customer AS c ORDER BY c.id DESC"
            ),
    @NamedQuery(
            name="getCustomersCount",
            query="SELECT COUNT(c) FROM Customer AS c"
            ),
    @NamedQuery(
            name="getThisBirth" ,
            query="SELECT c FROM Customer AS c  WHERE c.birthMonth = :thisMonth ORDER BY c.birthDay"
            )
})


public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name="name",nullable=false)
    private String name;

    @Column(name="postal_code",nullable=true)
    private String postalCode;

    @Column (name="adress",nullable=false)
    private String adress;

    @Column (name="mail",nullable=true)
    private String mail;

    @Column (name="tel",nullable=false)
    private String tel ;

    @Column (name="birth_year",nullable=false)
    private String birthYear;

    @Column (name="birth_month",nullable=false)
    private String birthMonth;

    @Column (name="birth_day",nullable=false)
    private String birthDay;

    @Column (name="family",nullable=false)
    private String family ;

    @Column (name="illness",nullable=false)
    private String illness ;

    @Column (name="purpose",nullable=false)
    private String purpose ;

    @Column (name="introduce",nullable=true)
    private String introduce ;

    @Lob
    @Column (name="content",length=255, nullable=true)
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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
