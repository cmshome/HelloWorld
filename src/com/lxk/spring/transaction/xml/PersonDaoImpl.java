package com.lxk.spring.transaction.xml;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao{

	@Override
    public void savePerson() {
		this.getJdbcTemplate().execute("INSERT INTO person VALUES (11,'王二麻子11','boy','11','110011')");
	}	
}
