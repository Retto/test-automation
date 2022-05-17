package com.rs.playground.test.cucumber.common;


public class Globals {
	
	public static MockUser tenant_admin = MockUser.of("kobiz.technology@gmail.com", "retto-test");
	public static MockUser sysadmin = MockUser.of("sysadmin@thingsboard.org", "sysadmin");
	public static MockUser tenant = MockUser.of("tenant@thingsboard.org", "tenant");
	public static MockUser tenant_customer_A = MockUser.of("customerA@thingsboard.org", "customer");
	public static MockUser tenant_customer_B = MockUser.of("customerB@thingsboard.org", "customer");
	public static MockUser tenant_customer_C = MockUser.of("customerC@thingsboard.org", "customer");
	
}
