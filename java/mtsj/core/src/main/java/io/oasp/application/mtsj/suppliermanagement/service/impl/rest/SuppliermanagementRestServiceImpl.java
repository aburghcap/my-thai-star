package io.oasp.application.mtsj.suppliermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.application.mtsj.suppliermanagement.logic.api.Suppliermanagement;
import io.oasp.application.mtsj.suppliermanagement.logic.api.to.SupplierCto;
import io.oasp.application.mtsj.suppliermanagement.logic.api.to.SupplierEto;
import io.oasp.application.mtsj.suppliermanagement.logic.api.to.SupplierSearchCriteriaTo;
import io.oasp.application.mtsj.suppliermanagement.service.api.rest.SuppliermanagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Suppliermanagement}.
 */
@Named("SuppliermanagementRestService")
public class SuppliermanagementRestServiceImpl implements SuppliermanagementRestService {

  @Inject
  private Suppliermanagement suppliermanagement;

  @Override
  public SupplierEto getSupplier(long id) {

    return this.suppliermanagement.findSupplier(id);
  }

  @Override
  public SupplierEto saveSupplier(SupplierEto supplier) {

    return this.suppliermanagement.saveSupplier(supplier);
  }

  @Override
  public void deleteSupplier(long id) {

    this.suppliermanagement.deleteSupplier(id);
  }

  @Override
  public PaginatedListTo<SupplierEto> findSuppliersByPost(SupplierSearchCriteriaTo searchCriteriaTo) {

    return this.suppliermanagement.findSupplierEtos(searchCriteriaTo);
  }

  @Override
  public SupplierCto getSupplierCto(long id) {

    return this.suppliermanagement.findSupplierCto(id);
  }

  @Override
  public PaginatedListTo<SupplierCto> findSupplierCtosByPost(SupplierSearchCriteriaTo searchCriteriaTo) {

    return this.suppliermanagement.findSupplierCtos(searchCriteriaTo);
  }
}