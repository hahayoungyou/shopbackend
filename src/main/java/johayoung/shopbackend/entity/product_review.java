package johayoung.shopbackend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="product_review")
@ToString
@Getter
@Setter
@Builder //빌더 패턴 !! 소프트웨어공학
@AllArgsConstructor  // 모든 필드 값을 파라미터로 받는 생성자 User user2 = new User("user2", "1234");
@NoArgsConstructor//파라미터가 없는 기본 생성자 User user1 = new User();
//@RequiredArgsConstructor //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 User user3 = new User(1L, "user3", "1234", null);
public class product_review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "product_id")
    private int product_id;

}
