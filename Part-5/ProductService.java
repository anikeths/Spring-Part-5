package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void addProduct(Product prod)
	{
		String SQL = "insert into Product values (?,?,?)";
		jdbcTemplate.update(SQL,new Object[] {prod.getPid(),prod.getPname(),prod.getPrice()});
	}
}
