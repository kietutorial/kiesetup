/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.web.progressBar;

import java.util.LinkedList;
import java.util.List;

public class ProgressBar {

	public static final String QUOTES_PROGRESS_BAR = "quotesProgressBar";
	public static final String EAPP_PROGRESS_BAR = "eAppProgressBar";
	public static final String PROGRESS_BAR_SECTION_NAME = "progressBarSectionName";
	public static final String PROGRESS_BAR_IS_QUOTE_PAGE = "isQuotePage";
	public static final String PROGRESS_BAR_DETAILS_PAGE = "Details";
	public static final String PROGRESS_BAR_PLAN_SUMMARY_PAGE = "Selected Plans";
	public static final String EAPP_ID = "eAppId";

	List<List<Section>> sections;

	Integer currentActiveSectionNum;

	Integer maxActiveSectionNum;

	public List<List<Section>> getSections() {
		if (sections == null) {
			sections = new LinkedList<List<Section>>();
		}
		return sections;
	}

	public void setSections(List<List<Section>> sections) {
		this.sections = sections;
	}

	public Integer getCurrentActiveSectionNum() {
		return currentActiveSectionNum;
	}

	public void setCurrentActiveSectionNum(Integer currentActiveSectionNum) {
		this.currentActiveSectionNum = currentActiveSectionNum;
	}

	public Integer getMaxActiveSectionNum() {
		return maxActiveSectionNum;
	}

	public void setMaxActiveSectionNum(Integer maxActiveSectionNum) {
		this.maxActiveSectionNum = maxActiveSectionNum;
	}

	public class Section {

		String name;

		String url;

		Integer pageNum;

		public Section(String name, String url, Integer pageNum) {
			this.name = name;
			this.url = url;
			this.pageNum = pageNum;
		}

		public Section() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Integer getPageNum() {
			return pageNum;
		}

		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
	}

}
