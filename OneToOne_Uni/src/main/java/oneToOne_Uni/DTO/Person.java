package oneToOne_Uni.DTO;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private int id;
	private String name;
	private long phone;
	@OneToOne
	private AdharCard adharcard;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public AdharCard getAdharcard() {
		return adharcard;
	}
	public void setAdharcard(AdharCard adharcard) {
		this.adharcard = adharcard;
	}
//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", adharcard=" + adharcard + "]";
//	}
//	
	
}
