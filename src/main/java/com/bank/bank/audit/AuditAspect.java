
package com.bank.bank.audit;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.bank.bank.entity.auditg;
import com.bank.bank.repository.auditlogrepo;

@Aspect
@Component
public class AuditAspect {
	private final auditlogrepo auditrep;
	
    public AuditAspect(auditlogrepo auditrep) {
		super();
		this.auditrep = auditrep;
	}

    @Before("execution (* com.bank.bank.service.*.*(..))")
    public void logMethodCall(JoinPoint joinpoint) {
    	String method=joinpoint.getSignature().toShortString();
    	String args=Arrays.toString(joinpoint.getArgs());
    	System.out.println("Audit -<"+method + "| Args : "+args);
    	auditrep.save(new auditg(method,args));
    }
 
    
	@AfterReturning(pointcut = "execution(* com.fintech..*(..))", returning = "result")
    public void audit(JoinPoint jp, Object result) {
        System.out.println("AUDIT: " + jp.getSignature());
    }
}
