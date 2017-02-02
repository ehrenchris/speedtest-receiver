/**
 * 
 */
package de.ehrenchris.speedtest.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.ehrenchris.speedtest.data.model.SpeedtestResultRaw;

@Repository
public interface SpeedtestResultRawRepository extends JpaRepository<SpeedtestResultRaw, Long> {

}
