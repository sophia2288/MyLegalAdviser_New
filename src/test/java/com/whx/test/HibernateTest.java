package com.whx.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.whx.entities.User;
 
public class HibernateTest {
     
    public static void main(String[] args) {
        //初始化一个POJO对象
        
    	User user = new User();
        user.setAccount("sophia2288_7@sina.com");
        user.setPassword("michael7108367865");
        user.setCategory("公检法工作人员");
        user.setConcerns("房屋买卖，房地产转让，侵权");
        user.setContributions((short)6);
        user.setPhone("15872256548");
        user.setEmail("sharp58@mysql.com");
        
        Configuration cfg = new Configuration();
        cfg.configure();
         
        //根据配置获取sessionFactory,然后开启事务
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        String hql="from User";
        Transaction tx = session.beginTransaction();
         
        //使用HQL语句查询
        Query query = session.createQuery(hql);
        @SuppressWarnings("unchecked")
		List<User> userList = query.list();
        System.out.println(userList.size());
        
        //存入user对象至TUser表中
        session.saveOrUpdate(user);
   
        //提交事务，关闭会话
        tx.commit();
        session.close();  
    }
}