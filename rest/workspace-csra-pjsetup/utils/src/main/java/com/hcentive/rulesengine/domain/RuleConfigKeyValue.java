package com.hcentive.rulesengine.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.hcentive.utils.orm.model.Persistent;

@Audited
@Entity
@Table(name = "RULE_CONFIG")
@NamedQueries(value = {
				@NamedQuery(name = "ruleConfigKeyValue.findAll", query = "SELECT rc from RuleConfigKeyValue rc"),
				@NamedQuery(name = "ruleConfigKeyValue.findAllSHOP", query = "SELECT rc from RuleConfigKeyValue rc where rc.configGroup.configCategory='SHOP' " )
})
public class RuleConfigKeyValue extends Persistent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "KEY")
	private String key;
	
	@Column(name = "VALUE")
	private String value;	
	
	@Column(name = "DOCUMENT_SHORT_NAME")
	private String shortName;	
	
	@Column(name = "DOCUMENT_DESCRIPTION")
	private String description;	
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "config_group_id")
	private ConfigGroup configGroup;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ConfigGroup getConfigGroup() {
		return configGroup;
	}

	public void setConfigGroup(ConfigGroup configGroup) {
		this.configGroup = configGroup;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
