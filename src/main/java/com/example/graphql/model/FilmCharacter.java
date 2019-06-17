package com.example.graphql.model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import java.util.Set;

import lombok.Data;

@Entity
@Data
public class FilmCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CharacterType characterType;

    private String homePlanet;

    /**
     * Eagerly fetches a list of friends ids.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "CharacterFriend",
            joinColumns = @JoinColumn(name = "CharacterId"))
    @Column(name = "FriendId")
    private Set<Long> friendsIds;

    @ElementCollection(targetClass = Episode.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "MovieAppearance")
    @Column(name = "episode")
    private Set<Episode> appearsIn;

}
