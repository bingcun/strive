package ai.yuhan.permission.server.controller;

import ai.yuhan.permission.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/18 16:37
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@RestController
public class indexController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/index")
    public String index(){
        return indexService.index();
    }
}
