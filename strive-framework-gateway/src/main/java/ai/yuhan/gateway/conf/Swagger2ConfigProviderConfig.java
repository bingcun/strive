package ai.yuhan.gateway.conf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/20 16:21
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class Swagger2ConfigProviderConfig implements SwaggerResourcesProvider {

    public static final String SWAGGER2URL  = "/v2/api-docs";

    private final RouteLocator routeLocator;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger log = LoggerFactory.getLogger(Swagger2ConfigProviderConfig.class);
    @Autowired
    @Qualifier("loadBalancedRestTemplate")
    private RestTemplate restTemplate;
    @Value("${spring.application.name}")
    private String serviceName;
//    @Value("${server.ssl.enabled:false}")
//    private boolean sslEnable;

    public Swagger2ConfigProviderConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    /**
     * 聚合微服务框架
     * @return
     */
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList();
        List<String> routeHosts = new ArrayList<>();

        //拿到微服务的前缀
        routeLocator.getRoutes().filter(route -> route.getUri().getHost() != null)
                .filter(route -> !serviceName.equals(route.getUri().getHost()))
                .subscribe(route -> routeHosts.add(route.getUri().getHost()));


        //遍历微服务前缀
        for(String url:routeHosts){
            if(url.equals("seata-server")){
                continue;
            }
            resources.addAll(convertListUrl(url,this.getSwaggerResourceListFromRoute(url)));
        }

        return resources;
    }

    /**
     * 增加微服务前缀
     * @param url
     * @param resources
     * @return
     */
    private List<SwaggerResource> convertListUrl(String url,List<SwaggerResource> resources){
        for(SwaggerResource resource:resources){
            resource.setUrl("/" + url + resource.getUrl());
        }
        return resources;
    }

    /**
     * 遍历微服务前缀获取swagger2真正地址
     * @param url
     * @return
     */
    private List<SwaggerResource> getSwaggerResourceListFromRoute(String url) {
        List swaggerResourcesList = null;
        String protocol = "http";
        try {
            ResponseEntity<List> responseEntity = this.restTemplate.getForEntity(protocol + "://" + url + "/swagger-resources", List.class, new Object[0]);
            swaggerResourcesList = (List)objectMapper.readValue(objectMapper.writeValueAsString(responseEntity.getBody()), new TypeReference<List<SwaggerResource>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return swaggerResourcesList;
    }

}
