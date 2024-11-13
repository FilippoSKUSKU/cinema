package org.elis.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Quiz {
    @JsonProperty("response_code")
    private int responseCode;
    @JsonProperty("results")
    private List<Question> questions;

}
