package popytka_sozdaniya.training100500.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import popytka_sozdaniya.training100500.entities.CarEntity;

import java.util.List;

public interface CarRepos extends JpaRepository<CarEntity, Integer>{
    @Query("select sts from CarEntity where sts = :name")
    CarEntity findByName(@Param("name") String name);

    @Query("select c from CarEntity c")
    public List<Long> findAllRows();

    public CarEntity findCarEntityById(Long id);


}
