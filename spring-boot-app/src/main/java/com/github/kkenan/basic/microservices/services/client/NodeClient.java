package com.github.kkenan.basic.microservices.services.client;

import com.github.kkenan.basic.microservices.services.dto.NodeResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Node client.
 *
 * @author Kenan Klisura
 */
@FeignClient(name = "node", url = "${app.node.url}")
public interface NodeClient {
  @GetMapping(value = "/node/api/v1/result")
  NodeResult getNodeResult();
}
