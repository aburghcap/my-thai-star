package io.oasp.application.mtsj.suppliermanagement.common.api;

import io.oasp.application.mtsj.general.common.api.ApplicationEntity;

public interface Supplier extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getDescription();

  public void setDescription(String description);

  public int getRate();

  public void setRate(int rate);

}
