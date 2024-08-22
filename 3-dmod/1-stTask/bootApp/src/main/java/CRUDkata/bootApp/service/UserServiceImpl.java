package CRUDkata.bootApp.service;

import CRUDkata.bootApp.dao.UserDao;
import CRUDkata.bootApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public boolean saveUser(User user) {
        if (user.getName() != null && !user.getName().isEmpty()
                && user.getSurname() != null && !user.getSurname().isEmpty()
                && user.getAge() > 0) {
            userDao.saveUser(user);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public boolean updateUserById(int id, User user) {
        if (user.getName() != null && !user.getName().isEmpty()
                && user.getSurname() != null && !user.getSurname().isEmpty()
                && user.getAge() > 0) {
            userDao.updateUserById(id, user);
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
