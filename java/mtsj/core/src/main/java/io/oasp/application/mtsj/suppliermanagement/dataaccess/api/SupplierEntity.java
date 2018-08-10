package io.oasp.application.mtsj.suppliermanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.application.mtsj.suppliermanagement.common.api.Supplier;

@Entity
@Table(name = "Supplier")
public class SupplierEntity extends ApplicationPersistenceEntity implements Supplier {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private int rate;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return description
   */
  public String getDescription() {

    return this.description;
  }

  /**
   * @param description new value of {@link #getdescription}.
   */
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return rate
   */
  public int getRate() {

    return this.rate;
  }

  /**
   * @param rate new value of {@link #getrate}.
   */
  public void setRate(int rate) {

    this.rate = rate;
  }

}
