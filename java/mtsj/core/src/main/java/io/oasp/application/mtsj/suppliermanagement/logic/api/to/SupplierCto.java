package io.oasp.application.mtsj.suppliermanagement.logic.api.to;

import io.oasp.application.mtsj.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Supplier
 */
public class SupplierCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private SupplierEto supplier;

  public SupplierEto getSupplier() {

    return supplier;
  }

  public void setSupplier(SupplierEto supplier) {

    this.supplier = supplier;
  }

}
