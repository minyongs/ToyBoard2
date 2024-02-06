package org.example.toyboard2.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.ImmutableEntityEntry;


@Getter
@Setter
public class SiteUserDTO {

    @Size(min = 3, max = 25)
    @NotEmpty(message = "ID는 필수 입력 사항입니다.")
    private String userName;


    @NotEmpty(message = "비밀번호는 필수입력 사항입니다.")
    private String password;


    @NotEmpty(message = "비밀번호는 필수입력 사항입니다.")
    private String password2;


    @NotEmpty(message = "이메일은 필수 입력 사항입니다.")
    @Email
    private String email;

}
