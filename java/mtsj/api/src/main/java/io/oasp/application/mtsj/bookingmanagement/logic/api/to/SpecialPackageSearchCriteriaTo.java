package io.oasp.application.mtsj.bookingmanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.mtsj.bookingmanagement.common.api.SpecialPackage}s.
 *
 */
public class SpecialPackageSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private Long offerId;

  private PackagePersonSearchCriteriaTo packagePerson;

  private String specialPrice;

  /**
   * The constructor.
   */
  public SpecialPackageSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Long getOfferId() {

    return offerId;
  }

  public void setOfferId(Long offerId) {

    this.offerId = offerId;
  }

  public PackagePersonSearchCriteriaTo getPackagePerson() {

    return packagePerson;
  }

  public void setPackagePerson(PackagePersonSearchCriteriaTo packagePerson) {

    this.packagePerson = packagePerson;
  }

  public String getSpecialPrice() {

    return specialPrice;
  }

  public void setSpecialPrice(String specialPrice) {

    this.specialPrice = specialPrice;
  }

}
