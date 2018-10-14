package com.east.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 902783495L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id" , nullable = false, updatable = false)
	private Long id;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String birthDay;
	private String nationality;
	private String address;
	private String religion;
	private String education;
	private String institute;
	private String faculty;
	private String branch;
	private String startyearEducation;
	private String endyearEducation;
	private String gpaEducation;
	private String startmonthJobexp;
	private String startyearhJobexp;
	private String endyearJobexp;
	private String endmonthJobexp;
	private String companyNameJobexp;
	private String careerJobexp;
	private String salaryJobexp;
	private String descriptionJobexp;
	private String email;
	private String idcard;
	private String phone;
	private boolean nowjob = false;
	private boolean enabled = true;
	
	@Transient
	private MultipartFile userImage;
	
	private String partImage;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.ALL,  mappedBy = "user" )
	@JsonIgnore
	private Employee employee;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Comment> commentList;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isNowjob() {
		return nowjob;
	}

	public void setNowjob(boolean nowjob) {
		this.nowjob = nowjob;
	}

	public String getPartImage() {
		return partImage;
	}

	public void setPartImage(String partImage) {
		this.partImage = partImage;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	

	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MultipartFile getUserImage() {
		return userImage;
	}

	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
	}
	
	

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStartyearEducation() {
		return startyearEducation;
	}

	public void setStartyearEducation(String startyearEducation) {
		this.startyearEducation = startyearEducation;
	}

	public String getEndyearEducation() {
		return endyearEducation;
	}

	public void setEndyearEducation(String endyearEducation) {
		this.endyearEducation = endyearEducation;
	}

	public String getGpaEducation() {
		return gpaEducation;
	}

	public void setGpaEducation(String gpaEducation) {
		this.gpaEducation = gpaEducation;
	}

	public String getStartmonthJobexp() {
		return startmonthJobexp;
	}

	public void setStartmonthJobexp(String startmonthJobexp) {
		this.startmonthJobexp = startmonthJobexp;
	}

	public String getStartyearhJobexp() {
		return startyearhJobexp;
	}

	public void setStartyearhJobexp(String startyearhJobexp) {
		this.startyearhJobexp = startyearhJobexp;
	}

	public String getEndyearJobexp() {
		return endyearJobexp;
	}

	public void setEndyearJobexp(String endyearJobexp) {
		this.endyearJobexp = endyearJobexp;
	}

	public String getEndmonthJobexp() {
		return endmonthJobexp;
	}

	public void setEndmonthJobexp(String endmonthJobexp) {
		this.endmonthJobexp = endmonthJobexp;
	}

	public String getCompanyNameJobexp() {
		return companyNameJobexp;
	}

	public void setCompanyNameJobexp(String companyNameJobexp) {
		this.companyNameJobexp = companyNameJobexp;
	}

	public String getCareerJobexp() {
		return careerJobexp;
	}

	public void setCareerJobexp(String careerJobexp) {
		this.careerJobexp = careerJobexp;
	}

	public String getSalaryJobexp() {
		return salaryJobexp;
	}

	public void setSalaryJobexp(String salaryJobexp) {
		this.salaryJobexp = salaryJobexp;
	}

	public String getDescriptionJobexp() {
		return descriptionJobexp;
	}

	public void setDescriptionJobexp(String descriptionJobexp) {
		this.descriptionJobexp = descriptionJobexp;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	
}
