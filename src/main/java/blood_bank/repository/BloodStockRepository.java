package blood_bank.repository;

import blood_bank.entity.BloodStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodStockRepository extends JpaRepository<BloodStock, String> {
}