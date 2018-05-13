package com.whx.entities;
// Generated 2018-5-3 16:19:17 by Hibernate Tools 5.1.6.Final

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Article generated by hbm2java。法律法规条文（款）。
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

	//级联刷新  
    //属性optional表示该对象可有可无，其值为true时表示该外键可以为null，值为false时表示该外键为not null        
    //@ManyToOne(cascade = CascadeType.REFRESH,optional = false,fetch = FetchType.LAZY)
    //指定外键列(这也表示为所在对象为“关系被维护端”) 
    //@JoinColumn(name = "lawId")
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name = "lawId",nullable = false)
	//@JoinColumn(name = "lawId",foreignKey = @ForeignKey(name = "FK_R_Law_Article",value = ConstraintMode.NO_CONSTRAINT))//注意这里的@ForeignKey是javax.persistence包中的类，不要使用org.hibernate的类
	//@JoinColumn(name = "lawId",foreignKey = @ForeignKey(name = "null",value = ConstraintMode.NO_CONSTRAINT))//注意这里的@ForeignKey是javax.persistence包中的类，不要使用org.hibernate的类
	private Law law;

	@Column(name = "piece", nullable = true, unique = false, length = 20)
	private String piece;

	@Column(name = "chapter", nullable = true, unique = false, length = 40)
	private String chapter;

	@Column(name = "section", nullable = true, unique = false, length = 40)
	private String section;

	@Column(name = "articleNo", nullable = false, unique = false, length = 6)
	private String articleNo;

	@Column(name = "branchNo", nullable = false, unique = false, length = 2)
	private String branchNo;

	@Column(name = "content", nullable = false, unique = false, length = 1024)
	private String content;

	@Column(name = "gist", nullable = true, unique = false, length = 100)
	private String gist;

	@ManyToMany(targetEntity = Caseclass.class, mappedBy = "articles", cascade = { CascadeType.ALL })
	private Set<Caseclass> caseclasses = new HashSet<Caseclass>(0);

	@ManyToMany(targetEntity = Guidecase.class, mappedBy = "articles", cascade = { CascadeType.ALL })
	private Set<Guidecase> guidecases = new HashSet<Guidecase>(0);

	@ManyToMany(targetEntity = Judgepoint.class, mappedBy = "articles", cascade = { CascadeType.ALL })
	private Set<Judgepoint> judgepoints = new HashSet<Judgepoint>(0);

	@ManyToMany(targetEntity = Doc.class, mappedBy = "articles", cascade = { CascadeType.ALL })
	private Set<Doc> docs = new HashSet<Doc>(0);

	public Article() {
	}

	public Article(int articleId, Law law, String articleNo, String branchNo, String content) {
		this.articleId = articleId;
		this.law = law;
		this.articleNo = articleNo;
		this.branchNo = branchNo;
		this.content = content;
	}

	public Article(int articleId, Law law, String piece, String chapter, String section, String articleNo,
			String branchNo, String content, String gist, Set<Caseclass> caseclasses, Set<Guidecase> guidecases,
			Set<Judgepoint> judgepoints, Set<Doc> docs) {
		this.articleId = articleId;
		this.law = law;
		this.piece = piece;
		this.chapter = chapter;
		this.section = section;
		this.articleNo = articleNo;
		this.branchNo = branchNo;
		this.content = content;
		this.gist = gist;
		this.caseclasses = caseclasses;
		this.guidecases = guidecases;
		this.judgepoints = judgepoints;
		this.docs = docs;
	}

	public int getArticleId() {
		return articleId;
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
		return this.piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public String getChapter() {
		return this.chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getSection() {
		return this.section;
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

	public Set<Caseclass> getCaseclasses() {
		return this.caseclasses;
	}

	public void setCaseclasses(Set<Caseclass> caseclasses) {
		this.caseclasses = caseclasses;
	}

	public Set<Guidecase> getGuidecases() {
		return this.guidecases;
	}

	public void setGuidecases(Set<Guidecase> guidecases) {
		this.guidecases = guidecases;
	}

	public Set<Judgepoint> getJudgepoints() {
		return this.judgepoints;
	}

	public void setJudgepoints(Set<Judgepoint> judgepoints) {
		this.judgepoints = judgepoints;
	}

	public Set<Doc> getDocs() {
		return this.docs;
	}

	public void setDocs(Set<Doc> docs) {
		this.docs = docs;
	}

}
