package fr.uge.jee.bugged.service;

import fr.uge.jee.bugged.entity.User;
import fr.uge.jee.bugged.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    public static String rot(int shift, String str){
        var sb = new StringBuilder();
        for(var c : str.getBytes(StandardCharsets.US_ASCII)){
            sb.append((char) ((int) c + shift));
        }
        return sb.toString();
    }

    private final UserRepository repository;
    @PersistenceContext
    EntityManager em;

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    @Transactional
    public List<User> searchByLastName(String lastName) {
        var q = "SELECT s FROM User s WHERE s.lastName = '"+lastName+"'";
        return em.createQuery(q,User.class).getResultList();
    }

    @Transactional
    public void init(){
        em.persist(new User("Arnaud","Carayol",UserService.rot(-13,">>E?>E>>E?>E")));
    }
}
