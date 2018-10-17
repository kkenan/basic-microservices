package com.github.kkenan.basic.microservices.services;

import com.github.kkenan.basic.microservices.services.dto.AppStatusResult;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Simple app service.
 *
 * @author Kenan Klisura
 */
@Service
public class AppService {
  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Gets the app status.
   *
   * @return App status.
   */
  @Transactional
  public AppStatusResult getStatus() {
    final Query nativeQuery = entityManager.createNativeQuery("SELECT version();");
    final String postgresVersion = (String) nativeQuery.getSingleResult();
    return new AppStatusResult("UP", postgresVersion);
  }
}
