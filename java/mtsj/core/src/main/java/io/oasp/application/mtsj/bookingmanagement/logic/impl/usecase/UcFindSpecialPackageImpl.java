package io.oasp.application.mtsj.bookingmanagement.logic.impl.usecase;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.mtsj.bookingmanagement.dataaccess.api.SpecialPackageEntity;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageEto;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageSearchCriteriaTo;
import io.oasp.application.mtsj.bookingmanagement.logic.api.usecase.UcFindSpecialPackage;
import io.oasp.application.mtsj.bookingmanagement.logic.base.usecase.AbstractSpecialPackageUc;
import io.oasp.application.mtsj.general.common.api.constants.Roles;
import io.oasp.application.mtsj.general.logic.api.UseCase;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting SpecialPackages
 */
@Named
@UseCase
@Validated
@Transactional
public class UcFindSpecialPackageImpl extends AbstractSpecialPackageUc implements UcFindSpecialPackage {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindSpecialPackageImpl.class);

  @Override
  @RolesAllowed(Roles.WAITER)
  public SpecialPackageEto findSpecialPackage(Long id) {

    LOG.debug("Get SpecialPackage with id {} from database.", id);
    return getBeanMapper().map(getSpecialPackageDao().findOne(id), SpecialPackageEto.class);
  }

  @Override
  @RolesAllowed(Roles.WAITER)
  public PaginatedListTo<SpecialPackageEto> findSpecialPackageEtos(SpecialPackageSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<SpecialPackageEntity> specialpackages = getSpecialPackageDao().findSpecialPackages(criteria);
    return mapPaginatedEntityList(specialpackages, SpecialPackageEto.class);
  }

}
