/**
 * 
 */
package de.ehrenchris.speedtest.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author christian.boehme
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccessKeyNotFoundException extends RuntimeException {

	
	public AccessKeyNotFoundException(String accessKey){
		super("Could not find access key: " + accessKey + ".");
	}
}
