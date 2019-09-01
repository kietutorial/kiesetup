[condition][]Load IncomeCalculation object=$incomeCalc:IncomeCalculation($amt:incomeAmount);
[condition][]Check IncomeCalculation object and Income Amount is not empty=eval($incomeCalc != null && $amt != null)
[consequence][]Begin rule {ruleName}=logger.debug("Begin Rule :"+{ruleName});
[consequence][]End rule {ruleName}=logger.debug("End Rule :"+{ruleName});
[consequence][]Initialize minRange=double minRange = 0;
[consequence][]Initialize maxRange=double maxRange = 0;
[consequence][]Set minRange to IncomeCalculation=$incomeCalc.setMinRangeAmount(new Double(minRange));
[consequence][]Set maxRange to IncomeCalculation=$incomeCalc.setMaxRangeAmount(new Double(maxRange));
[consequence][]Calculate minRange=minRange = $amt - ($amt * 10/100);
[consequence][]Calculate maxRange=maxRange = $amt + ($amt * 10/100);
