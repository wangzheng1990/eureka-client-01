package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wz
 * @date 2019/1/28 11:10
 */
@RestController
public class ClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instance/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
        @PathVariable String applicationName) {
            return this.discoveryClient.getInstances(applicationName);
    }

}
