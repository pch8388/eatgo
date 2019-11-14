package me.study.eatgo.interfaces;

import me.study.eatgo.application.UserService;
import me.study.eatgo.domain.User;
import me.study.eatgo.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    private final JwtUtil jwtUtil;

    private final UserService userService;

    public SessionController(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(
        @RequestBody SessionRequestDto resource
    ) throws URISyntaxException {

        String email = resource.getEmail();
        String password = resource.getPassword();

        User user = userService.authenticate(email, password);

        String accessToken = jwtUtil.createToken(user.getId(), user.getName());

        String url = "/session";
        return ResponseEntity.created(new URI(url)).body(
                SessionResponseDto.builder()
                    .accessToken(accessToken)
                    .build());
    }
}
