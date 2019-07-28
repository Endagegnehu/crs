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
@Table(name = "job")
public class job {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idjob")
    private int idjob;
    
    @Column(name = "name")
    private String name;
    
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "users_idusers")
    private users users_idusers;
    
    
    
    public users getUsers_idusers() {
		return users_idusers;
	}

	public void setUsers_idusers(users users_idusers) {
		this.users_idusers = users_idusers;
	}

	public job(String name) {
        this.name = name;
    }

    public job()
    {
        
    }
    
    public int getIdjob() {
        return idjob;
    }

    public void setIdjob(int idjob) {
        this.idjob = idjob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "job [idjob=" + idjob + ", name=" + name + ", users_idusers=" + users_idusers + "]";
	}

    
    
}
