package by.denisova.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Story extends AbstractEntity {

    private Long editorId;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
}
