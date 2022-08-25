import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wzhao
 * @create 2022-08-19 16:42
 * /**
 * 2 @EnableFeignClients(“指定feign的扫描路径”),此时如果client有其他依赖,
 * @SpringBootApplication(scanBasePackages = {“本服务的扫描路径”,“远程调用服务的扫描路径”})
 * //@MapperScan("com.work.glkt.activity.mapper")
//UserInfoFeignClient
// (basePackages = "com.work")
//(scanBasePackages = {"com.work.glkt.activity","com.work.glkt.client.user"})

 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.work")
@ComponentScan(basePackages = "com.work")
public class ServiceActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceActivityApplication.class, args);
	}
}

