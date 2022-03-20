package tk.idealist.pipeline.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tk.idealist.pipeline.service.SuperReducedStringService;

import java.util.Objects;

@RequiredArgsConstructor
@RequestMapping({"","/{input}"})
@RestController
public class SuperReducedStringController {

    private static final String EMPTY_STRING = "";

    private final SuperReducedStringService superReducedStringService;

    @GetMapping
    public Mono<String> reduce(@PathVariable(required = false) String input) {
        var s = Objects.nonNull(input) ? input : EMPTY_STRING;
        return Mono.just(superReducedStringService.reduce(s));
    }
}
