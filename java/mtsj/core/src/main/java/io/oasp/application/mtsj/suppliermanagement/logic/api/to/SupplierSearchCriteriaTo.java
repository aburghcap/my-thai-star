package io.oasp.application.mtsj.suppliermanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.mtsj.suppliermanagement.common.api.Supplier}s.
 *
 */
public class SupplierSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private Integer rate;

  /**
   * The constructor.
   */
  public SupplierSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(String description) {

    this.description = description;
  }

  public Integer getRate() {

    return rate;
  }

  public void setRate(Integer rate) {

    this.rate = rate;
  }

}
