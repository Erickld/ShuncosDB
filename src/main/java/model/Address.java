package model;

import javax.persistence.*;


@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	
	@Column(name = "country", nullable = false, length = 50)
	private String country;
	
	@Column(name = "state", nullable = false, length = 50)
	private String state;
	
	@Column(name = "city", nullable = false, length = 75)
	private String city;
	
	@Column(name = "colony", nullable = false, length = 75)
	private String colony;
	
	@Column(name = "street", nullable = false, length = 100)
	private String street;
	
	@Column(name = "zip_code", nullable = false, length = 10)
	private String zip_code;
	
	@Column (name = "phone", nullable = false, length = 15)
	private String phone;
	
	
	// Constructor empty
	public Address() {

	}

	// Constructor with ID
	public Address(int id, String country, String state, String city, String colony, String street, String zip_code,
			String phone) {
		super();
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.colony = colony;
		this.street = street;
		this.zip_code = zip_code;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
