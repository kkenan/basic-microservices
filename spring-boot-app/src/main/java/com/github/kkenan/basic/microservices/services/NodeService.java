package com.github.kkenan.basic.microservices.services;

import com.github.kkenan.basic.microservices.services.client.NodeClient;
import com.github.kkenan.basic.microservices.services.dto.NodeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simple node service.
 *
 * @author Kenan Klisura
 */
@Service
public class NodeService {
  private NodeClient nodeClient;

  @Autowired
  public NodeService(NodeClient nodeClient) {
    this.nodeClient = nodeClient;
  }

  public NodeResult getNodeResult() {
    return nodeClient.getNodeResult();
  }
}
