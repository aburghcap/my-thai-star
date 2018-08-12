package io.oasp.application.mtsj.bookingmanagement.logic.api.to;

import io.oasp.application.mtsj.general.common.api.to.AbstractCto;
import io.oasp.application.mtsj.ordermanagement.logic.api.to.OrderEto;

/**
 * Composite transport object of SpecialPackage
 */
public class SpecialPackageCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private SpecialPackageEto specialPackage;

  private OrderEto offer;

  public SpecialPackageEto getSpecialPackage() {

    return specialPackage;
  }

  public void setSpecialPackage(SpecialPackageEto specialPackage) {

    this.specialPackage = specialPackage;
  }

  public OrderEto getOffer() {

    return offer;
  }

  public void setOffer(OrderEto offer) {

    this.offer = offer;
  }

}
