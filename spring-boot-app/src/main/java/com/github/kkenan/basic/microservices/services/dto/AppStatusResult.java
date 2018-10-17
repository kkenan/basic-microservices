package com.github.kkenan.basic.microservices.services.dto;

/**
 * Status of an app result.
 *
 * @author Kenan Klisura
 */
public class AppStatusResult {
  private String status;
  private String postgresVersion;

  public AppStatusResult(String status, String postgresVersion) {
    this.status = status;
    this.postgresVersion = postgresVersion;
  }

  public String getStatus() {
    return status;
  }

  public String getPostgresVersion() {
    return postgresVersion;
  }
}
