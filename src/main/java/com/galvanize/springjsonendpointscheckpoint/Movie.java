package com.galvanize.springjsonendpointscheckpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
    @JsonProperty ("Title")
    private String title;
    @JsonProperty ("Minutes")
    private Integer minutes;
    @JsonProperty ("Genre")
    private String genre;
    @JsonProperty ("Rating")
    private Float rating;
    @JsonProperty ("Metascore")
    private Integer metascore;
    @JsonProperty ("Description")
    private String description;
    @JsonProperty ("Votes")
    private Integer votes;
    @JsonProperty ("Gross")
    private float gross;
    @JsonProperty ("Year")
    private Date year;
    @JsonProperty ("Credits")
    private ArrayList<Crew> credits = new ArrayList<Crew>();

    public void addCrew(String role, String firstName, String lastName) {
        HashMap<String, String> person = new HashMap<>();
        person.put("Role", role);
        person.put("FirstName", firstName);
        person.put("LastName", lastName);
        Crew crew = new Crew();
        crew.setPerson(person);
        this.credits.add(crew);
    }

    public ArrayList<Crew> getCrew() { return this.credits; }

    @JsonFormat(pattern = "yyyy")
    public Date getYear() { return year; }
    public void setYear(Date year) { this.year = year; }

    public float getGross() { return gross; }
    public void setGross(float gross) { this.gross = gross; }

    public Integer getVotes() { return votes; }
    public void setVotes(Integer votes) { this.votes = votes; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getMetascore() { return metascore; }
    public void setMetascore(Integer metascore) { this.votes = metascore; }

    public Float getRating() { return rating; }
    public void setRating(Float rating) { this.rating = rating; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Integer getMinutes() { return minutes; }
    public void setMinutes(Integer minutes) { this.minutes = minutes; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public class Crew {
        private HashMap<String, String> person = new HashMap<>();
    
        public HashMap<String, String> getPerson() { return person; }
        public void setPerson(HashMap<String, String> person) { this.person = person; }
    }

    @GetMapping ("/movies/movie")
    public List<Movie> getMovie() {
        Movie movie1 = new Movie ();
        movie1.setTitle("The Godfather");
        movie1.setMinutes(175);
        movie1.setGenre("Crime, Drama");
        movie1.setRating(9.2F);
        movie1.setMetascore(100);
        movie1.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movie1.setVotes(1561591);
        movie1.setGross(134.97f);
        //movie1.setYear(19720101);
        return Arrays.asList(movie1);
    }

}