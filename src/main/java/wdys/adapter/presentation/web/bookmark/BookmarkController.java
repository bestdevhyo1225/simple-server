package wdys.adapter.presentation.web.bookmark;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wdys.adapter.presentation.web.bookmark.dto.BookmarkCreateRequest;
import wdys.application.BookmarkCommandService;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCommandService bookmarkCommandService;

    @PostMapping
    public ResponseEntity<Void> registerOrCancel(@RequestBody @Valid BookmarkCreateRequest bookmarkCreateRequest) {
        this.bookmarkCommandService.registerOrCancel(
                bookmarkCreateRequest.getMemberId(),
                bookmarkCreateRequest.getGreetingId(),
                bookmarkCreateRequest.getIsOn()
        );

        return ResponseEntity.ok().build();
    }

}
