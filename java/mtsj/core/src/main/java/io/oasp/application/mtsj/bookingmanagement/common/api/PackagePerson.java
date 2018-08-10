package io.oasp.application.mtsj.bookingmanagement.common.api;

/**
 * Common interface for PackagePersonEmbeddable.
 */
public interface PackagePerson {

  /**
   * Returns the field minPerson.
   *
   * @return the field minPerson.
   */
  int getMinPerson();

  /**
   * Sets the new value for the field minPerson.
   * 
   * @param minPerson new value for the field minPerson.
   */
  void setMinPerson(int minPerson);

  /**
   * Returns the field maxPerson.
   *
   * @return the field maxPerson.
   */
  int getMaxPerson();

  /**
   * Sets the new value for the field maxPerson.
   * 
   * @param maxPerson new value for the field maxPerson.
   */
  void setMaxPerson(int maxPerson);

}
