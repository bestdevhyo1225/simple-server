package com.runjook.adapter.presentation.web.greeting.dto;


import com.runjook.domain.model.Greeting;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GreetingCreatedResponse {

    private Long id;

    @Builder
    private GreetingCreatedResponse(final Long id) {
        this.id = id;
    }

    public static GreetingCreatedResponse of(final Greeting greeting) {
        return GreetingCreatedResponse.builder().id(greeting.getId()).build();
    }

}
