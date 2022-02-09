package net.guides.springboot2.springboot2jpacrudexample.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkings")
public class Parking {

	
	private long id;
	private String ownerName;
	private String emailId;
	private String carName;
	private String carNumber;
	private String entryTime;
	private String exitTime;
	
	public Parking() {
		super();
	}

	public Parking(long id, String ownerName, String emailId, String carName, String carNumber, String entryTime,
			String exitTime) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.emailId = emailId;
		this.carName = carName;
		this.carNumber = carNumber;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}
	

//public Parking() {
//	
//}
//
//public Parking(String ownerName, String emailId, String carName, String carNumber, String entryTime, String exitTime) {
//	this.ownerName = ownerName;
//	this.emailId = emailId;
//	this.carName = carName;
//	this.carNumber = carNumber;
//	this.entryTime = entryTime;
//	this.exitTime = exitTime;
//}

//@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
//
//public long getId() {
//	return id;
//}
//public void setId(long id) {
//	this.id = id;
//}
//
//@Column(name = "first_name", nullable = false)
//public String getFirstName() {
//	return firstName;
//}
//public void setFirstName(String firstName) {
//	this.firstName = firstName;
//}
//
//@Column(name = "last_name", nullable = false)
//public String getLastName() {
//	return lastName;
//}
//public void setLastName(String lastName) {
//	this.lastName = lastName;
//}
//
//@Column(name = "email_address", nullable = false)
//public String getEmailId() {
//	return emailId;
//}
//public void setEmailId(String emailId) {
//	this.emailId = emailId;
//}
//


@Override
public String toString() {
	return "Parking [id=" + id + ", ownerName=" + ownerName + ", emailId=" + emailId + ", carName=" + carName+ ", carNumber=" + carNumber + " ,"
			+ "entryTime=" + entryTime + ",exitTime=" + exitTime
			+ "]";	
}
}