package invoice.dataobject;

import javax.persistence.*;
import java.util.List;

/**
 * Created by song on 2016/12/21.
 */

//报销
@Entity
@Table
public class Reimbursement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String userId;
    String companyTitle;//单位信息
    String department;//部门

    @OneToMany(fetch = FetchType.LAZY)
    List<Invoice> invoiceList;//发票列表

    String description;//说明信息

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }
}
