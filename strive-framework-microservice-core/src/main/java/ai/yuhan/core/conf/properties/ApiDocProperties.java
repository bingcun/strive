package ai.yuhan.core.conf.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiDocProperties {
    @NestedConfigurationProperty
    private ApiDocketProperties docket;
    private List<ApiDocketProperties> dockets;



}
