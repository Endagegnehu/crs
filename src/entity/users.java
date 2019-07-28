package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class users {
    
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "idusers")
	 private int idusers;
    
	 @Column(name = "user_name")
    private String user_name;
            
    @Column(name = "password")
    private String password;
            
    @Column(name = "email")
    private String email;
            
    @Column(name = "first_name")
    private String first_name;
            
    @Column(name = "last_name")
    private String last_name;   
   
    @Column(name = "created_at")
    private String created_at;
    
    @Column(name = "updated_at")
    private String updated_at;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "users_idusers")
    private address address_new; 
    
    @OneToOne(mappedBy = "users_idusers", cascade = CascadeType.ALL)
    private job user_job;
    
    
    
	public job getUser_job() {
		return user_job;
	}

	public void setUser_job(job user_job) {
		this.user_job = user_job;
	}

	public users() {
        
    }

    public users(String user_name, String password, String email, String first_name, String last_name, String created_at, String updated_at) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    
    
	public address getAddress_new() {
		return address_new;
	}

	public void setAddress_new(address address_new) {
		this.address_new = address_new;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

	@Override
	public String toString() {
		return "users [idusers=" + idusers + ", user_name=" + user_name + ", password=" + password + ", email=" + email
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", address_new=" + address_new + "]";
	}   
}

