package com.hrm.datatest;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class EmployeeData {

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFullname() {
		return fullname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public static EmployeeData getEmployee() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "\\testdata\\com\\hrm\\datatest\\Employee.json"), EmployeeData.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("ContactDetail")
	ContactDetail contactDetail;

	public static class ContactDetail {

		@JsonProperty("editFirstname")
		String editFirstname;

		@JsonProperty("editLastname")
		String editLastname;
	}

	public String getEditFirstname() {
		return contactDetail.editFirstname;
	}

	public String getEditLastname() {
		return contactDetail.editLastname;
	}

	@JsonProperty("firstname")
	String firstname;

	@JsonProperty("lastname")
	String lastname;

	@JsonProperty("fullname")
	String fullname;

	@JsonProperty("username")
	String username;

	@JsonProperty("password")
	String password;
}
