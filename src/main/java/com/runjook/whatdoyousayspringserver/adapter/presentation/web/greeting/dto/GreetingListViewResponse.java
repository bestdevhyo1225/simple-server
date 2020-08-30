package com.runjook.whatdoyousayspringserver.adapter.presentation.web.greeting.dto;

import com.runjook.whatdoyousayspringserver.domain.model.Greeting;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class GreetingListViewResponse {
    private Long id;

    private String contents;

    private int bookmarkCount;

    private Boolean isBookMarking;

    @Builder
    private GreetingListViewResponse(final Long id,
                                     final String contents,
                                     final int bookmarkCount,
                                     final Boolean isBookMarking) {
        this.id = id;
        this.contents = contents;
        this.bookmarkCount = bookmarkCount;
        this.isBookMarking = isBookMarking;
    }

    private static GreetingListViewResponse of(final Greeting greeting,
                                              final Boolean isBookMarking) {

        return GreetingListViewResponse.builder()
                .id(greeting.getId())
                .contents(greeting.getContents())
                .bookmarkCount(greeting.getBookmarkCount())
                .isBookMarking(isBookMarking)
                .build();
    }

    public static List<GreetingListViewResponse> toList(final Page<Greeting> greetings,
                                                        final HashMap<Greeting, Boolean> hashMapForIdCheck) {
        return greetings.stream()
                .map(greeting -> of(greeting, hashMapForIdCheck.containsKey(greeting)))
                .collect(Collectors.toList());
    }

}
