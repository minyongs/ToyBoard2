package org.example.toyboard2.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileDTO {

    private String userName;
    private List<QuestionDTO> questionDTOS;
}
