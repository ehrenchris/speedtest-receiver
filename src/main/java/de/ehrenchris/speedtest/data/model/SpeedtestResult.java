/**
 * 
 */
package de.ehrenchris.speedtest.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author christian.boehme
 */
@Entity
@Table(name = "speedtestresult")
public class SpeedtestResult{
	
	private long speedtestResultId;
	
	private double download;
	private String timestamp;
	private double ping;
	private double upload;
	
	private Server server;
	
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
	
	@ManyToOne
    @JoinColumn(name = "server_id")
	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSpeedtestResultId() {
		return speedtestResultId;
	}

	public void setSpeedtestResultId(long speedtestResultId) {
		this.speedtestResultId = speedtestResultId;
	}

}
