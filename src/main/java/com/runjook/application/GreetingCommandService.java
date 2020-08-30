package com.runjook.application;

import com.runjook.adapter.presentation.web.greeting.dto.GreetingCreateRequest;
import com.runjook.adapter.presentation.web.greeting.dto.GreetingCreatedResponse;
import com.runjook.domain.GreetingRepository;
import com.runjook.domain.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GreetingCommandService {

    private final GreetingRepository greetingRepository;

    public GreetingCreatedResponse createGreeting(final GreetingCreateRequest greetingCreateRequest) {
        Greeting greeting = this.greetingRepository.save(Greeting.createGreeting(greetingCreateRequest));

        return GreetingCreatedResponse.of(greeting);
    }

}
