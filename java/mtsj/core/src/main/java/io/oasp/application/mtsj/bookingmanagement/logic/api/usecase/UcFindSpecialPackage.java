package io.oasp.application.mtsj.bookingmanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageEto;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindSpecialPackage {

  /**
   * Returns a SpecialPackage by its id 'id'.
   *
   * @param id The id 'id' of the SpecialPackage.
   * @return The {@link SpecialPackageEto} with id 'id'
   */
  SpecialPackageEto findSpecialPackage(Long id);

  /**
   * Returns a paginated list of SpecialPackages matching the search criteria.
   *
   * @param criteria the {@link SpecialPackageSearchCriteriaTo}.
   * @return the {@link List} of matching {@link SpecialPackageEto}s.
   */
  PaginatedListTo<SpecialPackageEto> findSpecialPackageEtos(SpecialPackageSearchCriteriaTo criteria);

}
