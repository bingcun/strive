package ai.yuhan.core.conf.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "strive")
@NoArgsConstructor
@Data
public class StriveProperties {
    @NestedConfigurationProperty
    private ApiDocProperties apiDoc;

}
