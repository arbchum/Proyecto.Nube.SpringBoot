package com.proyecto.nube.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.nube.mapper.SantanderReportMapper;
import com.proyecto.nube.model.*;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SantanderReportService {

    private final CsvParserService csvParserService;
    private final SantanderReportMapper mapper;
    private final ExcelGeneratorService excelGeneratorService;

    public byte[] convert(MultipartFile accountsFile, MultipartFile eventsFile) {

        List<AccountCsv> accounts = csvParserService.parse(accountsFile, AccountCsv.class);
        List<CreditCardEventCsv> events = csvParserService.parse(eventsFile, CreditCardEventCsv.class);

        Map<String, AccountCsv> accountsByCreditLineId = accounts.stream()
                .collect(Collectors.toMap(
                        AccountCsv::getCreditLineId,
                        Function.identity(),
                        (a, b) -> a
                ));

        List<SantanderReportRow> rows = events.stream()
                .map(event -> {
                    AccountCsv account = accountsByCreditLineId.get(event.getCreditLineId());

//                    if (account == null) {
//                        throw new RuntimeException(
//                                "No existe cuenta para credit_line_id: " + event.getCreditLineId()
//                        );
//                    }

                    return mapper.toRow(account, event);
                })
                .toList();

        return excelGeneratorService.generate(rows);
    }
}
