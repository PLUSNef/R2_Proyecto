
package utng.data;
import org.hibernate.HibernateException;
import utng.model.Person;

public class PersonDAO extends DAO<Person>{
    public PersonDAO(){
        super(new Person());
    }
    public Person getOneById(Person person) 
            throws HibernateException {
        return super.getOneById(
                person.getIdPerson()); //To change body of generated methods, choose Tools | Templates.
    }
}
