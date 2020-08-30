package wdys.domain.model;

import wdys.adapter.presentation.web.greeting.dto.GreetingCreateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Setter @Getter
@NoArgsConstructor(access = PROTECTED)
@Where(clause = "is_deleted = 0")
@Table(name = "greeting",
        indexes = {
                @Index(columnList = "situation, sentence_length, honorific, is_deleted", name = "idx_greeting__search_1"),
                @Index(columnList = "greeting_id, is_deleted", name = "idx_greeting__search_2"),
        }
)
public class Greeting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "greeting_id")
    private Long id;

    @Column(name = "situation", nullable = false)
    @ColumnDefault("''")
    private String situation;

    @Column(name = "honorific", nullable = false)
    @ColumnDefault("''")
    private String honorific;

    @Column(name = "sentence_length", nullable = false)
    @ColumnDefault("''")
    private String sentenceLength;

    @Column(name = "contents", nullable = false)
    @ColumnDefault("''")
    private String contents;

    @Column(name = "bookmark_count", nullable = false, columnDefinition = "INT(10) UNSIGNED")
    @ColumnDefault("0")
    private int bookmarkCount;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    @ColumnDefault("0")
    private Boolean isDeleted;

    /* 생성 메소드 */
    public static Greeting createGreeting(final GreetingCreateRequest greetingCreateRequest) {
        Greeting greeting = new Greeting();

        greeting.setSituation(greetingCreateRequest.getSituation());
        greeting.setHonorific(greetingCreateRequest.getHonorific());
        greeting.setSentenceLength(greetingCreateRequest.getSentenceLength());
        greeting.setContents(greetingCreateRequest.getContents());
        greeting.setBookmarkCount(0);
        greeting.setIsDeleted(false);

        return greeting;
    }

}
