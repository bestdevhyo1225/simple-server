package wdys.adapter.presentation.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wdys.application.BookmarkGetService;
import wdys.domain.model.Bookmark;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final BookmarkGetService bookmarkGetService;

    @GetMapping("/{key}/bookmarks")
    public ResponseEntity<List<Bookmark>> findBookmarksByMember(@PathVariable String key) {
        return null;
    }

}
