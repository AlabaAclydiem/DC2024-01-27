package by.bsuir.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {

    private Long id;
    private String title;
    private String content;
    private Timestamp created;
    private Timestamp modified;
    private Long userId;
    private Long stickerId;
}
