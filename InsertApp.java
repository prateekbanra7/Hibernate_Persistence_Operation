package in.abc.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.abc.Model.Employee;
import in.abc.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;


		try {
			session = HibernateUtil.getSession();
			
			if (session != null)
				transaction = session.beginTransaction();//con.setAutocommit(false)
			
			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpId(18);
				employee.setEmpName("kohli");
				employee.setEmpSal(45474.5);

				session.persist(employee);//perform save operation
				flag = true;
			} 
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if(flag == true)
				transaction.commit();//con.commit()
			else
				transaction.rollback();//con.rollback()
			
			HibernateUtil.closeSession(session);

		}
		
	}

}
