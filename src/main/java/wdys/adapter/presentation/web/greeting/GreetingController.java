package wdys.adapter.presentation.web.greeting;

import wdys.application.GreetingCommandService;
import wdys.application.GreetingGetService;
import wdys.adapter.presentation.web.greeting.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/greetings")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingGetService greetingGetService;

    private final GreetingCommandService greetingCommandService;

    @GetMapping
    public ResponseEntity<List<GreetingListViewResponse>> findGreetings(@RequestParam final String situation,
                                                                        @RequestParam final String honorific,
                                                                        @RequestParam final String sentenceLength,
                                                                        @RequestParam(defaultValue = "1") final int page,
                                                                        @RequestParam(defaultValue = "10") final int size,
                                                                        @RequestParam(required = false) final Long memberId) {
        GreetingSearchRequest greetingSearchRequest = GreetingSearchRequest.builder()
                .situation(situation)
                .honorific(honorific)
                .sentenceLength(sentenceLength)
                .memberId(memberId)
                .build();

        // Sort.by 가 필요한 경우에 추가할 것
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        return ResponseEntity.ok().body(this.greetingGetService.findGreetings(greetingSearchRequest, pageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GreetingDetailViewResponse> findGreeting(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.greetingGetService.findGreeting(id));
    }

    @PostMapping
    public ResponseEntity<GreetingCreatedResponse> createGreeting(@RequestBody @Valid GreetingCreateRequest greetingCreateRequest) {
        GreetingCreatedResponse greetingCreatedResponse = this.greetingCommandService.createGreeting(greetingCreateRequest);

        return ResponseEntity.created(URI.create("/greetings/" + greetingCreatedResponse.getId())).body(greetingCreatedResponse);
    }

}
