package com.lxk.spring.transaction.xml;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
    public void savePerson() {
		this.personDao.savePerson();
		//int a = 1/0;
		//this.personDao.savePerson();
	}
}
