import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wzhao
 * @create 2022-08-22 11:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.work.glkt.client.course")
@MapperScan("com.work.glkt.wechat.mapper")
@ComponentScan(basePackages = "com.work")
public class ServiceWechatApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceWechatApplication.class, args);
	}
}
