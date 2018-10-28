package com.whx.entities;
// Generated 2018-5-3 16:19:17 by Hibernate Tools 5.1.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Judgepoint generated by hbm2java。裁判观点、案例评析、法律适用解读等。
 */
@Entity
@Table(name = "judgepoint")
public class Judgepoint implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer judgePointId;
	
	//@ManyToOne
	//@JoinColumn(name = "briefId",nullable=false)
	@Column(name = "brief", nullable = false, unique = false, length = 40)
	private String brief;
	
	@ManyToOne
	@JoinColumn(name = "docId")
	private Doc doc;
	
	@Column(name = "title", nullable = false, unique = false, length=256)
	private String title;
	
	@Column(name = "subtitle", nullable = true, unique = false, length=256)
	private String subtitle;
	
	@Column(name = "source", nullable = false, unique = false, length=50)
	private String source;
	
	@Column(name = "pubDate", nullable = true, columnDefinition = "DATE")
	private Date pubDate;
	
	@Column(name = "category", nullable = false, unique = false, length=6)
	private String category;
	
	@Column(name = "author", nullable = true, unique = false, length=100)
	private String author;
	
	@Column(name = "keywords", nullable = true, unique = false, length=2048)
	private String keywords;
	
	@Column(name = "fullPathName", nullable = false, unique = false, length=255)
	private String fullPathName = "E:\\myLaw\\judgepoints\\";
	
	@ManyToMany(targetEntity = Article.class, fetch = FetchType.LAZY,cascade=CascadeType.ALL)    
    @JoinTable(name = "judgepoint_article", joinColumns = @JoinColumn(name = "judgePointId"), inverseJoinColumns = @JoinColumn(name = "articleId"))
	private Set<Article> articles = new HashSet<Article>(0);

	public Judgepoint() {
	}

	public Judgepoint(String brief, String title, String source, String category, String fullPathName) {
		this.brief = brief;
		this.title = title;
		this.source = source;
		this.category = category;
		this.fullPathName = fullPathName;
	}

	public Judgepoint(String brief, Doc doc, String title, String subtitle, String source, Date pubDate, String category,
			String author, String keywords, String fullPathName, Set<Article> articles) {
		this.brief = brief;
		this.doc = doc;
		this.title = title;
		this.subtitle = subtitle;
		this.source = source;
		this.pubDate = pubDate;
		this.category = category;
		this.author = author;
		this.keywords = keywords;
		this.fullPathName = fullPathName;
		this.articles = articles;
	}

	public Integer getJudgePointId() {
		return this.judgePointId;
	}

	public void setJudgePointId(Integer judgePointId) {
		this.judgePointId = judgePointId;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	public Doc getDoc() {
		return this.doc;
	}

	public void setDoc(Doc doc) {
		this.doc = doc;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getFullPathName() {
		return this.fullPathName;
	}

	public void setFullPathName(String fullPathName) {
		this.fullPathName = fullPathName;
	}

	public Set<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

}
