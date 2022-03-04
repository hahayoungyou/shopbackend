package johayoung.shopbackend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="board")
@ToString
@Getter
@Setter
@Builder //빌더 패턴 !! 소프트웨어공학
@AllArgsConstructor  // 모든 필드 값을 파라미터로 받는 생성자 User user2 = new User("user2", "1234");
@NoArgsConstructor//파라미터가 없는 기본 생성자 User user1 = new User();
//@RequiredArgsConstructor //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 User user3 = new User(1L, "user3", "1234", null);
public class board {
    //건의사항 백엔드 테스트 하느라 추가해놓은 것 활용하기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "wridate")
    private String wridate;

    @Column(name = "writer")
    private String writer;

    @Column(name = "count")
    private int count;

    @Column(name = "filename")
    private String filename;
}
