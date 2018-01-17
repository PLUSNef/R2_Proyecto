
package utng.model;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_credit")
public class Credit implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_credit")
    private Long idCredit;
    
    @Column(name="creditnumber", length=20)
    private String creditnumber;
    
    @Column(name="type",length=20)
    private String type;
    
    @Column(name="expirationdate", length=20)
    private String expirationdate;
    
    @Column(name="name", length=20)
    private String name;

    public Credit(Long idCredit, String creditnumber, String type, String expirationdate, String name) {
        this.idCredit = idCredit;
        this.creditnumber = creditnumber;
        this.type = type;
        this.expirationdate = expirationdate;
        this.name = name;
    }
    
    public Credit(){
        this.idCredit =0L;
    }

    public Long getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(Long idCredit) {
        this.idCredit = idCredit;
    }

    public String getCreditnumber() {
        return creditnumber;
    }

    public void setCreditnumber(String creditnumber) {
        this.creditnumber = creditnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

