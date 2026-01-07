package com.bank.bank.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.bank.service.Auditpdfservice;

@RestController
@RequestMapping("/api/audit")
public class auditcontrollert {

    @Autowired
    private Auditpdfservice auditPdfService;

    @GetMapping("/monthly-pdf")
    public ResponseEntity<byte[]> downloadMonthlyAuditPdf(
            @RequestParam Long accountId,
            @RequestParam int month,
            @RequestParam int year
    ) throws Exception {

        byte[] pdf = auditPdfService.generateMonthlyPdf(accountId, month, year);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=Audit_Report_" + month + "_" + year + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}
