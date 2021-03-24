package ai.yuhan.system.server.service.impl;

import ai.yuhan.system.server.entity.Permission;
import ai.yuhan.system.server.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/14 19:00
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    public List<Permission> selectByUserId(Long userId) {
        return null;
    }
}
