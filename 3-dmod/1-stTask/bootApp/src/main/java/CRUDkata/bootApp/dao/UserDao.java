package CRUDkata.bootApp.dao;

import CRUDkata.bootApp.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    public List<User> getAllUsers() {
        CriteriaQuery<User> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void updateUserById(int id, User user) {
        entityManager.detach(user);
        user.setId(id);
        entityManager.merge(user);
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
