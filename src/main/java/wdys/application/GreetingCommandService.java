package wdys.application;

import wdys.adapter.infrastructure.jpa.GreetingJpaRepository;
import wdys.adapter.presentation.web.greeting.dto.GreetingCreateRequest;
import wdys.adapter.presentation.web.greeting.dto.GreetingCreatedResponse;
import wdys.domain.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GreetingCommandService {

    private final GreetingJpaRepository greetingRepository;

    public GreetingCreatedResponse createGreeting(final GreetingCreateRequest greetingCreateRequest) {
        Greeting greeting = this.greetingRepository.save(Greeting.createGreeting(greetingCreateRequest));

        return GreetingCreatedResponse.of(greeting);
    }

}
