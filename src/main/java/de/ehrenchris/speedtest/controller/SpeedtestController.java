package de.ehrenchris.speedtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.ehrenchris.speedtest.controller.auth.AccessKeyNotFoundException;
import de.ehrenchris.speedtest.data.SpeedtestResultRawRepository;
import de.ehrenchris.speedtest.data.model.SpeedtestResultRaw;


@RestController
@RequestMapping("/speedtest/{accessKey}")
public class SpeedtestController {
	/*
	@RequestMapping(value="/speedtest", method=RequestMethod.GET)
	public List<HttpEntity<SpeedtestResult>> getAllResults(){
		List<HttpEntity<SpeedtestResult>> results = new ArrayList<HttpEntity<SpeedtestResult>>();
		return results;
	}
	*/
	/*
	@RequestMapping(value="/speedtest", method=RequestMethod.GET)
	public HttpEntity<SpeedtestResult> speedtestResult(@RequestParam(value = "timestamp", required = false) String timestamp) {

		if (timestamp == null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
			timestamp = df.format(new Date());
		}
		SpeedtestResult res = new SpeedtestResult(timestamp);
		res.add(linkTo(methodOn(SpeedtestController.class).speedtestResult(timestamp)).withSelfRel());

		return new ResponseEntity<SpeedtestResult>(res, HttpStatus.OK);
	}*/
	
	/*
	@RequestMapping(value="/speedtest", method=RequestMethod.POST)
	public HttpEntity<SpeedtestResult> createSpeedtestResult(@RequestBody SpeedtestResult input) {	
		
		//speedtestResult.add(linkTo(methodOn(SpeedtestController.class).speedtestResult(speedtestResult.getTimestamp())).withSelfRel());
		return new ResponseEntity<SpeedtestResult>(speedtestResult, HttpStatus.OK);
	}
	*/
	
	//private final SpeedtestResultRepository speedtestResultRepository;
	//private final ServerRepository serverRepository;
	private final SpeedtestResultRawRepository speedtestResultRawRepository;
	
	@Autowired
	SpeedtestController(SpeedtestResultRawRepository speedtestResultRawRepository) {
		//this.speedtestResultRepository = speedtestResultRepository;
		//this.serverRepository = serverRepository;
		this.speedtestResultRawRepository = speedtestResultRawRepository;
	}

	/*
	@RequestMapping(method = RequestMethod.GET)
	Collection<Bookmark> readBookmarks(@PathVariable String userId) {
		this.validateUser(userId);
		return this.bookmarkRepository.findByAccountUsername(userId);
	}
*/
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String accessKey, @RequestBody String input) {
		
		System.out.println("Input: " + input);
		
		this.validateUser(accessKey);
		
		SpeedtestResultRaw raw = new SpeedtestResultRaw();
		raw.setData(input);
		
		SpeedtestResultRaw res = speedtestResultRawRepository.save(raw);
		
		return new ResponseEntity<SpeedtestResultRaw>(res, HttpStatus.OK);
		/*
		return this.accountRepository
				.findByUsername(userId)
				.map(account -> {
					Bookmark result = bookmarkRepository.save(new Bookmark(account,
							input.uri, input.description));

					URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(result.getId()).toUri();

					return ResponseEntity.created(location).build();
				})
				.orElse(ResponseEntity.noContent().build());
*/
	}

	private void validateUser(String accessKey) {
		if(!accessKey.equals("secret")){
			
			throw new AccessKeyNotFoundException(accessKey);
		}
	}
}

