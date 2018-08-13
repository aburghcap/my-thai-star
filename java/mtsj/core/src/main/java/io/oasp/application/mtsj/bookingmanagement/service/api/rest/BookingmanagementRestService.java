package io.oasp.application.mtsj.bookingmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.oasp.application.mtsj.bookingmanagement.logic.api.Bookingmanagement;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageCto;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageEto;
import io.oasp.application.mtsj.bookingmanagement.logic.api.to.SpecialPackageSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Bookingmanagement}.
 */
@Path("/bookingmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BookingmanagementRestService {

  /**
   * Delegates to {@link Bookingmanagement#findSpecialPackage}.
   *
   * @param id the ID of the {@link SpecialPackageEto}
   * @return the {@link SpecialPackageEto}
   */
  @GET
  @Path("/specialpackage/{id}/")
  public SpecialPackageEto getSpecialPackage(@PathParam("id") long id);

  /**
   * Delegates to {@link Bookingmanagement#saveSpecialPackage}.
   *
   * @param specialpackage the {@link SpecialPackageEto} to be saved
   * @return the recently created {@link SpecialPackageEto}
   */
  @POST
  @Path("/specialpackage/")
  public SpecialPackageEto saveSpecialPackage(SpecialPackageEto specialpackage);

  /**
   * Delegates to {@link Bookingmanagement#deleteSpecialPackage}.
   *
   * @param id ID of the {@link SpecialPackageEto} to be deleted
   */
  @DELETE
  @Path("/specialpackage/{id}/")
  public void deleteSpecialPackage(@PathParam("id") long id);

  /**
   * Delegates to {@link Bookingmanagement#findSpecialPackageEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding specialpackages.
   * @return the {@link PaginatedListTo list} of matching {@link SpecialPackageEto}s.
   */
  @Path("/specialpackage/search")
  @POST
  public PaginatedListTo<SpecialPackageEto> findSpecialPackagesByPost(SpecialPackageSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Bookingmanagement#findSpecialPackageCto}.
   *
   * @param id the ID of the {@link SpecialPackageCto}
   * @return the {@link SpecialPackageCto}
   */
  @GET
  @Path("/specialpackage/cto/{id}/")
  public SpecialPackageCto getSpecialPackageCto(@PathParam("id") long id);

  /**
   * Delegates to {@link Bookingmanagement#findSpecialPackageCtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding specialpackages.
   * @return the {@link PaginatedListTo list} of matching {@link SpecialPackageCto}s.
   */
  @Path("/specialpackage/cto/search")
  @POST
  public PaginatedListTo<SpecialPackageCto> findSpecialPackageCtosByPost(
      SpecialPackageSearchCriteriaTo searchCriteriaTo);

}