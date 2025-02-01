package ru.rzik.bo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import ru.rzik.bo.model.Bo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoSimpleRestTemplateTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void toDoTest() {
        Bo bo = new Bo();
        bo.setName("12313");
        bo.setDescription("asdasdasd");
        ResponseEntity<Bo> responseEntity = restTemplate.postForEntity("/add", bo, Bo.class);
        System.out.println(responseEntity.getBody());
        assertThat(responseEntity.getStatusCode().is4xxClientError()).isTrue();
    }
}
