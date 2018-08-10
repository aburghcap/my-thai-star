package io.oasp.application.mtsj.bookingmanagement.dataaccess.api;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.oasp.application.mtsj.bookingmanagement.common.api.PackagePerson;

@Embeddable
public class PackagePersonEmbeddable implements PackagePerson {

  private int minPerson;

  private int maxPerson;

  private static final long serialVersionUID = 1L;

  /**
   * @return minPerson
   */
  @Max(24)
  @Min(0)
  public int getMinPerson() {

    return this.minPerson;
  }

  /**
   * @param minPerson new value of {@link #getminPerson}.
   */
  public void setMinPerson(int minPerson) {

    this.minPerson = minPerson;
  }

  /**
   * @return maxPerson
   */
  @Max(24)
  @Min(0)
  public int getMaxPerson() {

    return this.maxPerson;
  }

  /**
   * @param maxPerson new value of {@link #getmaxPerson}.
   */
  public void setMaxPerson(int maxPerson) {

    this.maxPerson = maxPerson;
  }

}
