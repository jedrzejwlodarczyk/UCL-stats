package pl.Wlodarczyk.UCL_Stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.Wlodarczyk.UCL_Stats.model.AttackingData;

@Repository
public interface AttackingDataRepository extends JpaRepository<AttackingData, Long> {
}
