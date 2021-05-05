package com.house.health;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class HouseApplicationTest {

    @Test
    void contextLoads() throws IOException {
        String path = this.getClass().getClassLoader().getResource("/1.txt").getPath();

        String s = "/E:/Java/idea-workspace/edu/HouseRent-master/target/classes/houseImages/1.txt";
        System.out.println("==================");
        System.out.println(path);
        System.out.println(s.substring(1,s.length()-6));
    }

}
