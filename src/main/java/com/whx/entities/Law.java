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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Law generated by hbm2java。法律法规等规范性文件。
 */
@Entity
@Table(name = "law")
public class Law implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lawId;

	@ManyToOne
	@JoinColumn(name = "briefId")
	private Brief brief;

	@Column(name = "fullName", nullable = false, unique = true, length = 255)
	private String fullName;

	@Column(name = "organ", nullable = false, unique = false, length = 50)
	private String organ;

	@Column(name = "referenceNo", nullable = true, unique = false, length = 50)
	private String referenceNo;

	@Column(name = "publishDate", nullable = true, columnDefinition = "DATE")
	private Date publishDate;

	@Column(name = "effectiveDate", nullable = false, columnDefinition = "DATE")
	private Date effectiveDate;

	@Column(name = "prescription", nullable = false, unique = false, length = 4)
	private String prescription;

	@Column(name = "hierarchy", nullable = false, unique = false, length = 11)
	private String hierarchy;

	@Column(name = "classification", nullable = false, unique = false, length = 5)
	private String classification;

	@Column(name = "classification1", nullable = false, unique = false, length = 3)
	private String classification1;

	@Column(name = "aliases", nullable = true, unique = false, length = 500)
	private String aliases;

	@Column(name = "fullPathName", nullable = true, unique = false, length = 255)
	private String fullPathName;

	@OneToMany(targetEntity = Article.class, mappedBy = "law", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Set<Article> articles = new HashSet<Article>(0);

	// private Set<Article> articles1 = new HashSet<Article>(0);

	public Law() {
	}

	public Law(String fullName, String organ, Date effectiveDate, String prescription, String hierarchy,
			String classification, String classification1) {
		this.fullName = fullName;
		this.organ = organ;
		this.effectiveDate = effectiveDate;
		this.prescription = prescription;
		this.hierarchy = hierarchy;
		this.classification = classification;
		this.classification1 = classification1;
	}

	public Law(Brief brief, String fullName, String organ, String referenceNo, Date publishDate, Date effectiveDate,
			String prescription, String hierarchy, String classification, String classification1, String aliases,
			String fullPathName, Set<Article> articles) {
		this.brief = brief;
		this.fullName = fullName;
		this.organ = organ;
		this.referenceNo = referenceNo;
		this.publishDate = publishDate;
		this.effectiveDate = effectiveDate;
		this.prescription = prescription;
		this.hierarchy = hierarchy;
		this.classification = classification;
		this.classification1 = classification1;
		this.aliases = aliases;
		this.fullPathName = fullPathName;
		this.articles = articles;
	}

	public Integer getLawId() {
		return this.lawId;
	}

	public void setLawId(Integer lawId) {
		this.lawId = lawId;
	}

	public Brief getBrief() {
		return this.brief;
	}

	public void setBrief(Brief brief) {
		this.brief = brief;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrgan() {
		return this.organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getPrescription() {
		return this.prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getHierarchy() {
		return this.hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getClassification1() {
		return this.classification1;
	}

	public void setClassification1(String classification1) {
		this.classification1 = classification1;
	}

	public String getAliases() {
		return this.aliases;
	}

	public void setAliases(String aliases) {
		this.aliases = aliases;
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
