package sit.int204.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Model.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
