package example.model;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@CsvRecord(skipFirstLine = true, separator = ",", quote = "\"")
public class Product {
	
	@DataField(pos = 1) @JsonProperty(required = true)
    private String id;
	@DataField(pos = 2) 
	private String brand;
	@DataField(pos = 3) 
	private String name;
	@DataField(pos = 4, precision = 2, length=7)
    private BigDecimal price;
	@DataField(pos = 5) 
	private String description;
	@DataField(pos = 6) 
	private String country;
	@DataField(pos = 7) 
	private String url;
///*	@DataField(pos = 8, pattern = "dd/MM/yyyy HH:mm") 
//	@JsonFormat(pattern="dd/MM/yyyy HH:mm") 
//	private Date date;*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
//	public String convertTime(long time){
//        Date date = new Date(time);
//        Format format = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa");
//        return format.format(date);
//    }
}
