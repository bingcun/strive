package ai.yuhan.system.server.mapper;

import ai.yuhan.system.server.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/14 18:53
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("SELECT\n" +
            "\tt.* \n" +
            "FROM\n" +
            "\ttb_permission t\n" +
            "\tLEFT JOIN tb_role_permission t1 ON t.id = t1.permission_id\n" +
            "\tLEFT JOIN tb_role t2 ON t1.role_id = t2.id\n" +
            "\tLEFT JOIN tb_account_role t3 ON t2.id = t3.role_id\n" +
            "\tLEFT JOIN tb_account t4 ON t3.user_id = t4.id \n" +
            "WHERE\n" +
            "\tt4.id = #{userId}")
    List<Permission> selectByUserId(Long userId);
}
