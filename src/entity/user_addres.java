package entity;

public class user_addres {

	private int idusers;
	private String user_name;
	private String password;
	private String first_name;
	 private String email;
	private String last_name; 
	private String created_at;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	private String updated_at;
	private int idaddres;
	private String home_number;
	private String phon;
	private String region;
	private String woreda;
	private String kebele;
	
	public user_addres() {
		
	}
	
	
	public String getHome_number() {
		return home_number;
	}

	public void setHome_number(String home_number) {
		this.home_number = home_number;
	}

	public user_addres(int idusers, String user_name, String password, String first_name, String email,
			String last_name, String created_at, String updated_at, int idaddres, String home_number, String phon,
			String region, String woreda, String kebele) {
		super();
		this.idusers = idusers;
		this.user_name = user_name;
		this.password = password;
		this.first_name = first_name;
		this.email = email;
		this.last_name = last_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.idaddres = idaddres;
		this.home_number = home_number;
		this.phon = phon;
		this.region = region;
		this.woreda = woreda;
		this.kebele = kebele;
	}

	public int getIdusers() {
		return idusers;
	}
	public void setIdusers(int idusers) {
		this.idusers = idusers;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public int getIdaddres() {
		return idaddres;
	}
	public void setIdaddres(int idaddres) {
		this.idaddres = idaddres;
	}
	public String getPhon() {
		return phon;
	}
	public void setPhon(String phon) {
		this.phon = phon;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getWoreda() {
		return woreda;
	}
	public void setWoreda(String woreda) {
		this.woreda = woreda;
	}
	public String getKebele() {
		return kebele;
	}
	public void setKebele(String kebele) {
		this.kebele = kebele;
	}

	

}
