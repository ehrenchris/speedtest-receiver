/**
 * 
 */
package de.ehrenchris.speedtest.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author christian.boehme
 */
@Entity
public class SpeedtestResult{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long speedtestResultId;
	
	private double download;
	private String timestamp;
	private double ping;
	private double upload;
	
	//private Server server;
	
	public SpeedtestResult(){	
	}

	public double getDownload() {
		return download;
	}

	public void setDownload(double download) {
		this.download = download;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getPing() {
		return ping;
	}

	public void setPing(double ping) {
		this.ping = ping;
	}

	public double getUpload() {
		return upload;
	}

	public void setUpload(double upload) {
		this.upload = upload;
	}
	
	/*
	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
*/

}
