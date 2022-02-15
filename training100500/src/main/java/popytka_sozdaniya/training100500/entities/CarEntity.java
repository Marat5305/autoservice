package popytka_sozdaniya.training100500.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "mydb", catalog = "")
public class CarEntity {
    private int id;
    private String carModel;
    private String sts;
    private String stateNumber;
    private String damages;
    private String service;
    private String resultsOfWork;
    private ClientEntity clientByIdClient;
    private Collection<PartsEntity> partsById;
    private Collection<PaymentEntity> paymentsById;
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
    @Column(name = "Car_model")
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Basic
    @Column(name = "STS")
    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    @Basic
    @Column(name = "State_number")
    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    @Basic
    @Column(name = "Damages")
    public String getDamages() {
        return damages;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

    @Basic
    @Column(name = "Service")
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Basic
    @Column(name = "Results_of_work")
    public String getResultsOfWork() {
        return resultsOfWork;
    }
    public void setResultsOfWork(String resultsOfWork) {
        this.resultsOfWork = resultsOfWork;
    }


    public CarEntity() {
    }

    //добавляет марку, модель машины и повреждения
    public CarEntity(String carModel, String damages) {
        this.carModel = carModel;
        this.damages = damages;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return id == carEntity.id &&
                Objects.equals(carModel, carEntity.carModel) &&
                Objects.equals(sts, carEntity.sts) &&
                Objects.equals(stateNumber, carEntity.stateNumber) &&
                Objects.equals(damages, carEntity.damages) &&
                Objects.equals(service, carEntity.service) &&
                Objects.equals(resultsOfWork, carEntity.resultsOfWork);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, carModel, sts, stateNumber, damages, service, resultsOfWork);
    }

    @ManyToOne
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID")
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }

    @OneToMany(mappedBy = "carByIdCar")
    public Collection<PartsEntity> getPartsById() {
        return partsById;
    }

    public void setPartsById(Collection<PartsEntity> partsById) {
        this.partsById = partsById;
    }

    @OneToMany(mappedBy = "carByIdCar")
    public Collection<PaymentEntity> getPaymentsById() {
        return paymentsById;
    }

    public void setPaymentsById(Collection<PaymentEntity> paymentsById) {
        this.paymentsById = paymentsById;
    }

    @OneToMany(mappedBy = "carByIdCar")
    public Collection<WorkerEntity> getWorkersById() {
        return workersById;
    }

    public void setWorkersById(Collection<WorkerEntity> workersById) {
        this.workersById = workersById;
    }
}
