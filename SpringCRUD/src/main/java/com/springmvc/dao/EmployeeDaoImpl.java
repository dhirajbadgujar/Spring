package com.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Employee findById(int id) {
		Employee e = entityManager.find(Employee.class, id);
		return e;
	}

	@Override
	public void saveEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Employee e = entityManager.getReference(Employee.class, employee.getId());
		if(e != null) {
			entityManager.remove(e);
			entityManager.flush();
		}
	}

	@Override
	public List<Employee> findAllEmployees() {
		CriteriaBuilder cr = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> query = cr.createQuery(Employee.class);
		Root<Employee> empRoot = query.from(Employee.class);
		query.select(empRoot);
		return entityManager.createQuery(query).getResultList();
	}

}
