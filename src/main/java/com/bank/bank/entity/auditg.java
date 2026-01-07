package com.bank.bank.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
@Entity
@Table(name="auditg")
@Data
public class auditg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;

    private String methodName;

    @Column(columnDefinition = "TEXT")
    private String parameters;

    public Long getId() {
		return id;
	}

	
	
	public auditg() {
		this.id = id;
		this.accountId = accountId;
		this.methodName = methodName;
		this.parameters = parameters;
		this.response = response;
		this.timestamp = timestamp;
	}



	



	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Column(columnDefinition = "TEXT")
    private String response;

    private LocalDateTime timestamp;

	
}
