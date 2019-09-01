[condition][]Load IncomeCalculation object=$incomeCalc:IncomeCalculation($amt:incomeAmount);
[condition][]Check IncomeCalculation object  Income Amount and AttestedIncome is not empty=eval($incomeCalc != null && $amt != null && $incomeCalc.getAttestedIncome() != null)
[consequence][]Begin rule {ruleName}=logger.debug("Begin Rule :"+{ruleName});
[consequence][]End rule {ruleName}=logger.debug("End Rule :"+{ruleName});
[consequence][]Initialize minRange=double minRange = 0;
[consequence][]Initialize maxRange=double maxRange = 0;
[consequence][]Set  income is within range=$incomeCalc.setIsWithinRange(rangeFlag);
[consequence][]Calculate minRange=minRange = $amt - ($amt * 10/100);
[consequence][]Calculate maxRange=maxRange = $amt + ($amt * 10/100);
[consequence][]If attested income is within max and min range=if (aIncome >= minRange)\{
[consequence][]End If=\}
[consequence][]Initialize rangeFlag to False=Boolean rangeFlag = Boolean.FALSE;
[consequence][]Set rangeFlag to true=rangeFlag = Boolean.TRUE;
[consequence][]Set attested income to aIncome=double aIncome = $incomeCalc.getAttestedIncome().doubleValue();
