package com.proyecto.nube.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class AccountCsv {

    @CsvBindByName(column = "affinity_group_id")
    private String affinityGroupId;

    @CsvBindByName(column = "external_id")
    private String externalId;

    @CsvBindByName(column = "region_code")
    private String regionCode;

    @CsvBindByName(column = "agency_code")
    private String agencyCode;

    @CsvBindByName(column = "user_name")
    private String userName;

    @CsvBindByName(column = "user_surname")
    private String userSurname;

    @CsvBindByName(column = "user_birthdate")
    private String userBirthdate;

    @CsvBindByName(column = "occupation")
    private String occupation;

    @CsvBindByName(column = "identification_type")
    private String identificationType;

    @CsvBindByName(column = "identification_value")
    private String identificationValue;

    @CsvBindByName(column = "monthly_income")
    private String monthlyIncome;

    @CsvBindByName(column = "address_street_name")
    private String addressStreetName;

    @CsvBindByName(column = "address_street_number")
    private String addressStreetNumber;

    @CsvBindByName(column = "address_zip_code")
    private String addressZipCode;

    @CsvBindByName(column = "address_country")
    private String addressCountry;

    @CsvBindByName(column = "ubigeo_code")
    private String ubigeoCode;

    @CsvBindByName(column = "address_neighborhood")
    private String addressNeighborhood;

    @CsvBindByName(column = "address_region")
    private String addressRegion;

    @CsvBindByName(column = "address_city")
    private String addressCity;

    @CsvBindByName(column = "phone")
    private String phone;

    @CsvBindByName(column = "name_on_card")
    private String nameOnCard;

    @CsvBindByName(column = "line_limit")
    private String lineLimit;

    @CsvBindByName(column = "billing_day")
    private String billingDay;

    @CsvBindByName(column = "pep_flag")
    private String pepFlag;

    @CsvBindByName(column = "segment_id")
    private String segmentId;

    @CsvBindByName(column = "cash_advance_limit")
    private String cashAdvanceLimit;

    @CsvBindByName(column = "credit_line_id")
    private String creditLineId;

    @CsvBindByName(column = "activation_date")
    private String activationDate;

    @CsvBindByName(column = "status")
    private String status;

    @CsvBindByName(column = "status_detail")
    private String statusDetail;

    @CsvBindByName(column = "status_date")
    private String statusDate;

    @CsvBindByName(column = "card_id")
    private String cardId;

    @CsvBindByName(column = "bin")
    private String bin;

    @CsvBindByName(column = "referred_code")
    private String referredCode;

    @CsvBindByName(column = "gender")
    private String gender;

    @CsvBindByName(column = "country_document")
    private String countryDocument;

    @CsvBindByName(column = "nationality")
    private String nationality;

    @CsvBindByName(column = "civil_state")
    private String civilState;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "created_at")
    private String createdAt;
}
