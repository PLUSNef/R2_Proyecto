
package utng.management;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.PersonDAO;
import utng.model.Person;

@ManagedBean(name = "personBean")
@SessionScoped
public class PersonBean implements Serializable{
    private List<Person>persons;
    private Person name;
    private Person lastname;
    private Person person;

    public PersonBean() {
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getName() {
        return name;
    }

    public void setName(Person name) {
        this.name = name;
    }

    public Person getLastname() {
        return lastname;
    }

    public void setLastname(Person lastname) {
        this.lastname = lastname;
    }
    
    
    
    public String list(){
        PersonDAO dao = new PersonDAO();
        try {
            persons=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Persons";
    }
    
    public String delete(){
         PersonDAO dao = new PersonDAO();
        try {
            dao.delete(person);
            persons=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        person= new Person();
        
        return "start";
    }
    
    public String save() {
        PersonDAO dao = new PersonDAO();
        try {
            if (person.getIdPerson() != 0) {
                dao.update(person);
            } else {
                dao.insert(person);
            }
            persons = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "save";
    }
    
    public String cancel() {
        return "Cancel";
    }

    public String edit(Person person) {
        this.person = person;
        return "Edit";
    }
}
