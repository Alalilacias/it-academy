package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    private static Branch branch;

    @BeforeEach
    void setUp() {
        branch = Branch.builder()
                .id(1)
                .name("TestBranch")
                .country("Spain")
                .build();
    }

    @Test
    void getId() {
        assertEquals(1, branch.getId());
    }

    @Test
    void getName() {
        assertEquals("TestBranch", branch.getName());
    }

    @Test
    void getCountry() {
        assertEquals("Spain", branch.getCountry());
    }

    @Test
    void setName() {
        branch.setName("Branch for the Test");
        assertEquals("Branch for the Test", branch.getName());
    }

    @Test
    void setCountry() {
        branch.setCountry("Catalonia");
        assertEquals("Catalonia", branch.getCountry());
    }
}