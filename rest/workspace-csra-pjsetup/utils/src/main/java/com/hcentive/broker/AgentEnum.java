package com.hcentive.broker;


public enum AgentEnum {
	 BROKER,NAVIGATOR,APPLICATION_COUNSELOR,BOTH;
	
	public String toString(){
		switch(this){
			case BROKER :
				return "BROKER";
			case NAVIGATOR :
				return "NAVIGATOR";
			case APPLICATION_COUNSELOR:
				return "APPLICATION COUNSELOR";
			case BOTH :
				return "BOTH";
		}
		return null;
	}
		
		public static AgentEnum createAgentEnumFromString(String type){
			if(null!=type){
				for(AgentEnum v: AgentEnum.values()){
					if(v.toString().equalsIgnoreCase (type)){
						return v;
					}
				}
			}
			return null;
		}
}
