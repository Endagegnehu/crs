package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "criminal_profile")
public class criminal_profile {
    
    @Id
    @Column(name = "idsuspect")
    private int idsuspect;
    
    @Column(name = "first_name")
    private String first_name;
            
    @Column(name = "middle_name")
    private String middle_name;
            
    @Column(name = "last_name")
    private String last_name;
            
    @Column(name = "age")
    private String age;
            
    @Column(name = "religion")
    private String religion;
            
    @Column(name = "occupation")
    private String occupation;
            
    @Column(name = "marital_status")
    private String marital_status;
            
    @Column(name = "addiction")
    private String addiction;
    
    @Column(name = "academic_level")
    private String academic_level;
    
 
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "users_idusers")
    private address address_new_criminal; 
    
    
    public address getAddress_new_criminal() {
		return address_new_criminal;
	}


	public void setAddress_new_criminal(address address_new_criminal) {
		this.address_new_criminal = address_new_criminal;
	}

	public criminal_profile() {
		
	}

	public criminal_profile(String first_name, String middle_name, String last_name, String age, String religion, String occupation, String marital_status, String addiction, String academic_level) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.age = age;
        this.religion = religion;
        this.occupation = occupation;
        this.marital_status = marital_status;
        this.addiction = addiction;
        this.academic_level = academic_level;
    }
    
    
    public int getIdsuspect() {
        return idsuspect;
    }

    public void setIdsuspect(int idsuspect) {
        this.idsuspect = idsuspect;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getAddiction() {
        return addiction;
    }

    public void setAddiction(String addiction) {
        this.addiction = addiction;
    }

    public String getAcademic_level() {
        return academic_level;
    }

    public void setAcademic_level(String academic_level) {
        this.academic_level = academic_level;
    }


	@Override
	public String toString() {
		return "criminal_profile [idsuspect=" + idsuspect + ", first_name=" + first_name + ", middle_name="
				+ middle_name + ", last_name=" + last_name + ", age=" + age + ", religion=" + religion + ", occupation="
				+ occupation + ", marital_status=" + marital_status + ", addiction=" + addiction + ", academic_level="
				+ academic_level + ", address_new_criminal=" + address_new_criminal + "]";
	}

  

	
    
}
