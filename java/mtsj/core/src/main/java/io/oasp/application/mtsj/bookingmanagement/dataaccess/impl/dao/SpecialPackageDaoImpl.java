package io.oasp.application.mtsj.bookingmanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.mtsj.bookingmanagement.dataaccess.api.SpecialPackageEntity;
import io.oasp.application.mtsj.bookingmanagement.dataaccess.api.dao.SpecialPackageDao;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.PackagePersonSearchCriteriaTo;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageSearchCriteriaTo;
import io.oasp.application.mtsj.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link SpecialPackageDao}.
 */
@Named
public class SpecialPackageDaoImpl extends ApplicationDaoImpl<SpecialPackageEntity> implements SpecialPackageDao {

  /**
   * The constructor.
   */
  public SpecialPackageDaoImpl() {

    super();
  }

  @Override
  public Class<SpecialPackageEntity> getEntityClass() {

    return SpecialPackageEntity.class;
  }

  @Override
  public PaginatedListTo<SpecialPackageEntity> findSpecialPackages(SpecialPackageSearchCriteriaTo criteria) {

    SpecialPackageEntity specialpackage = Alias.alias(SpecialPackageEntity.class);
    EntityPathBase<SpecialPackageEntity> alias = Alias.$(specialpackage);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(specialpackage.getName()).eq(name));
    }
    Long offer = criteria.getOfferId();
    if (offer != null) {
      if (specialpackage.getOffer() != null) {
        query.where(Alias.$(specialpackage.getOffer().getId()).eq(offer));
      }
    }
    PackagePersonSearchCriteriaTo packagePerson = criteria.getPackagePerson();
    if (packagePerson != null) {
      // 555see Practive C4 d
      query.where(Alias.$(specialpackage.getPackagePerson().getMinPerson()).eq(packagePerson.getMinPerson()) //
          .and(Alias.$(specialpackage.getPackagePerson().getMaxPerson()).eq(packagePerson.getMaxPerson())));
    }
    String specialPrice = criteria.getSpecialPrice();
    if (specialPrice != null) {
      query.where(Alias.$(specialpackage.getSpecialPrice()).eq(specialPrice));
    }
    addOrderBy(query, alias, specialpackage, criteria.getSort());

    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<SpecialPackageEntity> alias,
      SpecialPackageEntity specialpackage, List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        switch (orderEntry.getName()) {
          case "name":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(specialpackage.getName()).asc());
            } else {
              query.orderBy(Alias.$(specialpackage.getName()).desc());
            }
            break;
          case "offer":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(specialpackage.getOffer().getId()).asc());
            } else {
              query.orderBy(Alias.$(specialpackage.getOffer().getId()).desc());
            }
            break;
          case "packagePerson":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              // http://www.querydsl.com/static/querydsl/latest/reference/html/ch02.html#d0e230
              query.orderBy(//
                  Alias.$(specialpackage.getPackagePerson().getMinPerson()).asc(),
                  Alias.$(specialpackage.getPackagePerson().getMaxPerson()).asc());
            } else {
              query.orderBy(//
                  Alias.$(specialpackage.getPackagePerson().getMinPerson()).desc(),
                  Alias.$(specialpackage.getPackagePerson().getMaxPerson()).desc());
            }
            break;
          case "specialPrice":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(specialpackage.getSpecialPrice()).asc());
            } else {
              query.orderBy(Alias.$(specialpackage.getSpecialPrice()).desc());
            }
            break;
        }
      }
    }
  }

}