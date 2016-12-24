package invoice.dataobject;

import javax.persistence.*;

/**
 * Created by song on 2016/12/19.
 */
@Entity
@Table(name = "user")
public class User implements Trader{
    @Id
    String id;
    String mobile;
    String name;
    String pwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String getTraderId() {
        return this.getId();
    }
}
