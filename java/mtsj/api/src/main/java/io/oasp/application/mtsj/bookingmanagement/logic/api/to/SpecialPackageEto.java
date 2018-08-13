package io.oasp.application.mtsj.bookingmanagement.logic.api.to;

import io.oasp.application.mtsj.bookingmanagement.common.api.PackagePerson;
import io.oasp.application.mtsj.bookingmanagement.common.api.SpecialPackage;
import io.oasp.application.mtsj.general.common.api.to.AbstractEto;

/**
 * Entity transport object of SpecialPackage
 */
public class SpecialPackageEto extends AbstractEto implements SpecialPackage {

  private static final long serialVersionUID = 1L;

  private String name;

  private Long offerId;

  private PackagePersonEto packagePerson;

  private String specialPrice;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public Long getOfferId() {

    return this.offerId;
  }

  @Override
  public void setOfferId(Long offerId) {

    this.offerId = offerId;
  }

  public PackagePerson getPackagePerson() {

    return this.packagePerson;
  }

  public void setPackagePerson(PackagePerson packagePerson) {

    this.packagePerson = (PackagePersonEto) packagePerson;
  }

  @Override
  public String getSpecialPrice() {

    return this.specialPrice;
  }

  @Override
  public void setSpecialPrice(String specialPrice) {

    this.specialPrice = specialPrice;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());

    result = prime * result + ((this.offerId == null) ? 0 : this.offerId.hashCode());
    result = prime * result + ((this.packagePerson == null) ? 0 : this.packagePerson.hashCode());
    result = prime * result + ((this.specialPrice == null) ? 0 : this.specialPrice.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    SpecialPackageEto other = (SpecialPackageEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }

    if (this.offerId == null) {
      if (other.offerId != null) {
        return false;
      }
    } else if (!this.offerId.equals(other.offerId)) {
      return false;
    }
    if (this.packagePerson == null) {
      if (other.packagePerson != null) {
        return false;
      }
    } else if (!this.packagePerson.equals(other.packagePerson)) {
      return false;
    }
    if (this.specialPrice == null) {
      if (other.specialPrice != null) {
        return false;
      }
    } else if (!this.specialPrice.equals(other.specialPrice)) {
      return false;
    }
    return true;
  }
}
