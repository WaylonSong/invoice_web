package invoice.dto;

import java.util.List;

/**
 * Created by song on 2016/12/22.
 */
public class ReimbursementDTO {
    String userId;
    String companyTitle;//单位信息
    String department;//部门
    List<String> invoiceNumberList;//发票列表
    String description;//说明信息

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getInvoiceNumberList() {
        return invoiceNumberList;
    }

    public void setInvoiceNumberList(List<String> invoiceNumberList) {
        this.invoiceNumberList = invoiceNumberList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

}
