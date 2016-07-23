package cn.nyt.bean;

public class Administrator {

	private int id;
	private String adminName;
	private String pwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", adminName=" + adminName
				+ ", pwd=" + pwd + "]";
	}

}
