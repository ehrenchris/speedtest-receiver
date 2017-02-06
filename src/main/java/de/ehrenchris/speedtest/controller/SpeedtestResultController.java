package de.ehrenchris.speedtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.ehrenchris.speedtest.data.SpeedtestResultRepository;
import de.ehrenchris.speedtest.data.model.SpeedtestResult;


@RestController
@RequestMapping("/speedtest")
public class SpeedtestResultController {
	
	private final SpeedtestResultRepository speedtestResultRepository;
	
	@Autowired
	SpeedtestResultController(SpeedtestResultRepository speedtestResultRepository) {
		this.speedtestResultRepository = speedtestResultRepository;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody SpeedtestResult input) {
	
		SpeedtestResult res = speedtestResultRepository.save(input);

		return new ResponseEntity<SpeedtestResult>(res, HttpStatus.OK);

	}
	

}

