package com.hcentive.cinclearance.dclb;

import org.hx.commonservices.cinclearance.hbe.CinServiceException;
import org.hx.commonservices.cinclearance.request.CINClearanceRequest;
import org.hx.commonservices.cinclearance.response.CINClearanceResponse;

public interface CinClearanceBkpInterface {

	public abstract CINClearanceResponse getCINClearanceResults(CINClearanceRequest request) throws CinServiceException;
	public abstract CINClearanceResponse getHBECINClearanceResults(CINClearanceRequest request) throws CinServiceException;
	public abstract boolean verifyHBECinForActive(String cin, String nyhxMemberId);
}