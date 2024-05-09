package springcloud.service;

import com.csr.springcloud.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springcloud.dao.UserDao;

import java.util.List;

/**
 * @description:
 * @author：csr
 * @date: 2024/5/7 0007
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;


     public void addUser(User user){
         userDao.insert(user);
     }

     public List<User> queryAllUser(){
         return  userDao.selectList(null);
     }

}
