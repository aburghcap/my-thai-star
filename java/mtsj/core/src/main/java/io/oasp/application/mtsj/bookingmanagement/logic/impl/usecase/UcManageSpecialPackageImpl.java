package io.oasp.application.mtsj.bookingmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.mtsj.bookingmanagement.dataaccess.api.SpecialPackageEntity;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageEto;
import io.oasp.application.mtsj.bookingmanagement.logic.api.usecase.UcManageSpecialPackage;
import io.oasp.application.mtsj.bookingmanagement.logic.base.usecase.AbstractSpecialPackageUc;
import io.oasp.application.mtsj.general.common.api.constants.Roles;
import io.oasp.application.mtsj.general.logic.api.UseCase;

/**
 * Use case implementation for modifying and deleting SpecialPackages
 */
@Named
@UseCase
@Validated
@Transactional
public class UcManageSpecialPackageImpl extends AbstractSpecialPackageUc implements UcManageSpecialPackage {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageSpecialPackageImpl.class);

  @Override
  @RolesAllowed(Roles.WAITER)
  public boolean deleteSpecialPackage(Long specialPackageId) {

    SpecialPackageEntity specialPackage = getSpecialPackageDao().find(specialPackageId);
    getSpecialPackageDao().delete(specialPackage);
    LOG.debug("The specialPackage with id '{}' has been deleted.", specialPackageId);
    return true;
  }

  @Override
  @RolesAllowed(Roles.WAITER)
  public SpecialPackageEto saveSpecialPackage(SpecialPackageEto specialPackage) {

    Objects.requireNonNull(specialPackage, "specialPackage");

    SpecialPackageEntity specialPackageEntity = getBeanMapper().map(specialPackage, SpecialPackageEntity.class);

    // initialize, validate specialPackageEntity here if necessary
    SpecialPackageEntity resultEntity = getSpecialPackageDao().save(specialPackageEntity);
    LOG.debug("SpecialPackage with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, SpecialPackageEto.class);
  }
}
