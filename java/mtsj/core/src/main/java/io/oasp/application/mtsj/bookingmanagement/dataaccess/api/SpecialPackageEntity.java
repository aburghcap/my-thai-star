package io.oasp.application.mtsj.bookingmanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.oasp.application.mtsj.bookingmanagement.common.api.PackagePerson;
import io.oasp.application.mtsj.bookingmanagement.common.api.SpecialPackage;
import io.oasp.application.mtsj.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.application.mtsj.ordermanagement.dataaccess.api.OrderEntity;

@Entity
@Table(name = "Special")
public class SpecialPackageEntity extends ApplicationPersistenceEntity implements SpecialPackage {

  private String name;

  private OrderEntity offer;

  private PackagePersonEmbeddable packagePerson;

  private String specialPrice;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Column(unique = true)
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
   * @return offer
   */
  @ManyToOne
  public OrderEntity getOffer() {

    return this.offer;
  }

  /**
   * @param offer new value of {@link #getoffer}.
   */
  public void setOffer(OrderEntity offer) {

    this.offer = offer;
  }

  /**
   * @return packagePerson
   */
  @Embedded
  public PackagePersonEmbeddable getPackagePerson() {

    return this.packagePerson;
  }

  /**
   * @param packagePerson new value of {@link #getpackagePerson}.
   */
  public void setPackagePerson(PackagePerson packagePerson) {

    this.packagePerson = (PackagePersonEmbeddable) packagePerson;
  }

  /**
   * @return specialPrice
   */
  public String getSpecialPrice() {

    return this.specialPrice;
  }

  /**
   * @param specialPrice new value of {@link #getspecialPrice}.
   */
  public void setSpecialPrice(String specialPrice) {

    this.specialPrice = specialPrice;
  }

  @Override
  @Transient
  public Long getOfferId() {

    if (this.offer == null) {
      return null;
    }
    return this.offer.getId();
  }

  @Override
  public void setOfferId(Long offerId) {

    if (offerId == null) {
      this.offer = null;
    } else {
      OrderEntity orderEntity = new OrderEntity();
      orderEntity.setId(offerId);
      this.offer = orderEntity;
    }
  }

}
