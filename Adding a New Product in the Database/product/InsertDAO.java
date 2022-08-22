package com.product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class InsertDAO {
	public int insert(Product e)
	{
	  SessionFactory sf=Config.hibConfig();
	  Session s=sf.openSession();
	  Transaction t=s.beginTransaction();
	  int r=(Integer)s.save(e);
	  t.commit();
	  return r;
	}

	

}
