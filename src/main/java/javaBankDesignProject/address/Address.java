package javaBankDesignProject.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

    @Id
    private String addressId;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String province;

    @OneToOne
    private Address address;

    public Address(String addressId, String streetNumber, String postalCode, String city, String province) {
	this.addressId = addressId;
	this.streetNumber = streetNumber;
	this.postalCode = postalCode;
	this.city = city;
	this.province = province;
    }

    public String getAddressId() {
	return addressId;
    }

    public void setAddressId(String addressId) {
	this.addressId = addressId;
    }

    public String getStreetNumber() {
	return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
	this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getProvince() {
	return province;
    }

    public void setProvince(String province) {
	this.province = province;
    }
}