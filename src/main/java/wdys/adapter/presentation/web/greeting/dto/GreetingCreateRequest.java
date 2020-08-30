package wdys.adapter.presentation.web.greeting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class GreetingCreateRequest {

    @NotBlank(message = "situation 값은 반드시 입력해야 합니다.")
    private String situation;

    @NotBlank(message = "honorific 값은 반드시 입력해야 합니다.")
    private String honorific;

    @NotBlank(message = "sentenceLength 값은 반드시 입력해야 합니다.")
    private String sentenceLength;

    @NotBlank(message = "contents 값은 반드시 입력해야 합니다.")
    private String contents;


    @Builder
    public GreetingCreateRequest(final String situation,
                                 final String honorific,
                                 final String sentenceLength,
                                 final String contents) {
        this.situation = situation;
        this.honorific = honorific;
        this.sentenceLength = sentenceLength;
        this.contents = contents;
    }

}
