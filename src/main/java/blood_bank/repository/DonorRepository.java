
package blood_bank.repository;

import blood_bank.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    List<Donor> findByBloodGroupIgnoreCase(String bloodGroup);

    List<Donor> findByCityContainingIgnoreCase(String city);
}
