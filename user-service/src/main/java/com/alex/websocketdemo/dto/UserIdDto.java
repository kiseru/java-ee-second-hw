package com.alex.websocketdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserIdDto {
    private Long userId;
    private String userUuid;
}
