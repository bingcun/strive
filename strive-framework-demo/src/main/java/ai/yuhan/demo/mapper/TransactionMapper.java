package ai.yuhan.demo.mapper;

import ai.yuhan.demo.entity.TB_USER;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/23 12:02
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Mapper
public interface TransactionMapper extends BaseMapper<TB_USER> {
}
