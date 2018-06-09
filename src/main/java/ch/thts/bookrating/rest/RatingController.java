package ch.thts.bookrating.rest;

import ch.thts.bookrating.data.Rating;
import ch.thts.bookrating.data.Stars;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RestController
@RequestMapping("/api")
public class RatingController {

    @GetMapping("ratings/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable("id") long id) {
        final Rating rating = new Rating();
        rating.setStars(Stars.FIVE);
        rating.setComment("xyz");
        log.info("returning Rating {}", rating);
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }

}
