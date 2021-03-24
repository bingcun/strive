package ai.yuhan.system.server.service;

import ai.yuhan.system.server.entity.Permission;

import java.util.List;

/**
 * @author Fox
 */
public interface PermissionService  {

    List<Permission> selectByUserId(Long userId);
}
