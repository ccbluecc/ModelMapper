package sit.int204.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Model.Customera;

import java.util.List;

public interface CustomeraRepository extends JpaRepository<Customera, Long> {
    List<Customera> findByFirstNameContains(String param);
}
