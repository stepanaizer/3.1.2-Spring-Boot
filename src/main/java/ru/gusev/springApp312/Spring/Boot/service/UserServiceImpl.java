package ru.gusev.springApp312.Spring.Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gusev.springApp312.Spring.Boot.dao.UserDao;
import ru.gusev.springApp312.Spring.Boot.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional
    public void updateUserInfo(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }
}
