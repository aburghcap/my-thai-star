package io.oasp.application.mtsj.suppliermanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.mtsj.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.mtsj.suppliermanagement.dataaccess.api.SupplierEntity;
import io.oasp.application.mtsj.suppliermanagement.dataaccess.api.dao.SupplierDao;
import io.oasp.application.mtsj.suppliermanagement.logic.api.to.SupplierSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link SupplierDao}.
 */
@Named
public class SupplierDaoImpl extends ApplicationDaoImpl<SupplierEntity> implements SupplierDao {

  /**
   * The constructor.
   */
  public SupplierDaoImpl() {

    super();
  }

  @Override
  public Class<SupplierEntity> getEntityClass() {

    return SupplierEntity.class;
  }

  @Override
  public PaginatedListTo<SupplierEntity> findSuppliers(SupplierSearchCriteriaTo criteria) {

    SupplierEntity supplier = Alias.alias(SupplierEntity.class);
    EntityPathBase<SupplierEntity> alias = Alias.$(supplier);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(supplier.getName()).eq(name));
    }
    String description = criteria.getDescription();
    if (description != null) {
      query.where(Alias.$(supplier.getDescription()).eq(description));
    }
    Integer rate = criteria.getRate();
    if (rate != null) {
      query.where(Alias.$(supplier.getRate()).eq(rate));
    }
    addOrderBy(query, alias, supplier, criteria.getSort());

    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<SupplierEntity> alias, SupplierEntity supplier,
      List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        switch (orderEntry.getName()) {
          case "name":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(supplier.getName()).asc());
            } else {
              query.orderBy(Alias.$(supplier.getName()).desc());
            }
            break;
          case "description":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(supplier.getDescription()).asc());
            } else {
              query.orderBy(Alias.$(supplier.getDescription()).desc());
            }
            break;
          case "rate":
            if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
              query.orderBy(Alias.$(supplier.getRate()).asc());
            } else {
              query.orderBy(Alias.$(supplier.getRate()).desc());
            }
            break;
        }
      }
    }
  }

}