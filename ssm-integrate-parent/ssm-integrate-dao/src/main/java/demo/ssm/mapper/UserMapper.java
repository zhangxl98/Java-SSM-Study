package demo.ssm.mapper;

import demo.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/5/19 8:37 PM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description
 */
public interface UserMapper {

    User selectUserById(@Param("id")Long id);
}
