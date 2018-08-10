package io.oasp.application.mtsj.suppliermanagement.logic.api;

import java.util.List;

import io.oasp.application.mtsj.suppliermanagement.logic.api.to.SupplierCto;
import io.oasp.application.mtsj.suppliermanagement.logic.api.to.SupplierEto;
import io.oasp.application.mtsj.suppliermanagement.logic.api.to.SupplierSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Suppliermanagement component.
 */
public interface Suppliermanagement {

  /**
   * Returns a Supplier by its id 'id'.
   *
   * @param id The id 'id' of the Supplier.
   * @return The {@link SupplierEto} with id 'id'
   */
  SupplierEto findSupplier(Long id);

  /**
   * Returns a paginated list of Suppliers matching the search criteria.
   *
   * @param criteria the {@link SupplierSearchCriteriaTo}.
   * @return the {@link List} of matching {@link SupplierEto}s.
   */
  PaginatedListTo<SupplierEto> findSupplierEtos(SupplierSearchCriteriaTo criteria);

  /**
   * Deletes a supplier from the database by its id 'supplierId'.
   *
   * @param supplierId Id of the supplier to delete
   * @return boolean <code>true</code> if the supplier can be deleted, <code>false</code> otherwise
   */
  boolean deleteSupplier(Long supplierId);

  /**
   * Saves a supplier and store it in the database.
   *
   * @param supplier the {@link SupplierEto} to create.
   * @return the new {@link SupplierEto} that has been saved with ID and version.
   */
  SupplierEto saveSupplier(SupplierEto supplier);

  /**
   * Returns a composite Supplier by its id 'id'.
   *
   * @param id The id 'id' of the Supplier.
   * @return The {@link SupplierCto} with id 'id'
   */
  SupplierCto findSupplierCto(Long id);

  /**
   * Returns a paginated list of composite Suppliers matching the search criteria.
   *
   * @param criteria the {@link SupplierSearchCriteriaTo}.
   * @return the {@link List} of matching {@link SupplierCto}s.
   */
  PaginatedListTo<SupplierCto> findSupplierCtos(SupplierSearchCriteriaTo criteria);

}