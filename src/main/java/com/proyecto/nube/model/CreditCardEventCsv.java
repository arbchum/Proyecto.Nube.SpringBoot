package com.proyecto.nube.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class CreditCardEventCsv {

    @CsvBindByName(column = "movement_id")
    private String movementId;

    @CsvBindByName(column = "event_type_id")
    private String eventTypeId;

    @CsvBindByName(column = "event_type")
    private String eventType;

    @CsvBindByName(column = "credit_line_id")
    private String creditLineId;

    @CsvBindByName(column = "user_id")
    private String userId;

    @CsvBindByName(column = "local_date")
    private String localDate;

    @CsvBindByName(column = "reference_id")
    private String referenceId;

    @CsvBindByName(column = "amount")
    private String amount;

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "type_debitcredit")
    private String typeDebitCredit;

    @CsvBindByName(column = "currency")
    private String currency;

    @CsvBindByName(column = "system_entry_date")
    private String systemEntryDate;
}
