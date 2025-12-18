package in.rahul.dto;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer sId;
    private String sname;
    private Integer sage;
    private String saddress;

    public Student() {}

    public Integer getSid() {
        return sId;
    }

    public void setSid(Integer sId) {
        this.sId = sId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "Student [sId=" + sId + ", sname=" + sname +
               ", sage=" + sage + ", saddress=" + saddress + "]";
    }
}
