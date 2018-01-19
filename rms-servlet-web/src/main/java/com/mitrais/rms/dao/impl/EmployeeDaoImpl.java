package com.mitrais.rms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mitrais.rms.dao.DataSourceFactory;
import com.mitrais.rms.dao.EmployeeDao;
import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee find(Long id) {
		try (Connection connection = DataSourceFactory.getConnection())
        {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employee WHERE id=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                Employee emp = new Employee(rs.getLong("id"), rs.getString("name"), rs.getString("position"), rs.getString("office"));
                return emp;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return null;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> result = new ArrayList<>();
        try (Connection connection = DataSourceFactory.getConnection())
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next())
            {
            	Employee emp = new Employee(rs.getLong("id"), rs.getString("name"), rs.getString("position"), rs.getString("office"));
                result.add(emp);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return result;
	}

	@Override
	public boolean save(Employee emp) {
		 try (Connection connection = DataSourceFactory.getConnection())
	        {
	            PreparedStatement stmt = connection.prepareStatement("INSERT INTO employee VALUES (NULL, ?, ?, ?)");
	            stmt.setString(1, emp.getName());
	            stmt.setString(2, emp.getPosition());
	            stmt.setString(3, emp.getOffice());
	            int i = stmt.executeUpdate();
	            if(i == 1) {
	                return true;
	            }
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean update(Employee emp) {
		 try (Connection connection = DataSourceFactory.getConnection())
	        {
	            PreparedStatement stmt = connection.prepareStatement("UPDATE employee SET name=?, position=?, office=? WHERE id=?");
	            stmt.setString(1, emp.getName());
	            stmt.setString(2, emp.getPosition());
	            stmt.setString(3, emp.getOffice());
	            stmt.setLong(4, emp.getId());
	            int i = stmt.executeUpdate();
	            if(i == 1) {
	                return true;
	            }
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean delete(Employee emp) {
		try (Connection connection = DataSourceFactory.getConnection())
        {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM employee WHERE id=?");
            stmt.setLong(1, emp.getId());
            int i = stmt.executeUpdate();
            if(i == 1) {
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
	}

	@Override
	public Optional<Employee> findByName(String name) {
		try (Connection connection = DataSourceFactory.getConnection())
        {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employee WHERE name=?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
            	Employee emp = new Employee(rs.getLong("id"), rs.getString("name"), rs.getString("position"), rs.getString("office"));
                return Optional.of(emp);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return Optional.empty();
	}
	
	 private static class SingletonHelper
	    {
	        private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();
	    }

	    public static EmployeeDao getInstance()
	    {
	        return SingletonHelper.INSTANCE;
	    }
	
}
