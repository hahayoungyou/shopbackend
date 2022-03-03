package johayoung.shopbackend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@ToString
@Getter
@Setter
@Builder //빌더 패턴 !! 소프트웨어공학
@AllArgsConstructor  // 모든 필드 값을 파라미터로 받는 생성자 User user2 = new User("user2", "1234");
@NoArgsConstructor//파라미터가 없는 기본 생성자 User user1 = new User();
//@RequiredArgsConstructor //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 User user3 = new User(1L, "user3", "1234", null);
public class users {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "role")
    private int role;

}
