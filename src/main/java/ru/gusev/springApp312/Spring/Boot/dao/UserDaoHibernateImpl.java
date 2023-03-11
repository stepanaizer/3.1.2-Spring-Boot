package ru.gusev.springApp312.Spring.Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.gusev.springApp312.Spring.Boot.model.User;

import java.util.List;


@Repository
public class UserDaoHibernateImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void deleteUserById(Long id) {
        em.createQuery("delete from User user where user.id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public List<User> listAllUsers() {
        return (List<User>) em.createQuery("from User").getResultList();
    }
}
