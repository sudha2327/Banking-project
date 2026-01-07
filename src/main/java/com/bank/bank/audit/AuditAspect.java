package com.bank.bank.audit;
import java.time.LocalDateTime;
import com.bank.bank.repository.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.bank.entity.auditg;
import com.bank.bank.repository.auditlogrepo;

import tools.jackson.databind.ObjectMapper;

@Aspect
@Component
public class AuditAspect {

    @Autowired
    private auditlogrepo auditLogRepository;

    private final ObjectMapper mapper = new ObjectMapper();

    @Around("execution(* com.bank.bank..service..*(..))")
    public Object auditServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        auditg audit = new auditg();

        // Method name
        audit.setMethodName(joinPoint.getSignature().toShortString());

        // Parameters
        audit.setParameters(mapper.writeValueAsString(joinPoint.getArgs()));

        // Timestamp
        audit.setTimestamp(LocalDateTime.now());

        // Account ID extraction
        audit.setAccountId(extractAccountId(joinPoint.getArgs()));

        try {
            Object response = joinPoint.proceed();

            // ✅ Store REAL response
            audit.setResponse(
                    response != null ? mapper.writeValueAsString(response) : "NO_RESPONSE"
            );

            auditLogRepository.save(audit);
            return response;

        } catch (Exception ex) {

            // ✅ Store error response
            audit.setResponse("ERROR: " + ex.getMessage());
            auditLogRepository.save(audit);
            throw ex;
        }
    }

    private Long extractAccountId(Object[] args) {
        for (Object arg : args) {
            if (arg == null) continue;
            try {
                var method = arg.getClass().getMethod("getFromAccountId");
                Object value = method.invoke(arg);
                if (value != null) {
                    return Long.valueOf(value.toString());
                }
            } catch (Exception ignored) {}
        }
        return null;
    }
}
