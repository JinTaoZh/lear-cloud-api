package com.zjt.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zjt
 * @date 2020-09-30
 */
@Slf4j
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @GetMapping("/ok")
    public String ok() {
        return "OK";
    }

    @GetMapping("/time-out")
    public String out() {
//        try {
//            TimeUnit.SECONDS.sleep(seconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return String.format("time-out->%d->-ok", 0);
    }

    @GetMapping("test-thread")
    public String testThreadFlowLimiting() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testOK";
    }

    @PostMapping("/write")
    public String write() {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "write";
    }

    @GetMapping("/read")
    public String read() {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "read";
    }

    @GetMapping("/speed")
    public String speed() {
        log.info(Thread.currentThread().getName() + "\t" + LocalDateTime.now() + "\t" + "speed");
        return "OK";
    }

    @GetMapping("/fusing")
    public String fusingRT() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "测试RT";
    }

    @GetMapping("/fusing-a")
    public String fusingRTA() {
        Random random = new Random();
        int i = random.nextInt(100) + 1;
        if (i % 2 == 0) {
            throw new RuntimeException(LocalDateTime.now() + "\t程序运行出错");
        }
        return "测试RT异常比例 OK\t" + LocalDateTime.now();
    }

    @GetMapping("/hot-key")
    // value name of the Sentinel resource Sentinel资源的名称
    // name of the block exception function, empty by default 违背Sentinel配置将会执行的备用方法
    @SentinelResource(value = "sentinel-hot-key", blockHandler = "fusingHotKey")
    public String hotKey(@RequestParam(value = "k1", required = false) String k1, @RequestParam(value = "k2", required = false) String k2) {
        return "k1 ---> hotKey";
    }

    public String fusingHotKey(String k1, String k2, BlockException e) {
        return "k1--->hotKey ---> 被限流";
    }


}
