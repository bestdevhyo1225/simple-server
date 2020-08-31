package wdys.adapter.presentation.web.bookmark.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookmarkCreateRequest {

    private Long memberId;

    private Long greetingId;

    private Boolean isOn;

}
