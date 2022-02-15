package popytka_sozdaniya.training100500.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import popytka_sozdaniya.training100500.entities.PartsEntity;

public interface PartsRepos extends JpaRepository<PartsEntity, Integer> {
}
