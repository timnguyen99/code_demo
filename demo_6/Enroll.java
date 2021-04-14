public class Enroll {
	
	String userId;
	String lastName;
	String firstName;
	int version;
	String insurance;
	
	public Enroll(String userId, String firstName, String lastName, int version, String insurance) {
		super();
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.version = version;
		this.insurance = insurance;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Enroll [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", version="
				+ version + ", insurance=" + insurance + "]";
	}
}