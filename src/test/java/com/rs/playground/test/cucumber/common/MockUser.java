package com.rs.playground.test.cucumber.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class MockUser {

	private String email;
	private String password;
}
