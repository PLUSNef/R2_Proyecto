
package utng.data;
import org.hibernate.HibernateException;
import utng.model.Order;

public class OrderDAO extends DAO<Order>{
     public OrderDAO(){
        super(new Order());
    }
    public Order getOneById(Order order) 
            throws HibernateException {
        return super.getOneById(
                order.getIdOrder()); //To change body of generated methods, choose Tools | Templates.
    }
}
