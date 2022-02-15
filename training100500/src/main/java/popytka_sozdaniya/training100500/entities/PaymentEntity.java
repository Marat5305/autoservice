package popytka_sozdaniya.training100500.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "mydb", catalog = "")
public class PaymentEntity {
    private int id;
    private Date dateOfAmount;
    private String amount;
    private CarEntity carByIdCar;
    private Collection<WorkerEntity> workersById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Date_of_amount")
    public Date getDateOfAmount() {
        return dateOfAmount;
    }

    public void setDateOfAmount(Date dateOfAmount) {
        this.dateOfAmount = dateOfAmount;
    }

    @Basic
    @Column(name = "Amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id == that.id &&
                Objects.equals(dateOfAmount, that.dateOfAmount) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfAmount, amount);
    }

    @ManyToOne
    @JoinColumn(name = "ID_Car", referencedColumnName = "ID")
    public CarEntity getCarByIdCar() {
        return carByIdCar;
    }

    public void setCarByIdCar(CarEntity carByIdCar) {
        this.carByIdCar = carByIdCar;
    }

    @OneToMany(mappedBy = "paymentByIdPayment")
    public Collection<WorkerEntity> getWorkersById() {
        return workersById;
    }

    public void setWorkersById(Collection<WorkerEntity> workersById) {
        this.workersById = workersById;
    }
}
