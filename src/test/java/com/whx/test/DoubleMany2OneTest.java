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
        law.setFullName("中华人民共和国民法总则");
        law.setOrgan("全国人民代表大会");
        law.setEffectiveDate(Date.valueOf(LocalDate.now()));
        law.setPrescription("现行有效");
        law.setHierarchy("法律");
        law.setClassification("实体");
        law.setClassification1("民商事");
        
        Article article1=new Article();
        article1.setArticleNo("十六");
        article1.setBranchNo("一");
        article1.setContent("涉及遗产继承、接受赠与等胎儿利益保护的，胎儿视为具有民事权利能力。但是胎儿娩出时为死体的，其民事权利能力自始不存在。");
        
        Article article2=new Article();
        article2.setArticleNo("十五");
        article2.setBranchNo("一");
        article2.setContent("自然人的出生时间和死亡时间，以出生证明、死亡证明记载的时间为准;没有出生证明、死亡证明的，以户籍登记或者其他有效身份登记记载的时间为准。有其他证据足以推翻以上记载时间的，以该证据证明的时间为准。");
        
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
