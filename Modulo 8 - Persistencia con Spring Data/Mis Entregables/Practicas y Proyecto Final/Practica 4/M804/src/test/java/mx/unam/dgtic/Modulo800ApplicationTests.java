package mx.unam.dgtic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
class Modulo800ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("JOSE FERNANDO CASTAÑEDA ESTRADA");
        System.out.println("Cargar esquema y datos");
    }

}
