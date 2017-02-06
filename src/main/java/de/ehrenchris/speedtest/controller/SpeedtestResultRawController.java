package de.ehrenchris.speedtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.ehrenchris.speedtest.data.SpeedtestResultRawRepository;
import de.ehrenchris.speedtest.data.model.SpeedtestResultRaw;

@RestController
@RequestMapping("/speedtestraw")
public class SpeedtestResultRawController {
	private final SpeedtestResultRawRepository speedtestResultRawRepository;

	@Autowired
	SpeedtestResultRawController(SpeedtestResultRawRepository speedtestResultRawRepository) {
		this.speedtestResultRawRepository = speedtestResultRawRepository;
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody String input) {
		

		SpeedtestResultRaw raw = new SpeedtestResultRaw();
		raw.setData(input);

		SpeedtestResultRaw res = speedtestResultRawRepository.save(raw);

		return new ResponseEntity<SpeedtestResultRaw>(res, HttpStatus.OK);

	}
}
