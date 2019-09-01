package com.hcentive.utils.search.datatable.model;

import java.util.Map;

/**
 * @author vaibhav
 * 
 */
public class DatatableSearchRequest {

	/**
	 * Display start point in the current data set.
	 */
	private Integer iDisplayStart;

	/**
	 * Number of records that the table can display in the current draw. It is
	 * expected that the number of records returned will be equal to this
	 * number, unless the server has fewer records to return.
	 */
	private Integer iDisplayLength;
	/**
	 * Number of columns being displayed
	 */
	private Integer iColumns;

	/**
	 * Number of columns to sort on
	 */
	private Integer iSortingCols;
	/**
	 * Comma separated column names, this will correspond to table columns in
	 * database
	 */
	private String sColumns;
	/**
	 * Comma delimited array of sColumns
	 */
	private String[] sColumnsArray;

	/**
	 * Map with column index as key and boolean value which will be true if the
	 * individual column filter should be treated as a regular expression for
	 * advanced filtering, false if not
	 */
	private Map<Integer, Boolean> bRegexMap;
	/**
	 * Map with column index as key and boolean value which will be true if the
	 * individual column is searchable, false if not
	 */
	private Map<Integer, Boolean> bSearchableMap;
	/**
	 * Map with column index as key and boolean value which will be true if the
	 * individual column is sortable, false if not
	 */
	private Map<Integer, Boolean> bSortableMap;
	/**
	 * Map with column index as key and column filter as value
	 */
	private Map<Integer, String> sSearchMap;
	/**
	 * Map with sort count as key and column being sorted on as value. For
	 * instance, if iSortingCols = 2 this map will contain two entries for each
	 * sort column
	 */
	private Map<Integer, Integer> iSortColMap;
	/**
	 * Map with sort count as key and sorting direction as the value.
	 */
	private Map<Integer, String> sSortDirMap;

	/**
	 * Information for DataTables to use for rendering. This is for internal
	 * usage of datatable
	 */
	private Integer sEcho;

	private boolean userColumnNameForSorting;

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getiColumns() {
		return iColumns;
	}

	public void setiColumns(Integer iColumns) {
		this.iColumns = iColumns;
	}

	public Integer getiSortingCols() {
		return iSortingCols;
	}

	public void setiSortingCols(Integer iSortingCols) {
		this.iSortingCols = iSortingCols;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	public String[] getsColumnsArray() {
		return sColumnsArray;
	}

	public void setsColumnsArray(String[] sColumnsArray) {
		this.sColumnsArray = sColumnsArray;
	}

	public Map<Integer, Boolean> getbRegexMap() {
		return bRegexMap;
	}

	public void setbRegexMap(Map<Integer, Boolean> bRegexMap) {
		this.bRegexMap = bRegexMap;
	}

	public Map<Integer, Boolean> getbSearchableMap() {
		return bSearchableMap;
	}

	public void setbSearchableMap(Map<Integer, Boolean> bSearchableMap) {
		this.bSearchableMap = bSearchableMap;
	}

	public Map<Integer, Boolean> getbSortableMap() {
		return bSortableMap;
	}

	public void setbSortableMap(Map<Integer, Boolean> bSortableMap) {
		this.bSortableMap = bSortableMap;
	}

	public Map<Integer, String> getsSearchMap() {
		return sSearchMap;
	}

	public void setsSearchMap(Map<Integer, String> sSearchMap) {
		this.sSearchMap = sSearchMap;
	}

	public Map<Integer, Integer> getiSortColMap() {
		return iSortColMap;
	}

	public void setiSortColMap(Map<Integer, Integer> iSortColMap) {
		this.iSortColMap = iSortColMap;
	}

	public Map<Integer, String> getsSortDirMap() {
		return sSortDirMap;
	}

	public void setsSortDirMap(Map<Integer, String> sSortDirMap) {
		this.sSortDirMap = sSortDirMap;
	}

	public Integer getsEcho() {
		return sEcho;
	}

	public void setsEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	public boolean isUserColumnNameForSorting() {
		return userColumnNameForSorting;
	}

	public void setUserColumnNameForSorting(boolean userColumnNameForSorting) {
		this.userColumnNameForSorting = userColumnNameForSorting;
	}

}
