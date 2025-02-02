package ru.rzik.bo;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import ru.rzik.bo.model.Bo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ToDoSimpleRestTemplateTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void post() {
        Bo bo = new Bo();
        bo.setName("12313");
        bo.setDescription("asdasdasd");
        ResponseEntity<Bo> responseEntity = restTemplate.postForEntity("/add", bo, Bo.class);
        log.info("responseEntity: {}", responseEntity);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
