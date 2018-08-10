package io.oasp.application.mtsj.suppliermanagement.logic.api.to;

import io.oasp.application.mtsj.general.common.api.to.AbstractEto;
import io.oasp.application.mtsj.suppliermanagement.common.api.Supplier;

/**
 * Entity transport object of Supplier
 */
public class SupplierEto extends AbstractEto implements Supplier {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private int rate;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getDescription() {

    return description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public int getRate() {

    return rate;
  }

  @Override
  public void setRate(int rate) {

    this.rate = rate;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
    result = prime * result + ((Integer) rate).hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    SupplierEto other = (SupplierEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!this.description.equals(other.description)) {
      return false;
    }
    if (this.rate != other.rate) {
      return false;
    }
    return true;
  }
}
