package playground.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import playground.domain.User;
import playground.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SqlSession sqlSession;

    @Override
    @Cacheable(value = "users")
    public List<User> findAllUsers() {
        return sqlSession.selectList("user.findAll");
    }

    @Override
    public User findUserByName(String name) {
        return sqlSession.selectOne("user.findByName", name);
    }
}
