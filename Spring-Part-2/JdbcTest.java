package com.spring;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		StudentDAO dao = (StudentDAO) context.getBean("student");
		//dao.insertStudent(111,"Raj",15);
		//dao.updateStudent(111,20);
		//dao.deleteStudent(111);
		List<Map<String,Object>> studList = dao.listStudents();
		for(Map stud : studList)
		{
			System.out.println(stud.get("id")+" "+stud.get("name")+" "+stud.get("age"));
		}
	}

}
