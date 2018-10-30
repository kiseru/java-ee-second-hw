package com.alex.websocketdemo.uiservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatReplyDto {
    private String uuid;
    private String imageUrl;
}
