
package utng.management;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.OrderDAO;
import utng.model.Order;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderBean implements Serializable{
    private List<Order>orders;
    private Order namecompany;
    private Order phonenumber;
    private Order order;

    public OrderBean() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(Order namecompany) {
        this.namecompany = namecompany;
    }

    public Order getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Order phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    
    
    public String list(){
        OrderDAO dao = new OrderDAO();
        try {
            orders=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Orders";
    }
    
    public String delete(){
         OrderDAO dao = new OrderDAO();
        try {
            dao.delete(order);
            orders=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        order= new Order();
        
        return "start";
    }
    
   public String save() {
        OrderDAO dao = new OrderDAO();
        try {
            if (order.getIdOrder()!= 0) {
                dao.update(order);
            } else {
                dao.insert(order);
            }
            orders = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "save";
    }
    
    public String cancel() {
        return "Cancel";
    }

    public String edit(Order order) {
        this.order = order;
        return "Edit";
    }
}
