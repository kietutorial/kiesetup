package com.hcentive.shop.dto;

public class EmployerContributionDTO {

	public EmployerContributionDTO(Object[] resultColumns) {
		this.setId((Integer) resultColumns[0]);
		this.setCoverageTier((String) resultColumns[1]);
		this.setContributionPercentage(processDouble(resultColumns[2]));
		this.setContributionAbsolute(processDouble(resultColumns[3]));
	}
	
	private int id;
	private String coverageTier;
	private Double contributionPercentage;
	private Double contributionAbsolute;
	public int getId() {
		return id;
	}
	public String getCoverageTier() {
		return coverageTier;
	}
	public Double getContributionPercentage() {
		return contributionPercentage;
	}
	public Double getContributionAbsolute() {
		return contributionAbsolute;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCoverageTier(String coverageTier) {
		this.coverageTier = coverageTier;
	}
	public void setContributionPercentage(Double contributionPercentage) {
		this.contributionPercentage = contributionPercentage;
	}
	public void setContributionAbsolute(Double contributionAbsolute) {
		this.contributionAbsolute = contributionAbsolute;
	}
	public static Double processDouble( Object obj ){
	   	return obj == null ? null : new Double(obj.toString());
	}
}
