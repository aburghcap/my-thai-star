package io.oasp.application.mtsj.bookingmanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.mtsj.bookingmanagement.common.api.PackagePerson}s.
 *
 */
public class PackagePersonSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Integer minPerson;

  private Integer maxPerson;

  /**
   * The constructor.
   */
  public PackagePersonSearchCriteriaTo() {

    super();
  }

  public int getMinPerson() {

    return minPerson;
  }

  public void setMinPerson(int minPerson) {

    this.minPerson = minPerson;
  }

  public int getMaxPerson() {

    return maxPerson;
  }

  public void setMaxPerson(int maxPerson) {

    this.maxPerson = maxPerson;
  }

}
