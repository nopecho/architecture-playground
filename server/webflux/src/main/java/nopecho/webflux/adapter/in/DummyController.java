package nopecho.webflux.adapter.in;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DummyController {

    @GetMapping("/call1")
    public Mono<ResponseEntity<?>> getOrders() throws InterruptedException {
        log.info("call 1");
        Thread.sleep(5000);
        return Mono.just(ResponseEntity.ok(Flux.empty()));
    }

    @GetMapping("/call2")
    public Flux<?> getOrders2() {
        log.info("call 2");
        return Flux.just("test");
    }
}
