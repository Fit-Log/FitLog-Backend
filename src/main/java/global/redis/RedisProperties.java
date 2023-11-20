package global.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Getter
@AllArgsConstructor
@ConfigurationPropertiesScan("spring.redis")
public class RedisProperties {

    private final String host;
    private final int port;
}