package pl.Wlodarczyk.UCL_Stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.Wlodarczyk.UCL_Stats.model.Distribution;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Long> {
}
