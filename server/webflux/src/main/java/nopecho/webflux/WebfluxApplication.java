package nopecho.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.tools.agent.ReactorDebugAgent;

@SpringBootApplication
public class WebfluxApplication {

    public static void main(String[] args) {
//        System.setProperty("reactor.netty.ioWorkerCount", "1");
        ReactorDebugAgent.init();
        SpringApplication.run(WebfluxApplication.class, args);
    }
}
