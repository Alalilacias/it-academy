package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class MyUserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MyUserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testCreateUser(){
        MyUser myUser = MyUser.builder()
                .username("testUser")
                .email("testuser@gmail.com")
                .password(passwordEncoder.encode("test_password"))
                .build();

        MyUser savedMyUser = repository.save(myUser);

        MyUser existsMyUser = entityManager.find(MyUser.class, savedMyUser.getId());

        assertEquals(myUser.getEmail(), existsMyUser.getEmail());
    }
  
}