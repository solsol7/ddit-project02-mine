package vo;

public class CommentVO {
	private String users_no;
	private String mg_no;
	private String cm_no;
	private String cm_con;
	private String cm_date;
	private String nt_no;
	private String users_name;
	
	
	
	
	public String getUsers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_no() {
		return users_no;
	}
	public void setUsers_no(String users_no) {
		this.users_no = users_no;
	}
	public String getMg_no() {
		return mg_no;
	}
	public void setMg_no(String mg_no) {
		this.mg_no = mg_no;
	}
	public String getCm_no() {
		return cm_no;
	}
	public void setCm_no(String cm_no) {
		this.cm_no = cm_no;
	}
	public String getCm_con() {
		return cm_con;
	}
	public void setCm_con(String cm_con) {
		this.cm_con = cm_con;
	}
	public String getCm_date() {
		return cm_date;
	}
	public void setCm_date(String cm_date) {
		this.cm_date = cm_date;
	}
	public String getNt_no() {
		return nt_no;
	}
	public void setNt_no(String nt_no) {
		this.nt_no = nt_no;
	}
	
	@Override
	public String toString() {
		return "CommentVO [users_no=" + users_no + ", mg_no=" + mg_no + ", cm_no=" + cm_no + ", cm_con=" + cm_con
				+ ", cm_date=" + cm_date + ", nt_no=" + nt_no + "]";
	}
	
	
	
	
}
