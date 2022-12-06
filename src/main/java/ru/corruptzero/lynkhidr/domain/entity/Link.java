package ru.corruptzero.lynkhidr.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "links_generator")
    @SequenceGenerator(name = "links_generator", sequenceName = "links_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String url;
}
