package com.csra.eligibility.domain.entity.member;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberFacts implements java.io.Serializable {
	private static final long serialVersionUID = 734193560416019901L;
	private boolean stale;
	private boolean requestingFinanceHelp; // FA
	private boolean newbornNoShow;
	private boolean renewalPeriodPast;
	private boolean epAptcClockExpired;
	private double fpl;
	private double maFplLevelforThisMember;
	private double irsFPL;
	private double lif;
	private boolean lifIndicator;
	private Date lifDate;
	private boolean parentCareTaker;
	private boolean careTakerRelative;
	private boolean enrolledInMedcaidMEC;
	private boolean allMECInfoEntered;
	private boolean proposedRun;
	private boolean proposedEligibility;
	private boolean lsc;
	private boolean lscInLastThreeMonths;
	private boolean standardIncomeInPrevElg;
	private boolean dtfIncomeInPrevElg;
	private boolean irsIncomeInPrevElg;
	private boolean noIncomeInPrevElg;
	private boolean pregnant;
	private boolean residualPrucolY;
	private boolean maDeemedNB;
	private boolean incomeVerifeid;
	private boolean compitableIncomeSourcesAvailable;
	private boolean incomeOnlyFromUIB;
	private boolean incomeReasonblyCompitable;
	private boolean incomeReasonblyCompitable10;
	private boolean dtfIncomeAtMALevel;
	private boolean zeroHHIncome;
	private boolean currentMonthIncomeToBeUsed;
	private boolean incomeVerificationNoticeSent;
	private boolean incomeClockExpired;
	private boolean incomeClockCode41;
	private boolean currentIncomeVerificationNoticeSent;
	private boolean currentIncomeClockExpired;
	private boolean ffsOnlyIndicator;
	private boolean undoc;
	private boolean hxRestrictedY;
	private boolean incomeClockSheduled;
	private boolean medicaidIncomeClockSheduled;
	private boolean medicaidAliessaInd;
	private boolean hasChildDependent;
	private boolean parent;
	private boolean livingWithParentOrCaretaker; // Includes living with parent
	private boolean currentlyInMedicaid;
	private boolean renewalDueUpcomingMonth;
	private boolean ineligible;
	private boolean eligible;
	private boolean pending;
	private Set<String> ineligibleReason = new HashSet<String>();
	private Map<String, Boolean> indicators = new HashMap<String, Boolean>();
	private String firstName;
	private String lastName;
	private String fullName;
	private Date dob;
	private int age;
	private String incomeType;
	private double houseHoldIncome;
	private boolean previousStandard;
	private boolean previousDataSource;
	private boolean previousNoIncome;
	private boolean incomeVerificationComplete;
	private boolean dsIncomeAtMALevel;
	private boolean useCurrentIncome;
	private boolean nonCompilanceIndator;
	private List<String> processFlow = new LinkedList<String>();

	public MemberFacts() {
	}

	public MemberFacts(boolean stale, boolean requestingFinanceHelp, boolean newbornNoShow, boolean renewalPeriodPast,
			boolean epAptcClockExpired, double fpl, double maFplLevelforThisMember, double irsFPL, double lif,
			boolean parentCareTaker, boolean careTakerRelative, boolean enrolledInMedcaidMEC, boolean allMECInfoEntered,
			boolean proposedRun, boolean proposedEligibility, boolean lsc, boolean lscInLastThreeMonths,
			boolean standardIncomeInPrevElg, boolean dtfIncomeInPrevElg, boolean irsIncomeInPrevElg,
			boolean noIncomeInPrevElg, boolean pregnant, boolean residualPrucolY, boolean maDeemedNB,
			boolean incomeVerifeid, boolean compitableIncomeSourcesAvailable, boolean incomeOnlyFromUIB,
			boolean incomeReasonblyCompitable, boolean incomeReasonblyCompitable10, boolean dtfIncomeAtMALevel,
			boolean zeroHHIncome, boolean currentMonthIncomeToBeUsed, boolean incomeVerificationNoticeSent,
			boolean incomeClockExpired, boolean incomeClockCode41, boolean currentIncomeVerificationNoticeSent,
			boolean currentIncomeClockExpired, boolean ffsOnlyIndicator, boolean undoc, boolean hxRestrictedY,
			boolean incomeClockSheduled, boolean medicaidIncomeClockSheduled, boolean medicaidAliessaInd,
			boolean hasChildDependent, boolean parent, boolean livingWithParentOrCaretaker, boolean currentlyInMedicaid,
			boolean renewalDueUpcomingMonth, boolean ineligible, boolean eligible, boolean pending,
			Set<String> ineligibleReason, Map<String, Boolean> indicators, String firstName, String lastName,
			String fullName, Date dob, int age, String incomeType, double houseHoldIncome, boolean previousStandard,
			boolean previousDataSource, boolean previousNoIncome, boolean incomeVerificationComplete,
			boolean dsIncomeAtMALevel, boolean useCurrentIncome, boolean nonCompilanceIndator) {
		super();
		this.stale = stale;
		this.requestingFinanceHelp = requestingFinanceHelp;
		this.newbornNoShow = newbornNoShow;
		this.renewalPeriodPast = renewalPeriodPast;
		this.epAptcClockExpired = epAptcClockExpired;
		this.fpl = fpl;
		this.maFplLevelforThisMember = maFplLevelforThisMember;
		this.irsFPL = irsFPL;
		this.lif = lif;
		this.parentCareTaker = parentCareTaker;
		this.careTakerRelative = careTakerRelative;
		this.enrolledInMedcaidMEC = enrolledInMedcaidMEC;
		this.allMECInfoEntered = allMECInfoEntered;
		this.proposedRun = proposedRun;
		this.proposedEligibility = proposedEligibility;
		this.lsc = lsc;
		this.lscInLastThreeMonths = lscInLastThreeMonths;
		this.standardIncomeInPrevElg = standardIncomeInPrevElg;
		this.dtfIncomeInPrevElg = dtfIncomeInPrevElg;
		this.irsIncomeInPrevElg = irsIncomeInPrevElg;
		this.noIncomeInPrevElg = noIncomeInPrevElg;
		this.pregnant = pregnant;
		this.residualPrucolY = residualPrucolY;
		this.maDeemedNB = maDeemedNB;
		this.incomeVerifeid = incomeVerifeid;
		this.compitableIncomeSourcesAvailable = compitableIncomeSourcesAvailable;
		this.incomeOnlyFromUIB = incomeOnlyFromUIB;
		this.incomeReasonblyCompitable = incomeReasonblyCompitable;
		this.incomeReasonblyCompitable10 = incomeReasonblyCompitable10;
		this.dtfIncomeAtMALevel = dtfIncomeAtMALevel;
		this.zeroHHIncome = zeroHHIncome;
		this.currentMonthIncomeToBeUsed = currentMonthIncomeToBeUsed;
		this.incomeVerificationNoticeSent = incomeVerificationNoticeSent;
		this.incomeClockExpired = incomeClockExpired;
		this.incomeClockCode41 = incomeClockCode41;
		this.currentIncomeVerificationNoticeSent = currentIncomeVerificationNoticeSent;
		this.currentIncomeClockExpired = currentIncomeClockExpired;
		this.ffsOnlyIndicator = ffsOnlyIndicator;
		this.undoc = undoc;
		this.hxRestrictedY = hxRestrictedY;
		this.incomeClockSheduled = incomeClockSheduled;
		this.medicaidIncomeClockSheduled = medicaidIncomeClockSheduled;
		this.medicaidAliessaInd = medicaidAliessaInd;
		this.hasChildDependent = hasChildDependent;
		this.parent = parent;
		this.livingWithParentOrCaretaker = livingWithParentOrCaretaker;
		this.currentlyInMedicaid = currentlyInMedicaid;
		this.renewalDueUpcomingMonth = renewalDueUpcomingMonth;
		this.ineligible = ineligible;
		this.eligible = eligible;
		this.pending = pending;
		this.ineligibleReason = ineligibleReason;
		this.indicators = indicators;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.dob = dob;
		this.age = age;
		this.incomeType = incomeType;
		this.houseHoldIncome = houseHoldIncome;
		this.previousStandard = previousStandard;
		this.previousDataSource = previousDataSource;
		this.previousNoIncome = previousNoIncome;
		this.incomeVerificationComplete = incomeVerificationComplete;
		this.dsIncomeAtMALevel = dsIncomeAtMALevel;
		this.useCurrentIncome = useCurrentIncome;
		this.nonCompilanceIndator = nonCompilanceIndator;
	}

	private void setAgeFromDob(Calendar cdob) {
		Calendar today = Calendar.getInstance();
		cdob.setTime(dob);

		this.age = today.get(Calendar.YEAR) - cdob.get(Calendar.YEAR);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		if (fullName == null)
			fullName = firstName + " " + lastName;

		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;

		Calendar cdob = Calendar.getInstance();
		cdob.setTime(dob);

		setAgeFromDob(cdob);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isStale() {
		return stale;
	}

	public void setStale(boolean stale) {
		this.stale = stale;
	}

	public boolean isRequestingFinanceHelp() {
		return requestingFinanceHelp;
	}

	public void setRequestingFinanceHelp(boolean requestingFinanceHelp) {
		this.requestingFinanceHelp = requestingFinanceHelp;
	}

	public boolean isNewbornNoShow() {
		return newbornNoShow;
	}

	public void setNewbornNoShow(boolean newbornNoShow) {
		this.newbornNoShow = newbornNoShow;
	}

	public boolean isRenewalPeriodPast() {
		return renewalPeriodPast;
	}

	public void setRenewalPeriodPast(boolean renewalPeriodPast) {
		this.renewalPeriodPast = renewalPeriodPast;
	}

	public boolean isEpAptcClockExpired() {
		return epAptcClockExpired;
	}

	public void setEpAptcClockExpired(boolean epAptcClockExpired) {
		this.epAptcClockExpired = epAptcClockExpired;
	}

	public double getFpl() {
		return fpl;
	}

	public void setFpl(double fpl) {
		this.fpl = fpl;
	}

	public double getMaFplLevelforThisMember() {
		return maFplLevelforThisMember;
	}

	public void setMaFplLevelforThisMember(double maFplLevelforThisMember) {
		this.maFplLevelforThisMember = maFplLevelforThisMember;
	}

	public double getIrsFPL() {
		return irsFPL;
	}

	public void setIrsFPL(double irsFPL) {
		this.irsFPL = irsFPL;
	}

	public boolean isCareTakerRelative() {
		return careTakerRelative;
	}

	public void setCareTakerRelative(boolean isCareTakerRelative) {
		this.careTakerRelative = isCareTakerRelative;
	}

	public boolean isEnrolledInMedcaidMEC() {
		return enrolledInMedcaidMEC;
	}

	public void setEnrolledInMedcaidMEC(boolean enrolledInMedcaidMEC) {
		this.enrolledInMedcaidMEC = enrolledInMedcaidMEC;
	}

	public boolean isAllMECInfoEntered() {
		return allMECInfoEntered;
	}

	public void setAllMECInfoEntered(boolean allMECInfoEntered) {
		this.allMECInfoEntered = allMECInfoEntered;
	}

	public boolean isProposedRun() {
		return proposedRun;
	}

	public void setProposedRun(boolean proposedRun) {
		this.proposedRun = proposedRun;
	}

	public boolean isLsc() {
		return lsc;
	}

	public void setLsc(boolean lsc) {
		this.lsc = lsc;
	}

	public boolean isLscInLastThreeMonths() {
		return lscInLastThreeMonths;
	}

	public void setLscInLastThreeMonths(boolean lscInLastThreeMonths) {
		this.lscInLastThreeMonths = lscInLastThreeMonths;
	}

	public boolean isStandardIncomeInPrevElg() {
		return standardIncomeInPrevElg;
	}

	public void setStandardIncomeInPrevElg(boolean standardIncomeInPrevElg) {
		this.standardIncomeInPrevElg = standardIncomeInPrevElg;
	}

	public boolean isDtfIncomeInPrevElg() {
		return dtfIncomeInPrevElg;
	}

	public void setDtfIncomeInPrevElg(boolean dtfIncomeInPrevElg) {
		this.dtfIncomeInPrevElg = dtfIncomeInPrevElg;
	}

	public boolean isIrsIncomeInPrevElg() {
		return irsIncomeInPrevElg;
	}

	public void setIrsIncomeInPrevElg(boolean irsIncomeInPrevElg) {
		this.irsIncomeInPrevElg = irsIncomeInPrevElg;
	}

	public boolean isNoIncomeInPrevElg() {
		return noIncomeInPrevElg;
	}

	public void setNoIncomeInPrevElg(boolean noIncomeInPrevElg) {
		this.noIncomeInPrevElg = noIncomeInPrevElg;
	}

	public boolean isPregnant() {
		return pregnant;
	}

	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}

	public boolean isResidualPrucolY() {
		return residualPrucolY;
	}

	public void setResidualPrucolY(boolean residualPrucolY) {
		this.residualPrucolY = residualPrucolY;
	}

	public boolean isMaDeemedNB() {
		return maDeemedNB;
	}

	public void setMaDeemedNB(boolean maDeemedNB) {
		this.maDeemedNB = maDeemedNB;
	}

	public boolean isIncomeVerifeid() {
		return incomeVerifeid;
	}

	public void setIncomeVerifeid(boolean incomeVerifeid) {
		this.incomeVerifeid = incomeVerifeid;
	}

	public boolean isCompitableIncomeSourcesAvailable() {
		return compitableIncomeSourcesAvailable;
	}

	public void setCompitableIncomeSourcesAvailable(boolean compitableIncomeSourcesAvailable) {
		this.compitableIncomeSourcesAvailable = compitableIncomeSourcesAvailable;
	}

	public boolean isIncomeOnlyFromUIB() {
		return incomeOnlyFromUIB;
	}

	public void setIncomeOnlyFromUIB(boolean incomeOnlyFromUIB) {
		this.incomeOnlyFromUIB = incomeOnlyFromUIB;
	}

	public boolean isIncomeReasonblyCompitable() {
		return incomeReasonblyCompitable;
	}

	public void setIncomeReasonblyCompitable(boolean incomeReasonblyCompitable) {
		this.incomeReasonblyCompitable = incomeReasonblyCompitable;
	}

	public boolean isIncomeReasonblyCompitable10() {
		return incomeReasonblyCompitable10;
	}

	public void setIncomeReasonblyCompitable10(boolean incomeReasonblyCompitable10) {
		this.incomeReasonblyCompitable10 = incomeReasonblyCompitable10;
	}

	public boolean isDtfIncomeAtMALevel() {
		return dtfIncomeAtMALevel;
	}

	public void setDtfIncomeAtMALevel(boolean dtfIncomeAtMALevel) {
		this.dtfIncomeAtMALevel = dtfIncomeAtMALevel;
	}

	public boolean isZeroHHIncome() {
		return zeroHHIncome;
	}

	public void setZeroHHIncome(boolean zeroHHIncome) {
		this.zeroHHIncome = zeroHHIncome;
	}

	public boolean isCurrentMonthIncomeToBeUsed() {
		return currentMonthIncomeToBeUsed;
	}

	public void setCurrentMonthIncomeToBeUsed(boolean currentMonthIncomeToBeUsed) {
		this.currentMonthIncomeToBeUsed = currentMonthIncomeToBeUsed;
	}

	public boolean isIncomeVerificationNoticeSent() {
		return incomeVerificationNoticeSent;
	}

	public void setIncomeVerificationNoticeSent(boolean incomeVerificationNoticeSent) {
		this.incomeVerificationNoticeSent = incomeVerificationNoticeSent;
	}

	public boolean isIncomeClockExpired() {
		return incomeClockExpired;
	}

	public void setIncomeClockExpired(boolean incomeClockExpired) {
		this.incomeClockExpired = incomeClockExpired;
	}

	public boolean isCurrentIncomeVerificationNoticeSent() {
		return currentIncomeVerificationNoticeSent;
	}

	public void setCurrentIncomeVerificationNoticeSent(boolean currentIncomeVerificationNoticeSent) {
		this.currentIncomeVerificationNoticeSent = currentIncomeVerificationNoticeSent;
	}

	public boolean isCurrentIncomeClockExpired() {
		return currentIncomeClockExpired;
	}

	public void setCurrentIncomeClockExpired(boolean currentIncomeClockExpired) {
		this.currentIncomeClockExpired = currentIncomeClockExpired;
	}

	public boolean isFfsOnlyIndicator() {
		return ffsOnlyIndicator;
	}

	public void setFfsOnlyIndicator(boolean ffsOnlyIndicator) {
		this.ffsOnlyIndicator = ffsOnlyIndicator;
	}

	public boolean isUndoc() {
		return undoc;
	}

	public void setUndoc(boolean undoc) {
		this.undoc = undoc;
	}

	public boolean isHxRestrictedY() {
		return hxRestrictedY;
	}

	public void setHxRestrictedY(boolean hxRestrictedY) {
		this.hxRestrictedY = hxRestrictedY;
	}

	public boolean isIncomeClockSheduled() {
		return incomeClockSheduled;
	}

	public void setIncomeClockSheduled(boolean incomeClockSheduled) {
		this.incomeClockSheduled = incomeClockSheduled;
	}

	public boolean isMedicaidIncomeClockSheduled() {
		return medicaidIncomeClockSheduled;
	}

	public void setMedicaidIncomeClockSheduled(boolean medicaidIncomeClockSheduled) {
		this.medicaidIncomeClockSheduled = medicaidIncomeClockSheduled;
	}

	public boolean isMedicaidAliessaInd() {
		return medicaidAliessaInd;
	}

	public void setMedicaidAliessaInd(boolean medicaidAliessaInd) {
		this.medicaidAliessaInd = medicaidAliessaInd;
	}

	public boolean isHasChildDependent() {
		return hasChildDependent;
	}

	public void setHasChildDependent(boolean hasChildDependent) {
		this.hasChildDependent = hasChildDependent;
	}

	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}

	public boolean isLivingWithParentOrCaretaker() {
		return livingWithParentOrCaretaker;
	}

	public void setLivingWithParentOrCaretaker(boolean livingWithParentOrCaretaker) {
		this.livingWithParentOrCaretaker = livingWithParentOrCaretaker;
	}

	public boolean isCurrentlyInMedicaid() {
		return currentlyInMedicaid;
	}

	public void setCurrentlyInMedicaid(boolean currentlyInMedicaid) {
		this.currentlyInMedicaid = currentlyInMedicaid;
	}

	public boolean isRenewalDueUpcomingMonth() {
		return renewalDueUpcomingMonth;
	}

	public void setRenewalDueUpcomingMonth(boolean renewalDueUpcomingMonth) {
		this.renewalDueUpcomingMonth = renewalDueUpcomingMonth;
	}

	public boolean isIneligible() {
		return ineligible;
	}

	public void setIneligible(boolean ineligible) {
		this.ineligible = ineligible;
	}

	public boolean isEligible() {
		return eligible;
	}

	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public Set<String> getIneligibleReason() {
		return ineligibleReason;
	}

	public void setIneligibleReason(String reason) {
		if (reason != null)
			ineligibleReason.add(reason);
	}

	public Map<String, Boolean> getIndicators() {
		return indicators;
	}

	public void setIndicators(String key, boolean value) {
		if (key != null)
			indicators.put(key, value);
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public double getHouseHoldIncome() {
		return houseHoldIncome;
	}

	public void setHouseHoldIncome(double houseHoldIncome) {
		this.houseHoldIncome = houseHoldIncome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isPreviousStandard() {
		return previousStandard;
	}

	public void setPreviousStandard(boolean previousStandard) {
		this.previousStandard = previousStandard;
	}

	public boolean isPreviousDataSource() {
		return previousDataSource;
	}

	public void setPreviousDataSource(boolean previousDataSource) {
		this.previousDataSource = previousDataSource;
	}

	public boolean isPreviousNoIncome() {
		return previousNoIncome;
	}

	public void setPreviousNoIncome(boolean previousNoIncome) {
		this.previousNoIncome = previousNoIncome;
	}

	public boolean isProposedEligibility() {
		return proposedEligibility;
	}

	public void setProposedEligibility(boolean proposedEligibility) {
		this.proposedEligibility = proposedEligibility;
	}

	public boolean isIncomeVerificationComplete() {
		return incomeVerificationComplete;
	}

	public void setIncomeVerificationComplete(boolean incomeVerificationComplete) {
		this.incomeVerificationComplete = incomeVerificationComplete;
	}

	public boolean isDSIncomeAtMALevel() {
		return dsIncomeAtMALevel;
	}

	public void setDSIncomeAtMALevel(boolean dSIncomeAtMALevel) {
		dsIncomeAtMALevel = dSIncomeAtMALevel;
	}

	public boolean isUseCurrentIncome() {
		return useCurrentIncome;
	}

	public void setUseCurrentIncome(boolean useCurrentIncome) {
		this.useCurrentIncome = useCurrentIncome;
	}

	public boolean isNonCompilanceIndator() {
		return nonCompilanceIndator;
	}

	public void setNonCompilanceIndator(boolean nonCompilanceIndator) {
		this.nonCompilanceIndator = nonCompilanceIndator;
	}

	public double getLif() {
		return lif;
	}

	public void setLif(double lif) {
		this.lif = lif;
	}

	public boolean isIncomeClockCode41() {
		return incomeClockCode41;
	}

	public void setIncomeClockCode41(boolean incomeClockCode41) {
		this.incomeClockCode41 = incomeClockCode41;
	}

	public boolean isParentCareTaker() {
		return parentCareTaker;
	}

	public void setParentCareTaker(boolean isParentCareTaker) {
		this.parentCareTaker = isParentCareTaker;
	}

	public List<String> getProcessFlow() {
		return processFlow;
	}

	public void setProcessFlow(String process) {
		if (process != null)
			processFlow.add(process);
	}

	public boolean isLifIndicator() {
		return lifIndicator;
	}

	public void setLifIndicator(boolean lifIndicator) {
		this.lifIndicator = lifIndicator;
	}

	public Date getLifDate() {
		return lifDate;
	}

	public void setLifDate(Date lifDate) {
		this.lifDate = lifDate;
	}

	public String getReasonsAsString() {
		Set<String> ineligibleReason = getIneligibleReason();
		StringBuilder bld = new StringBuilder();
		int j = 1;
		for (String reason : ineligibleReason) {
			bld.append((j) + ":" + reason);
			if (j < ineligibleReason.size())
				bld.append(", ");
			j++;
		}

		return bld.toString();
	}

	public String getReasonsToString() {
		StringBuilder bld = new StringBuilder();
		bld.append("Reasons [");
		bld.append(getReasonsAsString());
		bld.append("]");

		return bld.toString();
	}

	public String getProcessFlows() {
		List<String> flow = getProcessFlow();
		StringBuilder bld = new StringBuilder();
		bld.append("Workflows [");
		int j = 1;
		for (String process : flow) {
			bld.append((j) + ": " + process);
			if (j < flow.size())
				bld.append(", ");
			j++;
		}

		bld.append("]");

		return bld.toString();
	}

	public String getIndicatorsAsString() {
		Map<String, Boolean> mindicators = getIndicators();
		StringBuilder bld = new StringBuilder();
		int j = 1;
		for (String key : mindicators.keySet()) {
			bld.append((j) + ". " + key + ":" + mindicators.get(key));
			if (j < mindicators.size())
				bld.append(", ");
			j++;
		}

		return bld.toString();
	}

	public String getIndicatorsToString() {
		StringBuilder bld = new StringBuilder();
		bld.append("Indicators [");
		bld.append(getIndicatorsAsString());
		bld.append("]");

		return bld.toString();
	}

	public String getCompleteToString() {
		return getReasonsToString() + ", " + getIndicatorsToString() + ", MemberFacts [stale=" + stale
				+ ", requestingFinanceHelp=" + requestingFinanceHelp + ", newbornNoShow=" + newbornNoShow
				+ ", renewalPeriodPast=" + renewalPeriodPast + ", epAptcClockExpired=" + epAptcClockExpired + ", fpl="
				+ fpl + ", maFplLevelforThisMember=" + maFplLevelforThisMember + ", irsFPL=" + irsFPL + ", lif=" + lif
				+ ", parentCareTaker=" + parentCareTaker + ", careTakerRelative=" + careTakerRelative
				+ ", enrolledInMedcaidMEC=" + enrolledInMedcaidMEC + ", allMECInfoEntered=" + allMECInfoEntered
				+ ", proposedRun=" + proposedRun + ", proposedEligibility=" + proposedEligibility + ", lsc=" + lsc
				+ ", lscInLastThreeMonths=" + lscInLastThreeMonths + ", standardIncomeInPrevElg="
				+ standardIncomeInPrevElg + ", dtfIncomeInPrevElg=" + dtfIncomeInPrevElg + ", irsIncomeInPrevElg="
				+ irsIncomeInPrevElg + ", noIncomeInPrevElg=" + noIncomeInPrevElg + ", pregnant=" + pregnant
				+ ", residualPrucolY=" + residualPrucolY + ", maDeemedNB=" + maDeemedNB + ", incomeVerifeid="
				+ incomeVerifeid + ", compitableIncomeSourcesAvailable=" + compitableIncomeSourcesAvailable
				+ ", incomeOnlyFromUIB=" + incomeOnlyFromUIB + ", incomeReasonblyCompitable="
				+ incomeReasonblyCompitable + ", incomeReasonblyCompitable10=" + incomeReasonblyCompitable10
				+ ", dtfIncomeAtMALevel=" + dtfIncomeAtMALevel + ", zeroHHIncome=" + zeroHHIncome
				+ ", currentMonthIncomeToBeUsed=" + currentMonthIncomeToBeUsed + ", incomeVerificationNoticeSent="
				+ incomeVerificationNoticeSent + ", incomeClockExpired=" + incomeClockExpired + ", incomeClockCode41="
				+ incomeClockCode41 + ", currentIncomeVerificationNoticeSent=" + currentIncomeVerificationNoticeSent
				+ ", currentIncomeClockExpired=" + currentIncomeClockExpired + ", ffsOnlyIndicator=" + ffsOnlyIndicator
				+ ", undoc=" + undoc + ", hxRestrictedY=" + hxRestrictedY + ", incomeClockSheduled="
				+ incomeClockSheduled + ", medicaidIncomeClockSheduled=" + medicaidIncomeClockSheduled
				+ ", medicaidAliessaInd=" + medicaidAliessaInd + ", hasChildDependent=" + hasChildDependent
				+ ", parent=" + parent + ", livingWithParentOrCaretaker=" + livingWithParentOrCaretaker
				+ ", currentlyInMedicaid=" + currentlyInMedicaid + ", renewalDueUpcomingMonth="
				+ renewalDueUpcomingMonth + ", ineligible=" + ineligible + ", eligible=" + eligible + ", pending="
				+ pending + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", dob="
				+ dob + ", age=" + age + ", incomeType=" + incomeType + ", houseHoldIncome=" + houseHoldIncome
				+ ", previousStandard=" + previousStandard + ", previousDataSource=" + previousDataSource
				+ ", previousNoIncome=" + previousNoIncome + ", incomeVerificationComplete="
				+ incomeVerificationComplete + ", dsIncomeAtMALevel=" + dsIncomeAtMALevel + ", useCurrentIncome="
				+ useCurrentIncome + ", nonCompilanceIndator=" + nonCompilanceIndator + ", lifIndicator=" + lifIndicator
				+ ", lifDate=" + lifDate + "]";
	}

	@Override
	public String toString() {
		return "MemberFacts [stale=" + stale + ", requestingFinanceHelp=" + requestingFinanceHelp + ", newbornNoShow="
				+ newbornNoShow + ", renewalPeriodPast=" + renewalPeriodPast + ", epAptcClockExpired="
				+ epAptcClockExpired + ", fpl=" + fpl + ", maFplLevelforThisMember=" + maFplLevelforThisMember
				+ ", irsFPL=" + irsFPL + ", lif=" + lif + ", parentCareTaker=" + parentCareTaker
				+ ", careTakerRelative=" + careTakerRelative + ", enrolledInMedcaidMEC=" + enrolledInMedcaidMEC
				+ ", allMECInfoEntered=" + allMECInfoEntered + ", proposedRun=" + proposedRun + ", proposedEligibility="
				+ proposedEligibility + ", lsc=" + lsc + ", lscInLastThreeMonths=" + lscInLastThreeMonths
				+ ", standardIncomeInPrevElg=" + standardIncomeInPrevElg + ", dtfIncomeInPrevElg=" + dtfIncomeInPrevElg
				+ ", irsIncomeInPrevElg=" + irsIncomeInPrevElg + ", noIncomeInPrevElg=" + noIncomeInPrevElg
				+ ", pregnant=" + pregnant + ", residualPrucolY=" + residualPrucolY + ", maDeemedNB=" + maDeemedNB
				+ ", incomeVerifeid=" + incomeVerifeid + ", compitableIncomeSourcesAvailable="
				+ compitableIncomeSourcesAvailable + ", incomeOnlyFromUIB=" + incomeOnlyFromUIB
				+ ", incomeReasonblyCompitable=" + incomeReasonblyCompitable + ", incomeReasonblyCompitable10="
				+ incomeReasonblyCompitable10 + ", dtfIncomeAtMALevel=" + dtfIncomeAtMALevel + ", zeroHHIncome="
				+ zeroHHIncome + ", currentMonthIncomeToBeUsed=" + currentMonthIncomeToBeUsed
				+ ", incomeVerificationNoticeSent=" + incomeVerificationNoticeSent + ", incomeClockExpired="
				+ incomeClockExpired + ", incomeClockCode41=" + incomeClockCode41
				+ ", currentIncomeVerificationNoticeSent=" + currentIncomeVerificationNoticeSent
				+ ", currentIncomeClockExpired=" + currentIncomeClockExpired + ", ffsOnlyIndicator=" + ffsOnlyIndicator
				+ ", undoc=" + undoc + ", hxRestrictedY=" + hxRestrictedY + ", incomeClockSheduled="
				+ incomeClockSheduled + ", medicaidIncomeClockSheduled=" + medicaidIncomeClockSheduled
				+ ", medicaidAliessaInd=" + medicaidAliessaInd + ", hasChildDependent=" + hasChildDependent
				+ ", parent=" + parent + ", livingWithParentOrCaretaker=" + livingWithParentOrCaretaker
				+ ", currentlyInMedicaid=" + currentlyInMedicaid + ", renewalDueUpcomingMonth="
				+ renewalDueUpcomingMonth + ", ineligible=" + ineligible + ", eligible=" + eligible + ", pending="
				+ pending + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", dob="
				+ dob + ", age=" + age + ", incomeType=" + incomeType + ", houseHoldIncome=" + houseHoldIncome
				+ ", previousStandard=" + previousStandard + ", previousDataSource=" + previousDataSource
				+ ", previousNoIncome=" + previousNoIncome + ", incomeVerificationComplete="
				+ incomeVerificationComplete + ", dsIncomeAtMALevel=" + dsIncomeAtMALevel + ", useCurrentIncome="
				+ useCurrentIncome + ", nonCompilanceIndator=" + nonCompilanceIndator + ", lifIndicator=" + lifIndicator
				+ ", lifDate=" + lifDate + "]";
	}

}
