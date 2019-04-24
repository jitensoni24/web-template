package com.dtech.web.template.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dtech.web.template.entity.User;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<User> get() {
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<User> query = cb.createQuery(User.class);
			
			Root<User> root = query.from(User.class);
			CriteriaQuery<User> all = query.select(root);
					
			List<User> resultList = em.createQuery(all).getResultList();
			
			return  resultList;
			
		} catch (NoResultException e) {
			throw new NoResultException("constraint.user.not.found");
		}
	}
	
	public User get(String username) {
        try{
            CriteriaBuilder builder = em.getCriteriaBuilder();
            
            CriteriaQuery<User> query = builder.createQuery(User.class);
            
            Root<User> root = query.from(User.class);
            
            Predicate condition = builder.equal(builder.lower(root.<String>get("username")), username.toLowerCase());
            
            query.where(condition);

            return em.createQuery(query).getSingleResult();            
        } catch (NoResultException e) {
            throw new NoResultException("constraint.user.not.found");
        }
    }
	
	public User create(User user) {
		em.persist(user);
		
		return user;
	}
	
	public User update(Long userId, User user) {
        user.setId(userId);

        return em.merge(user);
    }

    public void delete(Long userId) {
        User user = em.find(User.class, userId);

        if (user != null) {
            em.remove(user);
        }
    }
}
