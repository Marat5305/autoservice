package popytka_sozdaniya.training100500.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "mydb", catalog = "")
public class ClientEntity {
    private int id;
    private String fio;
    private String passportNumber;
    private String residenceAdress;
    private Collection<CarEntity> carsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIO")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "Passport_number")
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "Residence_adress")
    public String getResidenceAdress() {
        return residenceAdress;
    }

    public void setResidenceAdress(String residenceAdress) {
        this.residenceAdress = residenceAdress;
    }

    public ClientEntity() {
    }

    //Добавляет ФИО в таблицу
    public ClientEntity(String fio) {
        this.fio = fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id == that.id &&
                Objects.equals(fio, that.fio) &&
                Objects.equals(passportNumber, that.passportNumber) &&
                Objects.equals(residenceAdress, that.residenceAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, passportNumber, residenceAdress);
    }

    @OneToMany(mappedBy = "clientByIdClient")
    public Collection<CarEntity> getCarsById() {
        return carsById;
    }

    public void setCarsById(Collection<CarEntity> carsById) {
        this.carsById = carsById;
    }
}
