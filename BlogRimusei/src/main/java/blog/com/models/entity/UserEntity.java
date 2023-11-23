package blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name="admin")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long adminId;
	
	@NonNull
	private String adminEmail;
	@NonNull
	private String adminName;
	@NonNull
	private String password;
	
	public UserEntity() {
		
	}

	public UserEntity(String adminEmail, String adminName, String password) {
		super();
		this.adminEmail = adminEmail;
		this.adminName = adminName;
		this.password = password;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
