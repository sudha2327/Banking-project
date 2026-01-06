package com.bank.bank.entity;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="audit_log")
public class auditg {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	private String methodname;
	@Column(length=1000)
	private String arguments;
	private Instant createdAt=Instant.now();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public String getArguments() {
		return arguments;
	}
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public auditg(String methodname, String arguments) {
		super();
		this.id = id;
		this.methodname = methodname;
		this.arguments = arguments;
		this.createdAt = createdAt;
	}
	
	
	
	
}
