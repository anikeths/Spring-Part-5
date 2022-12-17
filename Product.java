package com.spring.boot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //@Setter, @Getter and @ToString
public class Product {
	private int pid;
	private String pname;
	private int price;
}
