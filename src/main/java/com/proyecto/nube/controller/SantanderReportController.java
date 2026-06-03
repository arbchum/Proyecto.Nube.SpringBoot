package com.proyecto.nube.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.nube.service.SantanderReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/santander/reports")
@RequiredArgsConstructor
public class SantanderReportController {

	private final SantanderReportService santanderReportService;

	@PostMapping(value = "/convert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<byte[]> convert(@RequestPart("accountsFile") MultipartFile accountsFile,
			@RequestPart("eventsFile") MultipartFile eventsFile) {
		byte[] excel = santanderReportService.convert(accountsFile, eventsFile);

		String fileName = String.format("Reporte_Santander_%s.xlsx",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", fileName))
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(excel);
	}
}
