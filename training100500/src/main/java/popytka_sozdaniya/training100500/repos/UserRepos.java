package popytka_sozdaniya.training100500.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import popytka_sozdaniya.training100500.entities.UserEntity;

public interface UserRepos extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    public UserEntity findUserEntityById(long id);
}
