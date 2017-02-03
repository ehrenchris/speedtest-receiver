package de.ehrenchris.speedtest.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.ehrenchris.speedtest.data.model.SpeedtestResult;

@Repository
public interface SpeedtestResultRepository extends JpaRepository<SpeedtestResult, Long> {

	//Collection<SpeedtestResult> findByAccountUsername(String username);
		
}
