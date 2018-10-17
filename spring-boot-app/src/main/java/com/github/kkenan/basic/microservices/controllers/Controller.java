package com.github.kkenan.basic.microservices.controllers;

import com.github.kkenan.basic.microservices.services.AppService;
import com.github.kkenan.basic.microservices.services.NodeService;
import com.github.kkenan.basic.microservices.services.dto.AppStatusResult;
import com.github.kkenan.basic.microservices.services.dto.NodeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple controller.
 *
 * @author Kenan Klisura
 */
@RestController
public class Controller {
  private AppService appService;
  private NodeService nodeService;

  @Autowired
  public Controller(AppService appService, NodeService nodeService) {
    this.appService = appService;
    this.nodeService = nodeService;
  }

  @GetMapping("/api/v1/status")
  public AppStatusResult hello() {
    return appService.getStatus();
  }

  @GetMapping("/api/v1/node")
  public NodeResult node() {
    return nodeService.getNodeResult();
  }
}
