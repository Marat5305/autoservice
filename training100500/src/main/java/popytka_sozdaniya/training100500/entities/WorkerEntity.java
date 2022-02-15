package popytka_sozdaniya.training100500.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker", schema = "mydb", catalog = "")
public class WorkerEntity {
    private int id;
    private String personalData;
    private PaymentEntity paymentByIdPayment;
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
    @Column(name = "Personal_data")
    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerEntity that = (WorkerEntity) o;
        return id == that.id &&
                Objects.equals(personalData, that.personalData);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, personalData);
    }
    @ManyToOne
    @JoinColumn(name = "ID_Payment", referencedColumnName = "ID")
    public PaymentEntity getPaymentByIdPayment() {
        return paymentByIdPayment;
    }
    public void setPaymentByIdPayment(PaymentEntity paymentByIdPayment) {
        this.paymentByIdPayment = paymentByIdPayment;
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
