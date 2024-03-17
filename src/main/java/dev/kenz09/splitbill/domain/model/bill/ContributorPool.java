package dev.kenz09.splitbill.domain.model.bill;


import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContributorPool {
  private Map<String, Money> participantContributionMap;

  public Set<String> getContributors() {
    return participantContributionMap.keySet();
  }

  public Map<String, Money> getParticipantContributionMap() {
    HashMap<String,Money> participantContributionMapClone = new HashMap<>(participantContributionMap);
    return participantContributionMapClone;
  }

  public void addContribution(String participantID, Money contribution) {
    Money initialContribution = participantContributionMap.getOrDefault(participantID, Money.ofMajor(CurrencyUnit.USD, 0));
    participantContributionMap.put(participantID, initialContribution.plus(contribution));
  }

  public void decreaseContribution(String participantID, Money contribution) {
    Money initialContribution = participantContributionMap.getOrDefault(participantID, Money.ofMajor(CurrencyUnit.USD, 0));
    participantContributionMap.put(participantID, initialContribution.plus(contribution));
  }

  public Money getContribution(String participantID) {
    return participantContributionMap.getOrDefault(participantID, Money.ofMajor(CurrencyUnit.USD, 0));
  }
}
