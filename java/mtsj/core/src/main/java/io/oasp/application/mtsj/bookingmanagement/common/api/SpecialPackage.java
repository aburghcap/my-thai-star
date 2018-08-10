package io.oasp.application.mtsj.bookingmanagement.common.api;

import io.oasp.application.mtsj.general.common.api.ApplicationEntity;

public interface SpecialPackage extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public Long getOfferId();

  public void setOfferId(Long offerId);

  public PackagePerson getPackagePerson();

  public void setPackagePerson(PackagePerson packagePerson);

  public String getSpecialPrice();

  public void setSpecialPrice(String specialPrice);

}
