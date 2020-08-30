package wdys.adapter.presentation.web.greeting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GreetingSearchRequest {

    private String situation;

    private String honorific;

    private String sentenceLength;

    private Long memberId;

    @Builder
    public GreetingSearchRequest(final String situation,
                                 final String honorific,
                                 final String sentenceLength,
                                 final Long memberId) {
        this.situation = situation;
        this.honorific = honorific;
        this.sentenceLength = sentenceLength;
        this.memberId = memberId;
    }

}
