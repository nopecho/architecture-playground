package nopecho.webflux.adapter.in;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class DummyController {

    @GetMapping("/call1")
    public Flux<?> getOrders() throws InterruptedException {
        log.info("call 1");
        Thread.sleep(5000);
        return Flux.empty();
    }

    @GetMapping("/call2")
    public Flux<?> getOrders2() {
        log.info("call 2");
        return Flux.just("test");
    }
}
