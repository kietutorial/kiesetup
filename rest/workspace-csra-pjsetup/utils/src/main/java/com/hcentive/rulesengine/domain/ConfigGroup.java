package com.hcentive.rulesengine.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.envers.Audited;

import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "CONFIG_GROUP")
@NamedQueries(value = {
				@NamedQuery(name = "configGroup.findAll", query = "SELECT cg from ConfigGroup cg"),
				@NamedQuery(name = "configGroup.findAllByCategory", query = "SELECT cg from ConfigGroup cg where cg.configCategory=:configCategory")
		 		})
public class ConfigGroup extends Persistent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "configGroup", orphanRemoval = true, fetch=FetchType.EAGER)
	private List<RuleConfigKeyValue> ruleConfigValues = new ArrayList<RuleConfigKeyValue>();
	
	@Column(name = "VERSION")
	private String version;
	
	@Column(name = "CONFIG_CATEGORY")
	private String configCategory;
	
	@Column(name = "EFFECTIVE_START_DATE")
	private Date effectiveStartDate;
	
	@Column(name = "EFFECTIVE_END_DATE")
	private Date effectiveEndDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RuleConfigKeyValue> getRuleConfigValues() {
		return ruleConfigValues;
	}

	public void setRuleConfigValues(List<RuleConfigKeyValue> ruleConfigValues) {
		this.ruleConfigValues = ruleConfigValues;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public String getConfigCategory() {
		return configCategory;
	}

	public void setConfigCategory(String configCategory) {
		this.configCategory = configCategory;
	}
}
