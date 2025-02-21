package org.example.kata.confectionery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/import.sql"})
class CakeServiceTest {

    @Autowired
    private ICakeService service;

}
