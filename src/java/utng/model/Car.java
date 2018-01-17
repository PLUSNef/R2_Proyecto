
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
@Table(name="tbl_car")
public class Car implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_car")
    private Long idCar;
    
    @Column(name="color", length=40)
    private String color;
    
    @Column(name="mark",length=20)
    private String mark;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_person")
    
    private Person person;

    public Car(Long idCar, String color, String mark, Person person) {
        this.idCar = idCar;
        this.color = color;
        this.mark = mark;
        this.person = person;
    }

    public Car() {
        this.idCar=0L;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
    
}
