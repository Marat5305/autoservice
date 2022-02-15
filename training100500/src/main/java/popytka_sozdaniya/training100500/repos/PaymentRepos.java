package popytka_sozdaniya.training100500.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import popytka_sozdaniya.training100500.entities.PaymentEntity;

public interface PaymentRepos extends JpaRepository<PaymentEntity, Integer> {
}
