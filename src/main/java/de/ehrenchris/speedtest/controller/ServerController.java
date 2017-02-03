package de.ehrenchris.speedtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ehrenchris.speedtest.data.ServerRepository;


@RestController
@RequestMapping("/server")
public class ServerController {
	
	private final ServerRepository serverRepository;
	
	@Autowired
	ServerController(ServerRepository serverRepository) {
		this.serverRepository = serverRepository;
	}
	
}

