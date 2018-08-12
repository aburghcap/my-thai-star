package io.oasp.application.mtsj.bookingmanagement.logic.api.to;

import io.oasp.application.mtsj.bookingmanagement.common.api.PackagePerson;
import io.oasp.application.mtsj.general.common.api.to.AbstractEto;

/**
 * Entity transport object of PackagePerson
 */
public class PackagePersonEto extends AbstractEto implements PackagePerson {

  private static final long serialVersionUID = 1L;

  private int minPerson;

  private int maxPerson;

  @Override
  public int getMinPerson() {

    return minPerson;
  }

  @Override
  public void setMinPerson(int minPerson) {

    this.minPerson = minPerson;
  }

  @Override
  public int getMaxPerson() {

    return maxPerson;
  }

  @Override
  public void setMaxPerson(int maxPerson) {

    this.maxPerson = maxPerson;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((Integer) minPerson).hashCode();
    result = prime * result + ((Integer) maxPerson).hashCode();
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
    PackagePersonEto other = (PackagePersonEto) obj;
    if (this.minPerson != other.minPerson) {
      return false;
    }
    if (this.maxPerson != other.maxPerson) {
      return false;
    }
    return true;
  }
}
