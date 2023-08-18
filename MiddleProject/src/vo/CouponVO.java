package vo;

public class CouponVO {

    private String cp_no;
    private String cp_name;
    private String cp_sdate;
    private String cp_edate;
    private String cp_con;
    private String cp_code;
    private String mg_no;
    private boolean cpUsed; // 추가: 쿠폰 사용 여부

    public String getCp_no() {
        return cp_no;
    }

    public void setCp_no(String cp_no) {
        this.cp_no = cp_no;
    }

    public String getCp_name() {
        return cp_name;
    }

    public void setCp_name(String cp_name) {
        this.cp_name = cp_name;
    }

    public String getCp_sdate() {
        return cp_sdate;
    }

    public void setCp_sdate(String cp_sdate) {
        this.cp_sdate = cp_sdate;
    }

    public String getCp_edate() {
        return cp_edate;
    }

    public void setCp_edate(String cp_edate) {
        this.cp_edate = cp_edate;
    }

    public String getCp_con() {
        return cp_con;
    }

    public void setCp_con(String cp_con) {
        this.cp_con = cp_con;
    }

    public String getCp_code() {
        return cp_code;
    }

    public void setCp_code(String cp_code) {
        this.cp_code = cp_code;
    }

    public String getMg_no() {
        return mg_no;
    }

    public void setMg_no(String mg_no) {
        this.mg_no = mg_no;
    }

    public boolean isCpUsed() {
        return cpUsed;
    }

    public void setCpUsed(boolean cpUsed) {
        this.cpUsed = cpUsed;
    }

    @Override
    public String toString() {
        return "CouponVO [cp_no=" + cp_no + ", cp_name=" + cp_name + ", cp_sdate=" + cp_sdate + ", cp_edate=" + cp_edate
                + ", cp_con=" + cp_con + ", cp_code=" + cp_code + ", mg_no=" + mg_no + ", cpUsed=" + cpUsed + "]";
    }
}
