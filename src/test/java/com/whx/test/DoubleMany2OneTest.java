package com.whx.test;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.whx.entities.Article;
import com.whx.entities.Law;

public class DoubleMany2OneTest {
	
	Session session = null;
	Transaction tx = null;

	@Before
	public void before() {
		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();

		tx = session.beginTransaction();
	}

	@After
	public void after() {
		tx.commit();
        session.close();
	}

	@Test
	public void testSave() {
		Law law= new Law();
        law.setFullName("中华人民共和国合同法");
        law.setOrgan("全国人民代表大会");
        law.setEffectiveDate(Date.valueOf(LocalDate.now()));
        law.setPrescription("现行有效");
        law.setHierarchy("法律");
        law.setClassification("实体");
        law.setClassification1("民商事");
        
        Article article1=new Article();
        article1.setArticleNo("十八");
        article1.setBranchNo("一");
        article1.setContent("成年人为完全民事行为能力人，可以独立实施民事法律行为。");
        
        Article article2=new Article();
        article2.setArticleNo("十八");
        article2.setBranchNo("二");
        article2.setContent("十六周岁以上的未成年人，以自己的劳动收入为主要生活来源的，视为完全民事行为能力人。");
        
        law.getArticles().add(article1);
        law.getArticles().add(article2);
        
        article1.setLaw(law);
        article2.setLaw(law);
        
        /**
		 * 双向1-n的关联关系中，1的一方放弃维护关联关系，由n的一方维护关联关系。 建议"先保存1的一端，再保存n的一端"，这样就不会有多余的update
		 * sql语句
		 */
        session.save(law);
        session.save(article1);
        session.save(article2);
	}
}
