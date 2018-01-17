
package utng.management;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.CarDAO;
import utng.model.Car;
import utng.data.PersonDAO;
import utng.model.Person;

@ManagedBean(name = "carBean")
@SessionScoped
public class CarBean implements Serializable{
    private List<Car>cars;
    private Car car;
    private Car color;
    private Car mark;
    private List<Person>persons;

    public CarBean() {
        car = new Car();
        car.setPerson(new Person());
    }
    
    
    
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Car getColor() {
        return color;
    }

    public void setColor(Car color) {
        this.color = color;
    }

    public Car getMark() {
        return mark;
    }

    public void setMark(Car mark) {
        this.mark = mark;
    }
    
    
    public String list() {
        CarDAO dao = new CarDAO();
        try {
            cars = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Cars";
    }
    public String delete() {
        CarDAO dao = new CarDAO();
        try {
            dao.delete(car);
            cars = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        car = new Car();
        car.setPerson(new Person());
        try {
            persons = new PersonDAO().getAll();
        } catch (Exception e) {
        }
        return "start";
    }
    
    public String save() {
        CarDAO dao = new CarDAO();
        try {
            if (car.getIdCar() != 0) {
                dao.update(car);
            } else {
                dao.insert(car);
            }
            cars = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "save";
    }
    
    public String cancel() {
        return "Cancel";
    }

    public String edit(Car car) {
        this.car = car;
        try {
            persons = new PersonDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
    
}
