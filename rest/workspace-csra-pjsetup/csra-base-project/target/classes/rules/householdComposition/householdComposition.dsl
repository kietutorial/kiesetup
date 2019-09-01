[condition][]Load Eligibility object and get the list of members in household=$elg:Eligibility($memList:membersList);
[condition][]Loop through each member in the Member List=$member : Member() from $memList;
[condition][]If member is Primary Tax filer or Joint tax filer=eval($elg.getPublicProgram() && ((TaxRelationshipUtil.isPrimay($member) || TaxRelationshipUtil.isSpouse($member,$elg)) && !TaxRelationshipUtil.isDependentInHH($member,$elg)))
[consequence][]Create  the instance of MemberComposition=MemberComposition memberComposition = new MemberComposition();
[consequence][]Initialize the memberComposition count to zero=int counter=0;
[consequence][]Increment memberComposition count of the given member=counter++;
[consequence][]Set memberComposition count to MemberComposition of the Member=memberComposition.setMemberCompositionCount(counter);
[consequence][]If applicant  is pregnant increment count for each expected babies=counter = HouseholdCompositionUtil.pregnencyCheck($member, counter);
[consequence][]Loop through applicants all tax dependents and increment count for each dependents and dependents expected babies if any=HouseholdCompositionUtil.dependentsCheck($member, $elg, memberComposition,countedMembers);
[consequence][]If applicant has spouse and joint filer increment count for spouse and  expected babies if pregnant. If not joint filer increment count for spouse in case both live is same address=HouseholdCompositionUtil.spouseCheck($member, $elg, memberComposition, countedMembers);
[consequence][]Set member to memberComposition=memberComposition.setMember($member);
[consequence][]Set eligibility to memberComposition=memberComposition.setEligibility($elg);
[consequence][]Get MemberComposition list from eligibility=List<MemberComposition>elgMemberCompList =  $elg.getMemberCompositionList();
[consequence][]If eligibility memberCompositionList is null=if(elgMemberCompList == null)\{
[consequence][]Initialize the eligibility memberCompositionList=elgMemberCompList = new ArrayList<MemberComposition>();
[consequence][]End If=\}
[consequence][]Add memberComposition to eligibilityMemberCompositionList=elgMemberCompList.add(memberComposition);
[consequence][]DISPLAY  RULE OUTPUT=System.out.println("Count for Member "+$member.getId()+"is -->"+memberComposition.getMemberCompositionCount());
[consequence][]Initialize memberComposition list=memberCompList =  new ArrayList<MemberComposition>();
[consequence][]Add memberComposition to memberCompositionList=memberCompList.add(memberComposition);
[consequence][]Set memberCompositionList to the member=$member.setMemberCompositionList(memberCompList);
[consequence][]Set memberCompositionList to eligibility=$elg.setMemberCompositionList(elgMemberCompList);
[consequence][]Set memberComposition type as subsidized=memberComposition.setTypeCode(HXConstants.MEMBER_HH_COMPOSITION_TYPE_SUBSIDIZED);
[condition][]If Applicant is Tax Dependent and claimed by custodial parent=eval($elg.getPublicProgram() && TaxRelationshipUtil.isDependentInHH($member,$elg) && HouseholdCompositionUtil.isClaimedByCustodialParent($member,$elg))
[consequence][]Initialize countedMembers list=List<Long> countedMembers = new ArrayList<Long>();
[consequence][]If dependents living with both the parents and not joint-filers then include non-custodial parent in composition of the member=HouseholdCompositionUtil.dependentNonCustodialParentsCheck($member, $elg, memberComposition,countedMembers);
[consequence][]Get primary filer for the member=Member primaryMember = TaxRelationshipUtil.getPrimay($member, $elg);
[consequence][]If PrimaryMember available for the given member=if (primaryMember != null)\{
[consequence][]Get memberCompositionDetails from memberComposition=List<MemberCompositionDetails> memberCompDtlsList = memberComposition.getMemberCompositionDtls();
[consequence][]Initialize the instance of MemberCompositionDetails=MemberCompositionDetails memberCompDtls = new MemberCompositionDetails();
[consequence][]If memberCompositionDetails List is null=if (memberCompDtlsList == null)\{
[consequence][]Initialize the memberCompositionDetails list=memberCompDtlsList = new ArrayList<MemberCompositionDetails>();
[consequence][]Set variable counter with memberComposition count=counter = memberComposition.getMemberCompositionCount();
[consequence][]If primary member is not counted in the composition of the applicant=if(!HouseholdCompositionUtil.isMemberAlreadyCounted(primaryMember.getId(),countedMembers))\{
[consequence][]Set counted member to the checklist=countedMembers.add(primaryMember.getId());
[consequence][]Set memberComposition to memberCompositionDetails of applicant=memberCompDtls.setMemberComposition(memberComposition);
[*][]Set primary member to the memberCompositionDetails of applicant=memberCompDtls.setSecondaryMember(primaryMember);
[consequence][]Set memberCompositionDetails to memberCompositionDetailsList=memberCompDtlsList.add(memberCompDtls);
[consequence][]Set memberCompositionCount to the memberComposition of the applicant=memberComposition.setMemberCompositionCount(counter);
[consequence][]Set memberCompositionDetailsList to memberComposition of the applicant=memberComposition.setMemberCompositionDtls(memberCompDtlsList);
[consequence][]If primary tax filer is pregnant include number of expected babies to the count of applicant=counter = HouseholdCompositionUtil.pregnencyCheck(primaryMember, counter);
[condition][]If Applicant is dependant and not claimed by spouse or custodial parent=eval($elg.getPublicProgram() && TaxRelationshipUtil.isDependentInHH($member,$elg)  && !HouseholdCompositionUtil.isClaimedByCustodialParent($member,$elg))
[consequence][]If Applicants age less than {age}=if($member.getAge() < new Integer({age}).intValue())\{
[*][]Loop through all of applicants children and increment composition count of the applicant for each children and expected babies=HouseholdCompositionUtil.performCheckByRelationType($member, $elg, memberComposition, HXConstants.RELATION_TYPE_CHILD, countedMembers);
[consequence][]Loop through all of applicants parents and increment composition count of the applicant for each Parent and expected babies=HouseholdCompositionUtil.performCheckByRelationType($member, $elg, memberComposition, HXConstants.RELATION_TYPE_PARENT, countedMembers);
[consequence][]Loop through all of applicants siblings and increment composition count of the applicant for each Sibling and expected babies=HouseholdCompositionUtil.performCheckByRelationType($member, $elg, memberComposition, HXConstants.RELATION_TYPE_SIBLING, countedMembers);
[consequence][]Else If Applicant age is {age} or {age1}=\}else if($member.getAge() == new Integer({age}).intValue() || $member.getAge() == new Integer({age1}).intValue())\{
[consequence][]If applicant is fulltime student=if(HXConstants.MEMBER_HH_FULLTIME_STUDENT_TRUE.equals($member.getIsFullTimeStudent()))\{
[consequence][]Else if applicant is not fulltime student=\}else\{
[consequence][]Else If applicants age is greater than or equal to {age}=\}else if($member.getAge() >= new Integer({age}).intValue())\{
[consequence][]Set added member to the checkList=countedMembers.add($member.getId());
[consequence][]If applicant has spouse increment count for spouse and expected babies if spouse is pregnant=HouseholdCompositionUtil.spouseCheck($member, $elg, memberComposition, countedMembers);
[consequence][]If applicant is pregnant increment count for each expected babies=counter = HouseholdCompositionUtil.pregnencyCheck($member, counter);
[consequence][]Loop through all tax dependents of primary tax filer and increment the count each dependents and dependents  expected babies if any=HouseholdCompositionUtil.dependentsCheck(primaryMember, $elg, memberComposition, countedMembers);
[consequence][]If primary tax filer has spouse and joint filer increment count for spouse and  expected babies if pregnant. If not joint filer increment count for spouse in case both live is same address=HouseholdCompositionUtil.spouseCheck(primaryMember, $elg, memberComposition, countedMembers);
[condition][]If applicant is  neither tax dependent nor taxfiler=eval(($elg.getPublicProgram() ) && (!TaxRelationshipUtil.isPrimay($member) && !TaxRelationshipUtil.isSpouse($member,$elg) && !TaxRelationshipUtil.isDependentInHH($member,$elg)))
[consequence][]STARTING RULE {RuleName} FOR MEMBER=logger.debug("Rule :"+ {RuleName} +" : Begin For Member "+$member.getId());
[consequence][]ENDING RULE {RuleName} FOR MEMBER=logger.debug("Rule :"+ {RuleName} +"For Member "+$member.getId() +"AND MEMBER COMP COUNT IS :"+memberComposition.getMemberCompositionCount() +" AND APTC MEMBER COMP COUNT IS :"+memberComposition.getAptcMemberCompositionCount());
[condition][]Get subscriber=$member : Member(getIsPrimaryApplicant().equals(Boolean.TRUE)) from $memList;
[consequence][]Set memberComposition type as Unsubsidized=memberComposition.setTypeCode(HXConstants.MEMBER_HH_COMPOSITION_TYPE_UNSUBSIDIZED);
[consequence][]Loop for each member with insurable relation and seeking coverage in the household and increment the composition count for subscriber=HouseholdCompositionUtil.isInsurableRelWithSubscriber($member, $elg, memberComposition,  countedMembers);
[condition][]If applicant seeking coverage=eval($member.getApplying())
[consequence][]Get memberCompositionList for the applicant=List<MemberComposition> memberCompList =  $member.getMemberCompositionList();
[consequence][]If memberCompositionlist is null=if(memberCompList == null)\{
[consequence][]If applicant has demographic spouse increment count for spouse and expected babies if spouse is pregnant=HouseholdCompositionUtil.demoGraphicSpouseCheck($member, $elg, memberComposition, countedMembers);
[consequence][]Initialize the APTC memberComposition count to zero=int aptcCounter = 0;
[consequence][]Increment APTC memberComposition count of the given member=aptcCounter++;
[consequence][]Set APTC memberComposition count to MemberComposition of the Member=memberComposition.setAptcMemberCompositionCount(aptcCounter);
[consequence][]Set APTC memberCompositionCount to the memberComposition of the applicant=memberComposition.setAptcMemberCompositionCount(aptcCounter);
[consequence][]Set variable counter with APTC memberComposition count=aptcCounter = memberComposition.getAptcMemberCompositionCount();
