package io.oasp.application.mtsj.bookingmanagement.dataaccess.api.dao;

import io.oasp.application.mtsj.bookingmanagement.dataaccess.api.SpecialPackageEntity;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageSearchCriteriaTo;
import io.oasp.application.mtsj.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for SpecialPackage entities
 */
public interface SpecialPackageDao extends ApplicationDao<SpecialPackageEntity> {

  /**
   * Finds the {@link SpecialPackageEntity specialpackages} matching the given {@link SpecialPackageSearchCriteriaTo}.
   *
   * @param criteria is the {@link SpecialPackageSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link SpecialPackageEntity} objects.
   */
  PaginatedListTo<SpecialPackageEntity> findSpecialPackages(SpecialPackageSearchCriteriaTo criteria);
}
