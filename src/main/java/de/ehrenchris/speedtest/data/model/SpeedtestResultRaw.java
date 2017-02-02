/**
 * 
 */
package de.ehrenchris.speedtest.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class SpeedtestResultRaw {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resultId;

	@NotEmpty
	@Column(length=1000)
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}