package zzf.mapper;

import org.apache.ibatis.annotations.Select;
import zzf.model.UserInfo;

/**
 * Created by zhangxinwei on 03/11/2018.
 */
public interface UserInfoMapper {

    @Select("select id,zi userName from sw where id = '43874'")
    UserInfo selectUserByID(int id);
}
