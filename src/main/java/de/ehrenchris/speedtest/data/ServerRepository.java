/**
 * 
 */
package de.ehrenchris.speedtest.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.ehrenchris.speedtest.data.model.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long> {

	Optional<Server> findById(long id);
		
}