package io.oasp.application.mtsj.bookingmanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.mtsj.bookingmanagement.dataaccess.api.dao.SpecialPackageDao;
import io.oasp.application.mtsj.general.logic.base.AbstractUc;

/**
 * Abstract use case for SpecialPackages, which provides access to the commonly necessary data access objects.
 */
public class AbstractSpecialPackageUc extends AbstractUc {

  /** @see #getSpecialPackageDao() */
  @Inject
  private SpecialPackageDao specialPackageDao;

  /**
   * Returns the field 'specialPackageDao'.
   * 
   * @return the {@link SpecialPackageDao} instance.
   */
  public SpecialPackageDao getSpecialPackageDao() {

    return this.specialPackageDao;
  }

}
