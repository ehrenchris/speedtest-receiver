package de.ehrenchris.speedtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ehrenchris.speedtest.data.SpeedtestResultRepository;


@RestController
@RequestMapping("/speedtest")
public class SpeedtestResultController {
	
	private final SpeedtestResultRepository speedtestResultRepository;
	
	@Autowired
	SpeedtestResultController(SpeedtestResultRepository speedtestResultRepository) {
		this.speedtestResultRepository = speedtestResultRepository;
	}

}

