#Mockito
- 가짜객체(mock object)를 통해 의존성을 분리하여 테스트하고자 하는 대상에만 집중할 수 있다
- 예를들어 Controller 테스트는 Service 에서 기대하는 값을 mock 객체를 통해 전달 받고 Controller 의 역할. 
즉, 요청에 따라 데이터를 view 로 반환해주는 역할의 테스트에만 집중할 수 있다