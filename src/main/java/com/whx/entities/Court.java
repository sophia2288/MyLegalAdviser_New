package com.whx.entities;
// Generated 2018-5-3 16:19:17 by Hibernate Tools 5.1.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Court generated by hbm2java
 */
@Entity
@Table(name = "court")
public class Court implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String courtCode;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="courtCode_h")
	private Court court;
	
	@Column(name = "name", nullable = false, unique = true, length=40)
	private String name;
	
	@Column(name = "startDate", nullable = true, columnDefinition = "DATE")
	private Date startDate;
	
	@Column(name = "formerName", nullable = true, unique = false, length=60)
	private String formerName;
	
	@OneToMany(targetEntity=Court.class,mappedBy="court",cascade= CascadeType.ALL)
	private Set<Court> courts = new HashSet<Court>(0);
	
	@OneToMany(targetEntity = Doc.class, mappedBy = "court", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Set<Doc> docs = new HashSet<Doc>(0);

	public Court() {
	}

	public Court(String courtCode, String name) {
		this.courtCode = courtCode;
		this.name = name;
	}

	public Court(String courtCode, Court court, String name, Date startDate, String formerName, Set<Court> courts, Set<Doc> docs) {
		this.courtCode = courtCode;
		this.court = court;
		this.name = name;
		this.startDate = startDate;
		this.formerName = formerName;
		this.courts = courts;
		this.docs = docs;
	}

	public String getCourtCode() {
		return this.courtCode;
	}

	public void setCourtCode(String courtCode) {
		this.courtCode = courtCode;
	}

	public Court getCourt() {
		return this.court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getFormerName() {
		return this.formerName;
	}

	public void setFormerName(String formerName) {
		this.formerName = formerName;
	}

	public Set<Court> getCourts() {
		return this.courts;
	}

	public void setCourts(Set<Court> courts) {
		this.courts = courts;
	}

	public Set<Doc> getDocs() {
		return this.docs;
	}

	public void setDocs(Set<Doc> docs) {
		this.docs = docs;
	}

}
