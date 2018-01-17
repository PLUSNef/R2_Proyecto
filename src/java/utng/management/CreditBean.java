
package utng.management;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.CreditDAO;
import utng.model.Credit;

@ManagedBean(name = "creditBean")
@SessionScoped
public class CreditBean implements Serializable{
    private List<Credit>credits;
    private Credit creditnumber;
    private Credit type;
    private Credit expirationdate;
    private Credit name;
    private Credit credit;

    public CreditBean() {
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public Credit getCreditnumber() {
        return creditnumber;
    }

    public void setCreditnumber(Credit creditnumber) {
        this.creditnumber = creditnumber;
    }

    public Credit getType() {
        return type;
    }

    public void setType(Credit type) {
        this.type = type;
    }

    public Credit getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Credit expirationdate) {
        this.expirationdate = expirationdate;
    }

    public Credit getName() {
        return name;
    }

    public void setName(Credit name) {
        this.name = name;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }
    
    
    public String list(){
        CreditDAO dao = new CreditDAO();
        try{
            credits=dao.getAll();
        } catch(Exception e){
            e.printStackTrace();
        }
        return "Credits";
    }
    public String delete(){
         CreditDAO dao = new CreditDAO();
        try {
            dao.delete(credit);
            credits=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        credit= new Credit();
        
        return "start";
    }
    public String save() {
        CreditDAO dao = new CreditDAO();
        try {
            if (credit.getIdCredit() != 0) {
                dao.update(credit);
            } else {
                dao.insert(credit);
            }
            credits = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "save";
    }
    
    public String cancel() {
        return "Cancel";
    }

    public String edit(Credit person) {
        this.credit = person;
        return "Edit";
    }
}
