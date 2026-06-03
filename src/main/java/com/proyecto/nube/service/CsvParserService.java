package com.proyecto.nube.service;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CsvParserService {

	public <T> List<T> parse(MultipartFile file, Class<T> type) {
		try {
			return new CsvToBeanBuilder<T>(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))
					.withType(type).withSeparator(';').withIgnoreLeadingWhiteSpace(true).build().parse();
		} catch (Exception e) {
			throw new RuntimeException("Error leyendo CSV: " + file.getOriginalFilename(), e);
		}
	}
}
