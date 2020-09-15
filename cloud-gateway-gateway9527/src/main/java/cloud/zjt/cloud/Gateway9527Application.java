package cloud.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-09-14
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527Application {

    public static void main(String[] args) {
        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(Gateway9527Application.class, args);
    }

}
