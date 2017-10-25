package com.lxk.spring.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper{
	@Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getLong("id"));
		person.setName(rs.getString("name"));
		person.setSex(rs.getString("sex"));
		person.setAge(rs.getInt("age"));
		person.setTel(rs.getString("tel"));
		return person;
	}

}
