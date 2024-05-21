package example.hibernate.entity;
//This is an entity class of which an object will be
//persisted (stored) as a record in the database table.
public class Doctor {
	private int doctorId;
	private String name;
	private String specialization;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(int doctorId, String name, String specialization) {
		this.doctorId = doctorId;
		this.name = name;
		this.specialization = specialization;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization + "]";
	}

}
