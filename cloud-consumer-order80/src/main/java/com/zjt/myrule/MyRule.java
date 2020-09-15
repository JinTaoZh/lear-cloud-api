package com.zjt.myrule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zjt
 * @date 2020-09-06
 */
@Slf4j
public class MyRule extends RoundRobinRule {


    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Server choose(ILoadBalancer lb, Object key) {
        // 获取启动并且是可用的服务
        List<Server> serverList = lb.getReachableServers();
        if (!CollectionUtils.isEmpty(serverList)) {
            int size = serverList.size();
            int next = this.increaseAndGet();
            int index = next % size;
            Server server = serverList.get(index);
            log.info("选中的服务端口为" + server.getHost() + ":" + server.getPort());
            return server;
        }
        log.info("暂无可用服务");
        return null;

    }

    @Override
    public Server choose(Object key) {
        return super.choose(key);
    }

    /**
     * 增加并获取服务列表下标
     * usableSize 可用服务列表总数
     *
     * @return 可用下标
     */
    private int increaseAndGet() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : (current + 1);
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("next = " + next);
        return next;
    }
}
