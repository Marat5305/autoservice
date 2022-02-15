package popytka_sozdaniya.training100500.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parts", schema = "mydb", catalog = "")
public class PartsEntity {
    private int id;
    private String receivedParts;
    private String usedParts;
    private CarEntity carByIdCar;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Received_parts")
    public String getReceivedParts() {
        return receivedParts;
    }

    public void setReceivedParts(String receivedParts) {
        this.receivedParts = receivedParts;
    }

    @Basic
    @Column(name = "Used_parts")
    public String getUsedParts() {
        return usedParts;
    }
    public void setUsedParts(String usedParts) {
        this.usedParts = usedParts;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartsEntity that = (PartsEntity) o;
        return id == that.id &&
                Objects.equals(receivedParts, that.receivedParts) &&
                Objects.equals(usedParts, that.usedParts);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, receivedParts, usedParts);
    }
    @ManyToOne
    @JoinColumn(name = "ID_Car", referencedColumnName = "ID")
    public CarEntity getCarByIdCar() {
        return carByIdCar;
    }
    public void setCarByIdCar(CarEntity carByIdCar) {
        this.carByIdCar = carByIdCar;
    }
}
