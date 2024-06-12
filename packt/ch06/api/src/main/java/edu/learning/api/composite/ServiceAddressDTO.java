package edu.learning.api.composite;

public class ServiceAddressDTO {

    private final String cmp;
    private final String pro;
    private final String rev;
    private final String rec;

    public ServiceAddressDTO() {
        cmp="";
        pro ="";
        rev="";
        rec="";
    }

    public ServiceAddressDTO(String cmp, String pro, String rev, String rec) {
        this.cmp = cmp;
        this.pro = pro;
        this.rev = rev;
        this.rec = rec;
    }

    public String getCmp() {
        return cmp;
    }

    public String getPro() {
        return pro;
    }

    public String getRev() {
        return rev;
    }

    public String getRec() {
        return rec;
    }
}
