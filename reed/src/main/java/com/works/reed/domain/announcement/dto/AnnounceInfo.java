package com.works.reed.domain.announcement.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnounceInfo {
    private Long id;
    private String annTitle;
    private String annContent;
    private String regDate;
}
