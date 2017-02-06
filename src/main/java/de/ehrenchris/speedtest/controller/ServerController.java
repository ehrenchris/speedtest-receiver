package de.ehrenchris.speedtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.ehrenchris.speedtest.data.ServerRepository;
import de.ehrenchris.speedtest.data.model.Server;


@RestController
@RequestMapping("/server")
public class ServerController {
	
	private final ServerRepository serverRepository;
	
	@Autowired
	ServerController(ServerRepository serverRepository) {
		this.serverRepository = serverRepository;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Server input) {
	
		Server res = serverRepository.save(input);

		return new ResponseEntity<Server>(res, HttpStatus.OK);

	}
	
}

