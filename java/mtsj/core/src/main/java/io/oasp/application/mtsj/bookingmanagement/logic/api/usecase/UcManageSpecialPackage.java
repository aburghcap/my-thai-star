package io.oasp.application.mtsj.bookingmanagement.logic.api.usecase;

import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageEto;

/**
 * Interface of UcManageSpecialPackage to centralize documentation and signatures of methods.
 */
public interface UcManageSpecialPackage {

  /**
   * Deletes a specialPackage from the database by its id 'specialPackageId'.
   *
   * @param specialPackageId Id of the specialPackage to delete
   * @return boolean <code>true</code> if the specialPackage can be deleted, <code>false</code> otherwise
   */
  boolean deleteSpecialPackage(Long specialPackageId);

  /**
   * Saves a specialPackage and store it in the database.
   *
   * @param specialPackage the {@link SpecialPackageEto} to create.
   * @return the new {@link SpecialPackageEto} that has been saved with ID and version.
   */
  SpecialPackageEto saveSpecialPackage(SpecialPackageEto specialPackage);

}
