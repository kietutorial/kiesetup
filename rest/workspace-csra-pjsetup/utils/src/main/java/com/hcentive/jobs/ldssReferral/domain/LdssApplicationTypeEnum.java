package com.hcentive.jobs.ldssReferral.domain;

import java.util.List;

import com.hcentive.utils.ext.HXUtility;

public enum LdssApplicationTypeEnum {
	SURPLUS("HXSUR", 5), NURSINGHOME("HXLTC", 4), BLIND_AGEDISABLED("HXDAB", 3), FOSTERCARE("HXFOS", 2), RETRO("HXRET", 1), 
	HXNMD("HXNMD", 8), HXWMD("HXWMD", 7), HXNTX("HXNTX", 6); 

	private String name;

	private int rank;

	LdssApplicationTypeEnum(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}
	
	public String getTopRankAppType(List<LdssApplicationTypeEnum> appTypeList){
		String topRankAppType = "";
		if (!HXUtility.isEmpty(appTypeList)){
			int initRank = appTypeList.get(0).getRank();
			topRankAppType = "";
			if(appTypeList.size() == 1){
				return appTypeList.get(0).getName();
			}
			
			for (LdssApplicationTypeEnum appType : appTypeList){
				if (initRank < appType.getRank() ){
					topRankAppType = appType.getName();
					initRank =  appType.getRank();
				}
			}
		}
		return topRankAppType;
	}
	
	public boolean isUndercareReferral(String previousReferralType){
        boolean result = false;
        if(!HXUtility.isEmpty(previousReferralType) && (LdssApplicationTypeEnum.HXNMD.getName().equalsIgnoreCase(previousReferralType) 
                     || LdssApplicationTypeEnum.HXWMD.getName().equalsIgnoreCase(previousReferralType)
                     || LdssApplicationTypeEnum.HXNTX.getName().equalsIgnoreCase(previousReferralType))){
               result = true; 
        }
        return result;
 }
 
 public boolean isApplicationReferral(String previousReferralType){
        boolean result = false;
        if(!HXUtility.isEmpty(previousReferralType) && (LdssApplicationTypeEnum.SURPLUS.getName().equalsIgnoreCase(previousReferralType) 
                     || LdssApplicationTypeEnum.NURSINGHOME.getName().equalsIgnoreCase(previousReferralType)
                     || LdssApplicationTypeEnum.BLIND_AGEDISABLED.getName().equalsIgnoreCase(previousReferralType)
                     || LdssApplicationTypeEnum.FOSTERCARE.getName().equalsIgnoreCase(previousReferralType)
                     || LdssApplicationTypeEnum.RETRO.getName().equalsIgnoreCase(previousReferralType)
                     )){
               result = true; 
        }
        return result;
 }
 
 public static LdssApplicationTypeEnum getEnum(String name)
  {
	for( LdssApplicationTypeEnum apptype: LdssApplicationTypeEnum.values())
	{
		if(apptype.getName().equalsIgnoreCase(name))
		{
			return apptype;
		}
		
	}
	 return null;
		 
 }

}
