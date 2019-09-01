package com.hcentive.utils.enrollment;

import java.util.Date;

/**
 * The Class DateWrapper will provide functionality of wrapper object to pass
 * date as reference in parameter, even in case of null date, so that function
 * can assigned calculated values.
 * 
 * @version 1.0
 * @author Vyadav
 */
public class DateWrapper {

	/** The Date object date */
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
