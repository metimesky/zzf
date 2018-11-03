import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zzf.model.UserInfo;

import java.io.IOException;
import java.io.Reader;
 
/**
 * Created by yuhan.shen on 2017/11/3.
 */
public class TestUserInfo {
 
    /**
     * SqlSessionFactory是用来创建SqlSession的工厂，SqlSession会执行映射的语句，进行事物提交、回滚等。
     * @return
     */
    public SqlSessionFactory getSqlSessionFactory() {
        Reader reader = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }
 
    @Test
    public void selectTest(){
        SqlSession session = getSqlSessionFactory().openSession();
        try {
            UserInfo userInfo = (UserInfo) session .selectOne("UserInfoMapper.selectUserByID");
            System.out.println(userInfo.getUserName());
        } finally {
            session.close();
        }
    }
}

