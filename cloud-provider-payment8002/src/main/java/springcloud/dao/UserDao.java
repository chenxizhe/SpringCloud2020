package springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csr.springcloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：csr
 * @date: 2024/5/7 0007
 */
@Mapper
public interface UserDao  extends BaseMapper<User> {
}
