package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.whx.dao.UserDao;
import com.whx.entities.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	/***** 注入 *****/
	/*
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	*/
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UserDaoImpl() {
		System.out.println("UserDaoImpl()");
	}

	public void save(User user) {
		//sessionFactory.getCurrentSession().saveOrUpdate(user);
		hibernateTemplate.save(user);
	}

	public void delete(User user) {
		/*
		String hql = "delete User u where u.account = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getAccount());
		return (query.executeUpdate() > 0);
		*/
		hibernateTemplate.delete(user);
	}

	public void delete(String account) {
		/*
		String hql = "delete User u where u.account=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, account);
		return (query.executeUpdate() > 0);
		*/
		hibernateTemplate.bulkUpdate("delete User u where u.account = ?", new Object[]{account});
	}

	public void update(User user) {
		/*
		String hql = "update User u set u.password=?,u.category=?,u.phone=?,u.email=?,u.concerns=?,u.contributions=? where u.account=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getPassword());
		query.setString(1, user.getCategory());
		query.setString(2, user.getPhone());
		query.setString(3, user.getEmail());
		query.setString(4, user.getConcerns());
		query.setShort(5, user.getContributions());
		query.setString(6, user.getAccount());

		return (query.executeUpdate() > 0);
		*/
		hibernateTemplate.update(user);
	}

	public User findById(String account) {
		//return (User) sessionFactory.getCurrentSession().get(User.class, account);
		return (User) hibernateTemplate.get(User.class, account);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		//Query query = sessionFactory.getCurrentSession().createQuery("from User");
		//return query.list();
		return (List<User>)hibernateTemplate.find("from User");
	}
	
	//用户类别是依据数据库law表t_user定义的
	public List<String> getCategories() {
		List<String> categoryList = new ArrayList<String>();
		categoryList.add("普通用户");
		categoryList.add("律师");
		categoryList.add("公检法工作人员");
		categoryList.add("高校教师");
		categoryList.add("其他");
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String account) {
		List<User> userList = new ArrayList<User>();
		String hql = "from User u where u.account = :account";
		// Query query =
		// sessionFactory.getCurrentSession().createQuery(hql).setParameter("account",
		// account);
		userList = (List<User>) hibernateTemplate.findByNamedParam(hql, "account", account);
		// userList = query.list();

		return userList.size() > 0 ? true : false;
	}
}