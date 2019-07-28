package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idaddres")
    private int idaddres;
    
    @Column(name = "home_number")
    private String home_number;
    
    @Column(name = "phon")
    private String phon;
    
    @Column(name = "region")
    private String region;
    
    @Column(name = "woreda")
    private String woreda;
    
    @Column(name = "kebele")
    private String kebele;
    
    @OneToOne(mappedBy="address_new", cascade = CascadeType.ALL, targetEntity = users.class)
    private users new_users;
    
    @OneToOne(mappedBy="address_new_criminal", cascade = CascadeType.ALL)
    private criminal_profile new_criminal;
    
    public criminal_profile getNew_criminal() {
		return new_criminal;
	}



	public void setNew_criminal(criminal_profile new_criminal) {
		this.new_criminal = new_criminal;
	}



	public users getNew_users() {
		return new_users;
	}



	public void setNew_users(users new_users) {
		this.new_users = new_users;
	}



	public address()
    {
        
    }



	public address(String home_number, String phon, String region, String woreda, String kebele) {
		this.home_number = home_number;
		this.phon = phon;
		this.region = region;
		this.woreda = woreda;
		this.kebele = kebele;
		
	}



	public int getIdaddres() {
		return idaddres;
	}

	public void setIdaddres(int idaddres) {
		this.idaddres = idaddres;
	}

	public String getHome_number() {
		return home_number;
	}

	public void setHome_number(String home_number) {
		this.home_number = home_number;
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
