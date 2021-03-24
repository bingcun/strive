package ai.yuhan.permission.server.service.impl;

import ai.yuhan.permission.api.service.IndexService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/18 16:56
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Service
@DubboService
public class IndexServiceImpl implements IndexService {

    @Override
    public String index() {
//        indexMapper.insert(Test.builder().name("zhangsan").build());
        return "success";
    }
}
