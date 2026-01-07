package com.bank.bank.service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.bank.bank.entity.auditg;
import com.bank.bank.repository.auditlogrepo;
import com.itextpdf.text.Document;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class Auditpdfservice {
	 @Autowired
	    private  auditlogrepo auditLogRepository;
	    public byte[] generateMonthlyPdf(Long accountId, int month, int year) throws Exception {
	    	
	    	java.util.List<auditg> logs=auditLogRepository.findMonthlyAudit(accountId, month, year);
	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        PdfWriter.getInstance(document, out);
	        document.open();
	        document.add(new Paragraph("VaultCore Financial"));
	        document.add(new Paragraph("Monthly Audit Report"));
	        document.add(new Paragraph("Account ID: " + accountId));
	        document.add(new Paragraph("Period: " + month + "/" + year));
	        document.add(new Paragraph("--------------------------------------------------"));
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	       
			if (logs.isEmpty()) {
	            document.add(new Paragraph("No audit records found for this period."));
	        }
			
	        for (auditg log : logs) {
	            document.add(new Paragraph("Timestamp: " + log.getTimestamp().format(formatter)));
	            document.add(new Paragraph("Method: " + log.getMethodName()));
	            document.add(new Paragraph("Parameters: " + log.getParameters()));
	            document.add(new Paragraph("Response: " + log.getResponse()));
	            document.add(new Paragraph("--------------------------------------------------"));
	        }

	        document.close();
	        return out.toByteArray();
	      
}
}