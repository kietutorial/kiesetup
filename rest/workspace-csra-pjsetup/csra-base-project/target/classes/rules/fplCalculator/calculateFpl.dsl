[condition][]Load FplCalculatorFacts=$fplFacts:FplCalculatorFacts(hhCount:hhMemberCompositionCount,hhIncome:hhMemberIncome);
[condition][]If household count not null and greater than zero and householdIncome is not null=eval(hhCount != null && hhCount > 0 && hhIncome != null)
[consequence][]Begin rule {ruleName}=logger.debug("Rule :"+{ruleName} +" : Begin");
[consequence][]End rule {ruleName}=logger.debug("Rule :"+{ruleName} +" : End");
[consequence][]Call rule agenda {ruleAgenda}=drools.setFocus({ruleAgenda});
[condition][]Get FplCalculatorFacts for household count {count}=$fplFacts:FplCalculatorFacts(hhCount:hhMemberCompositionCount == {count},hhIncome:hhMemberIncome);
[consequence][]Set variable fpl to zero=double fpl = 0;
[consequence][]Set decimal size to two=DecimalFormat twoDForm = new DecimalFormat("#.##");
[consequence][]Set fplIncome for {limit}=Double fplIncomeThreshold = fplConfigTable.getValueFor(RuleKey.{limit});
[consequence][]Calculate FPL=fpl = (hhIncome / fplIncomeThreshold)*100;
[consequence][]Set fpl to FplCalculatorFacts=$fplFacts.setHhMemberFplPercent(new Double(twoDForm.format(fpl)));
[condition][]Initialize FplCalculatorFacts for household count is greater than {count}=$fplFacts:FplCalculatorFacts(hhCount:hhMemberCompositionCount > {count},hhIncome:hhMemberIncome);
[consequence][]Add {addlAmt} for each additional person to lifeLevelIncomeThreshold  of {amt}=Double fplIncomeThreshold =fplConfigTable.getValueFor(RuleKey.{amt}) +((hhCount - 8)* fplConfigTable.getValueFor(RuleKey.{addlAmt}));
