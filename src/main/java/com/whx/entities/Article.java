package com.whx.entities;
// Generated 2018-4-17 18:45:44 by Hibernate Tools 5.1.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Article generated by hbm2java
 */
@Entity
@Table(name = "article")
public class Article implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;

	@ManyToOne
	@JoinColumn(name = "lawId")
	private Law law;

	@Column(name = "piece", nullable = true, unique = false)
	private String piece;

	@Column(name = "chapter", nullable = true, unique = false)
	private String chapter;

	@Column(name = "section", nullable = true, unique = false)
	private String section;

	@Column(name = "articleNo", nullable = false, unique = false)
	private String articleNo;

	@Column(name = "branchNo", nullable = false, unique = false)
	private String branchNo;

	@Column(name = "content", nullable = false, unique = true)
	private String content;

	@Column(name = "gist", nullable = true)
	private String gist;

	public Article() {
	}

	public Article(int articleId, Law Law, String articleNo, String branchNo, String content) {
		this.articleId = articleId;
		this.law = Law;
		this.articleNo = articleNo;
		this.branchNo = branchNo;
		this.content = content;
	}

	public Article(int articleId, Law law, String articleNo, String branchNo, String content, String gist) {
		this.articleId = articleId;
		this.law = law;
		this.articleNo = articleNo;
		this.branchNo = branchNo;
		this.content = content;
		this.gist = gist;
	}

	public int getArticleId() {
		return this.articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Law getLaw() {
		return this.law;
	}

	public void setLaw(Law law) {
		this.law = law;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getArticleNo() {
		return this.articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}

	public String getBranchNo() {
		return this.branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGist() {
		return this.gist;
	}

	public void setGist(String gist) {
		this.gist = gist;
	}

}
