# Mockito
- 가짜객체(mock object)를 통해 의존성을 분리하여 테스트하고자 하는 대상에만 집중할 수 있다
- 예를들어 Controller 테스트는 Service 에서 기대하는 값을 mock 객체를 통해 전달 받고 Controller 의 역할. 
즉, 요청에 따라 데이터를 view 로 반환해주는 역할의 테스트에만 집중할 수 있다

# JPA
- @Entity 어노테이션을 통해 Entity 클래스를 mark
- @Id - key 로 쓰일 필드
- @GeneratedValue - key 자동 생성 (@Id와 함께 쓰임)
- CrudRepository<엔티티클래스, 키> 를 extends 한 interface 만 정의하면 됨
- Entity update -> @Transactional => select - update 하면 select 해 온 객체를 update 함
- Transaction 범위를 벗어날 때, 업데이트를 한다.
- @Transient - 해당 필드를 저장하지 않음(DB에)
- @JsonInclude(JsonInclude.Include.NON_NULL) -> 해당 필드가 null 이면 표시하지 않음
- @JsonInclude(JsonInclude.Include.NON_DEFAULT) -> 해당 필드가 default 값이 아닐때만 출력

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

# Error
- @ControllerAdvice : 예외 처리
- @ResponseStatus(HttpStatus.NotFound) : 404 를 돌려줌

# Bulk Update
- 한번에 여러개를 수정
- PATCH /restaurants/{id}/menuitems => 특정 레스토랑의 메뉴를 변경

# 프로젝트 분리
- 프로젝트 분리시, 스프링 부트 2.0 이상에서는 인식시킬 공통 모듈에 build.gradle 설정에
    ```
    # jar file로 추가
    jar {
        enabled = true
    }
    
    bootJar {
        enabled = false
    } 
    ```
    를 추가해야 함

# gradle
```
./gradlew build
./gradlew clean test
```
- test 설정을 gradle 로 하고 전체 모듈 테스트를 인텔리제이와 같이 진행하면 intellij gui 로 같이 확인가능

# YAML
- application.properties => application.yml
- 간단한 형태로 configuration 정의
```
spring:
    datasource:
      url: jdbc:h2:~/data/eatgo
    jpa:
      hibernate:
        ddl-auto: update

# profile 설정 (하이픈- 세개 넣어줘야 함)
---

spring:
  profiles: test
  datasource:
    url: jdbc:h2:mem:test

```
- SPRING_PROFILES_ACTIVE=test 옵션을 gradle 실행시에 넣어줘서 profile 설정