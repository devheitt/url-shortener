package dev.heitt.AcortadorDeUrl.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="url")
public class Url {
	@Id
	@Column(name="short")
	private String key;
	@Column(name="long")
	private String value;
	
	public Url() {
		
	}
	
	public Url(String value, String key) {
		this.value = value;
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "Url [key=" + key + ", value=" + value + "]";
	}
	
}
