package com.spring;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	/*public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}*/
	public void saveEmployee(Employee emp) {
		SessionFactory sf = hibernateTemplate.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(emp);
		tx.commit();
		s.close();
	}

	public void updateEmployee(int empId, int empSalary) {
		SessionFactory sf = hibernateTemplate.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Employee emp = (Employee) s.get(Employee.class,empId);
		emp.setEmpSalary(empSalary);
		s.update(emp);
		tx.commit();
		s.close();
	}

	public void deleteEmployee(int empId) {
		SessionFactory sf = hibernateTemplate.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Employee emp = (Employee) s.get(Employee.class,empId);
		s.delete(emp);
		tx.commit();
		s.close();	
	}

	public List<Employee> listEmployees() {
		return hibernateTemplate.loadAll(Employee.class);
	}

}
