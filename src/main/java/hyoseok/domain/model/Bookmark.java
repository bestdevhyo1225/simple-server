package hyoseok.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = PROTECTED)
@Where(clause = "is_on = true")
@Table(name = "bookmark",
        indexes = {
                @Index(columnList = "member_id", name = "idx_bookmark__member_id"),
                @Index(columnList = "greeting_id", name = "idx_bookmark__greeting_id"),
                @Index(columnList = "member_id, greeting_id", name = "idx_bookmark__search_1")
        }
)
public class Bookmark {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "bookmark_id")
    private Long id;

    @Column(name = "member_id", nullable = false, columnDefinition = "BIGINT(20) UNSIGNED")
    @ColumnDefault("0")
    private Long memberId;

    @Column(name = "is_on", nullable = false, columnDefinition = "TINYINT(1) UNSIGNED")
    private Boolean isOn;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "greeting_id", nullable = false)
    private Greeting greeting;

    /* 생성 메소드 */
//    public static Bookmark createBookmark() {
//
//    }

}