package popytka_sozdaniya.training100500.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import popytka_sozdaniya.training100500.entities.CarEntity;
import popytka_sozdaniya.training100500.entities.ClientEntity;

public interface ClientRepos extends JpaRepository<ClientEntity, Integer> {
    //public ClientEntity findClientEntityById(int id);
}
