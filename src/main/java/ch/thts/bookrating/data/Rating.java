package ch.thts.bookrating.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Rating {
    private Stars stars;
    private String comment;
}