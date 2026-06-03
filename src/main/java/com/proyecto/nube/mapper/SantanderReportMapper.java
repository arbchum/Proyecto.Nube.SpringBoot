package com.proyecto.nube.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.nube.model.AccountCsv;
import com.proyecto.nube.model.CreditCardEventCsv;
import com.proyecto.nube.model.SantanderReportRow;

import static com.proyecto.nube.model.SantanderReportColumn.*;

@Component
public class SantanderReportMapper {

	public SantanderReportRow toRow(AccountCsv account, CreditCardEventCsv event) {
		SantanderReportRow row = new SantanderReportRow();

		row.put(CODIGO_DEL_PRODUCTO, account.getAffinityGroupId());
	    row.put(NUMERO_DE_SOLICITUD, account.getExternalId());
	    row.put(CODIGO_DE_REGION, account.getRegionCode());
	    row.put(CODIGO_DE_AGENCIA, account.getAgencyCode());
	    row.put(NOMBRE_DE_SOLICITANTE, account.getUserName());
	    row.put(APELLIDO_DEL_SOLICITANTE, account.getUserSurname());
	    row.put(FECHA_NACIMIENTO, account.getUserBirthdate());
	    row.put(PROFESION_U_OCUPACION, account.getOccupation());
	    row.put(TIPO_DE_DOCUMENTO, account.getIdentificationType());
	    row.put(DOCUMENTO_DE_IDENTIDAD, account.getIdentificationValue());
	    row.put(INGRESOS_MENSUALES_EN_SOLES, account.getMonthlyIncome());
	    row.put(DIRECC_CORRESPONDENCIA_1, account.getAddressStreetName());
	    row.put(DIRECC_CORRESPONDENCIA_2, account.getAddressStreetNumber());
	    row.put(DIRECC_CORRESPONDENCIA_3, account.getAddressZipCode());
	    row.put(DIRECC_EXTRA, account.getAddressCountry());
	    row.put(CODIGO_UBIGEO, account.getUbigeoCode());
	    row.put(DISTRITO, account.getAddressNeighborhood());
	    row.put(PROVINCIA, account.getAddressCity());
	    row.put(DEPARTAMENTO, account.getAddressRegion());
	    row.put(TELEFONO_DEL_CLIENTE, account.getPhone());
	    row.put(NOMBRE_EN_TARJETA, account.getNameOnCard());
	    row.put(LINEA_DE_CREDITO, account.getLineLimit());
	    row.put(CICLO_DE_FACTURACION, account.getBillingDay());
	    row.put(DECLARACION_CLIENTE_PEP, account.getPepFlag());
	    row.put(CODIGO_DE_PERFIL, account.getSegmentId());
	    row.put(LIMITE_PARA_DISP_EFECTIVO, account.getCashAdvanceLimit());
	    row.put(NUMERO_CUENTA, account.getCreditLineId());
	    row.put(DIA_APERTURA_CUENTA, account.getActivationDate());
	    row.put(ESTADO_DE_LA_CUENTA, account.getStatus());
	    row.put(BLOQUEO_CANCELADO_CUENTA, account.getStatusDetail());
	    row.put(FECHA_BLOQUEO_CUENTA, account.getStatusDate());
	    row.put(NUMERO_DE_TARJETA, account.getCardId());
	    row.put(NUMERO_DE_BIN, account.getBin());
	    row.put(CODIGO_DE_REFERIDO, account.getReferredCode());
	    row.put(SEXO, account.getGender());
	    row.put(PAIS_DOCUMENTO, account.getCountryDocument());
	    row.put(NACIONALIDAD, account.getNationality());
	    row.put(ESTADO_CIVIL, account.getCivilState());
	    row.put(CORREO_ELECTRONICO, account.getEmail());
	    row.put(FECHA_CREACION_USUARIO, account.getCreatedAt());

		row.put(ID_UNICO_DEL_EVENTO, event.getMovementId());
		row.put(ID_DEL_EVENTO, event.getEventTypeId());
		row.put(TIPO_DE_EVENTO, event.getEventType());
		row.put(FECHA_INGRESO_TRANSACCION, event.getSystemEntryDate());
		row.put(ID_LINEA_CREDITO, event.getCreditLineId());
		row.put(ID_USUARIO, event.getUserId());
		row.put(FECHA_LOCAL_TRANSACCION, event.getLocalDate());
		row.put(ID_REFERENCIA, event.getReferenceId());
		row.put(MONTO_TRANSACCION, event.getAmount());
		row.put(DESCRIPCION, event.getDescription());
		row.put(TIPO_OPERACION, event.getTypeDebitCredit());
		row.put(MONEDA_EVENTO, event.getCurrency());

		return row;
	}
}
