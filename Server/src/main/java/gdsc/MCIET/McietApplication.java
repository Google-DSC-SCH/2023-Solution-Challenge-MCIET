package gdsc.MCIET;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(
//		exclude = {
//				org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
//				org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
//				org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class
//		}
)
@EnableJpaAuditing
public class McietApplication {

	public static void main(String[] args) {
		SpringApplication.run(McietApplication.class, args);
	}

}
