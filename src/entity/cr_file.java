package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cr_file")
public class cr_file {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcr_file")
    private int idcr_file;
    
    @Column(name = "defendabt_name")
    private String defendabt_name;
        
    @Column(name = "crime_name")
    private String crime_name;

    @Column(name = "investigator_id1")
    private int investigator_id1;

    @Column(name = "date_of_imprisonment")
    private String date_of_imprisonment;
            
    @Column(name = "date_of_crime_and_time")
    private String date_of_crime_and_time;
            
    @Column(name = "date_filed_on")
    private String date_filed_on;
            
    @Column(name = "case_file_id1")
    private int case_file_id1;

    @Column(name = "sentence")
    private String sentence;

    public cr_file(String defendabt_name, String crime_name, int investigator_id1, String date_of_imprisonment, String date_of_crime_and_time, String date_filed_on, int case_file_id1, String sentence) {
        this.defendabt_name = defendabt_name;
        this.crime_name = crime_name;
        this.investigator_id1 = investigator_id1;
        this.date_of_imprisonment = date_of_imprisonment;
        this.date_of_crime_and_time = date_of_crime_and_time;
        this.date_filed_on = date_filed_on;
        this.case_file_id1 = case_file_id1;
        this.sentence = sentence;
    }

    public int getIdcr_file() {
        return idcr_file;
    }

    public void setIdcr_file(int idcr_file) {
        this.idcr_file = idcr_file;
    }

    public String getDefendabt_name() {
        return defendabt_name;
    }

    public void setDefendabt_name(String defendabt_name) {
        this.defendabt_name = defendabt_name;
    }

    public String getCrime_name() {
        return crime_name;
    }

    public void setCrime_name(String crime_name) {
        this.crime_name = crime_name;
    }

    public int getInvestigator_id1() {
        return investigator_id1;
    }

    public void setInvestigator_id1(int investigator_id1) {
        this.investigator_id1 = investigator_id1;
    }

    public String getDate_of_imprisonment() {
        return date_of_imprisonment;
    }

    public void setDate_of_imprisonment(String date_of_imprisonment) {
        this.date_of_imprisonment = date_of_imprisonment;
    }

    public String getDate_of_crime_and_time() {
        return date_of_crime_and_time;
    }

    public void setDate_of_crime_and_time(String date_of_crime_and_time) {
        this.date_of_crime_and_time = date_of_crime_and_time;
    }

    public String getDate_filed_on() {
        return date_filed_on;
    }

    public void setDate_filed_on(String date_filed_on) {
        this.date_filed_on = date_filed_on;
    }

    public int getCase_file_id1() {
        return case_file_id1;
    }

    public void setCase_file_id1(int case_file_id1) {
        this.case_file_id1 = case_file_id1;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "cr_file{" + "idcr_file=" + idcr_file + ", defendabt_name=" + defendabt_name + ", crime_name=" + crime_name + ", investigator_id1=" + investigator_id1 + ", date_of_imprisonment=" + date_of_imprisonment + ", date_of_crime_and_time=" + date_of_crime_and_time + ", date_filed_on=" + date_filed_on + ", case_file_id1=" + case_file_id1 + ", sentence=" + sentence + '}';
    }

    public cr_file() {
    }

    
    
    
}
