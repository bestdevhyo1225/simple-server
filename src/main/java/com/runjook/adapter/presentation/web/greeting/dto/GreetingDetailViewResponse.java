package com.runjook.adapter.presentation.web.greeting.dto;

import com.runjook.domain.model.Greeting;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GreetingDetailViewResponse {

    private Long id;

    private String situation;

    private String honorific;

    private String sentenceLength;

    private String contents;

    @Builder
    private GreetingDetailViewResponse(final Long id,
                                     final String situation,
                                     final String honorific,
                                     final String sentenceLength,
                                     final String contents) {
        this.id = id;
        this.situation = situation;
        this.honorific = honorific;
        this.sentenceLength = sentenceLength;
        this.contents = contents;
    }

    public static GreetingDetailViewResponse of(final Greeting greeting) {
        return GreetingDetailViewResponse.builder()
                .id(greeting.getId())
                .situation(greeting.getSituation())
                .honorific(greeting.getHonorific())
                .sentenceLength(greeting.getSentenceLength())
                .contents(greeting.getContents())
                .build();
    }

}
