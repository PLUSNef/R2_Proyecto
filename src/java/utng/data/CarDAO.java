
package utng.data;
import org.hibernate.HibernateException;
import utng.model.Car;

public class CarDAO extends DAO<Car>{
    public CarDAO(){
        super(new Car());
    }
    public Car getOneById(Car car) 
            throws HibernateException {
        return super.getOneById(
                car.getIdCar()); //To change body of generated methods, choose Tools | Templates.
    }
}
