package com.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hashtags")
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private int hashtagId;

    @Column(name = "hashtag_name", unique = true, length = 20)
    private String hashtagName;

    @OneToMany(mappedBy = "hashtag", cascade = CascadeType.ALL)
    private List<BoardHasHashtag> boardHashtags;
}
