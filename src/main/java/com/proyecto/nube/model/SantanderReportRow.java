package com.proyecto.nube.model;

import java.util.EnumMap;
import java.util.Map;

public class SantanderReportRow {

	private final Map<SantanderReportColumn, String> values = new EnumMap<>(SantanderReportColumn.class);

	public void put(SantanderReportColumn column, Object value) {
		values.put(column, value == null ? "" : String.valueOf(value));
	}

	public String get(SantanderReportColumn column) {
		return values.getOrDefault(column, "");
	}
}
