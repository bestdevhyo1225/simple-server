package wdys.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wdys.adapter.infrastructure.jpa.BookmarkJpaRepository;
import wdys.domain.model.Bookmark;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookmarkGetService {

    private final BookmarkJpaRepository bookmarkRepository;

    public void findBookmarksByMember(final Long memberId, final Pageable pageable) {
        Page<Bookmark> bookmarks = this.bookmarkRepository.findAllByMemberId(memberId, pageable);
    }


}
