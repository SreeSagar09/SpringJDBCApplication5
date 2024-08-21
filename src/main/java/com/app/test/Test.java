package com.app.test;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
		
		String sql1 = "select * from employee e where e.employee_name='Sree Sagar'";
		List<Map<String, Object>> employeeList1 = jdbcTemplate.queryForList(sql1);
		System.out.println(employeeList1);
		
		String sql2 = "select e.employee_name from employee e";
		List<String> employeeNameList1 = jdbcTemplate.queryForList(sql2, String.class);
		System.out.println(employeeNameList1);
		
		String sql3 = "select e.employee_name from employee e where e.employee_name=? or e.designation=?";
		List<Map<String, Object>> employeeList2 = jdbcTemplate.queryForList(sql3, "Sree Sagar", "QA Engineer");
		System.out.println(employeeList2);
		
		String sql4 = "select e.employee_code from employee e where e.employee_id=?";
		List<String> employeeCodeList1 = jdbcTemplate.queryForList(sql4, String.class, 2);
		System.out.println(employeeCodeList1);
		
		String sql5 = "select e.employee_name from employee e where e.employee_name=?";
		Object[] arguments1 = {"Pavan"};
		List<String> employeeNameList2 = jdbcTemplate.queryForList(sql5, arguments1, String.class);
		System.out.println(employeeNameList2);
		
		String sql6 = "select e.employee_name, e.employee_code from employee e where e.designation=?";
		Object[] arguments2 = {"Software Engineer"};
		int[] argumentsTypes1 = {Types.VARCHAR};
		List<Map<String, Object>> employeeList3 = jdbcTemplate.queryForList(sql6, arguments2, argumentsTypes1);
		System.out.println(employeeList3);
		
		String sql7 = "select e.employee_code from employee e where e.employee_name=?";
		Object[] arguments3 = {"Aravind"};
		int[] argumentsTypes2 = {Types.VARCHAR};
		List<String> employeeCodeList2 = jdbcTemplate.queryForList(sql7, arguments3, argumentsTypes2, String.class);
		System.out.println(employeeCodeList2);
	}
}
