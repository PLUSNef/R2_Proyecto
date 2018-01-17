
package utng.data;
import org.hibernate.HibernateException;
import utng.model.Credit;

public class CreditDAO extends DAO<Credit>{
    public CreditDAO(){
        super(new Credit());
    }
    public Credit getOneById(Credit credit) 
            throws HibernateException {
        return super.getOneById(
                credit.getIdCredit()); //To change body of generated methods, choose Tools | Templates.
    }
}
