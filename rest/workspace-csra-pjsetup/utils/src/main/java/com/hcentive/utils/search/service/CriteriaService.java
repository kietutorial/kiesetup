package com.hcentive.utils.search.service;

import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Criteria;

import com.hcentive.utils.search.model.SearchCriteria;

public interface CriteriaService {

	CriteriaQuery buildCriteria(CriteriaBuilder criteriaBuilder, Metamodel metamodel, Map<String, Object> searchParams);

	CriteriaQuery buildCriteriaForTotalCount(CriteriaBuilder criteriaBuilder, Metamodel metamodel, Map<String, Object> searchParams);
}
