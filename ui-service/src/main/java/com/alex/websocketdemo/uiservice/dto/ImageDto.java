package com.alex.websocketdemo.uiservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageDto {
    private Long userId;
    private String imageUrl;
}
