package tk.idealist.pipeline.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import tk.idealist.pipeline.service.SuperReducedStringService;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = SuperReducedStringController.class)
@Import(SuperReducedStringService.class)
class SuperReducedStringControllerTest {

    private static final String URL = "/";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReduce() {
        webTestClient.get()
                .uri(URL)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class);
    }

    @Test
    void testPostEndpointThatIsAbsent() {
        webTestClient.post()
                .uri(URL)
                .exchange()
                .expectStatus().is4xxClientError();
    }
}
