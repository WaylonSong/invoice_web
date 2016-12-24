package invoice.dataobject;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by song on 15/11/18.
 */
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    String number;
    String code;

    @Column(columnDefinition = "TIMESTAMP")
    Date date;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = javax.persistence.CascadeType.ALL)
    List<Item> itemList;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="title", column=@Column(name="seller_title")),
            @AttributeOverride(name="taxId", column=@Column(name="seller_taxId")),
            @AttributeOverride(name="address", column=@Column(name="seller_address")),
            @AttributeOverride(name="phone", column=@Column(name="seller_phone")),
            @AttributeOverride(name="bankName", column=@Column(name="seller_bankName")),
            @AttributeOverride(name="bankAccount", column=@Column(name="seller_bankAccount"))
    })
    CompanyVO seller;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="title", column=@Column(name="buyer_title")),
            @AttributeOverride(name="taxId", column=@Column(name="buyer_taxId")),
            @AttributeOverride(name="address", column=@Column(name="buyer_address")),
            @AttributeOverride(name="phone", column=@Column(name="buyer_phone")),
            @AttributeOverride(name="bankName", column=@Column(name="buyer_bankName")),
            @AttributeOverride(name="bankAccount", column=@Column(name="buyer_bankAccount"))
    })
    CompanyVO buyer;

    @Column(name = "type", columnDefinition = "varchar(20) default 'COMMON'")
    InvoiceType type;

    String OwnerId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public CompanyVO getSeller() {
        return seller;
    }

    public void setSeller(CompanyVO seller) {
        this.seller = seller;
    }

    public CompanyVO getBuyer() {
        return buyer;
    }

    public void setBuyer(CompanyVO buyer) {
        this.buyer = buyer;
    }

    public InvoiceType getType() {
        return type;
    }

    public void setType(InvoiceType type) {
        this.type = type;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

}