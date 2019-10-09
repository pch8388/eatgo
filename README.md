# Mockito
- 가짜객체(mock object)를 통해 의존성을 분리하여 테스트하고자 하는 대상에만 집중할 수 있다
- 예를들어 Controller 테스트는 Service 에서 기대하는 값을 mock 객체를 통해 전달 받고 Controller 의 역할. 
즉, 요청에 따라 데이터를 view 로 반환해주는 역할의 테스트에만 집중할 수 있다

# JPA
- @Entity 어노테이션을 통해 Entity 클래스를 mark
- @Id - key 로 쓰일 필드
- @GeneratedValue - key 자동 생성 (@Id와 함께 쓰임)
- CrudRepository<엔티티클래스, 키> 를 extends 한 interface 만 정의하면 됨
- Entity update -> @Transactional => select - update 하면 select 해 온 객체를 update함
- Transaction 범위를 벗어날 때, 업데이트를 한다.

# Node Js
``` npm init ```

# webpack
``` npm install --save-dev webpack webpack-cli webpack-dev-server ```

# CROS
- Spring Controller -> @CrossOrigin 추가

# Lombok
- 어노테이션을 붙이면 특정한 코드를 만들어주는 역할
- @Setter, @Getter 
- @Builder : 빌더 패턴
- @NoArgsConstructor : 디폴트 생성자를 만들어 줌

# Validation
- @NotNull, @NotEmpty, @Size(max=10)
- @Valid
- 400 Bad Request - 사용자가 입력을 잘못 했을경우
- 간단한 경우 valid, invalid 두개 정도의 테스트를 함
- 복잡한 검증이 필요할 경우 테스트를 여러개로 만들어야 함