package com.dercg.netty.transport.mgr;

import com.dercg.netty.transport.service.ServiceEntry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

public class Z_ServiceDiscoverMgr {
    private ServiceDiscovery<ServiceEntry> serviceDiscovery;

    private static final String BASE_PATH = "services";

    public Z_ServiceDiscoverMgr(Z_CuratorMgr curatorMgr) throws Exception {
        this(curatorMgr, BASE_PATH);
    }

    public Z_ServiceDiscoverMgr(Z_CuratorMgr curatorMgr, String basePath) throws Exception {
        JsonInstanceSerializer<ServiceEntry> serializer = new JsonInstanceSerializer<>(ServiceEntry.class);
        serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceEntry.class)
                .client(curatorMgr.getCuratorClient())
                .basePath(basePath)
                .serializer(serializer)
                .build();
        serviceDiscovery.start();
    }

    public ServiceDiscovery<ServiceEntry> get() {
        return serviceDiscovery;
    }

    public void close() {
        CloseableUtils.closeQuietly(serviceDiscovery);
    }

}
