package com.artyompanfutov.telegram.countdownbot.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.OffsetDateTime;

@Entity
@Table(name = "countdown", schema = "public")
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Countdown {
    @Id
    @SequenceGenerator(name="hibernate_sequence", sequenceName = "hibernate_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "time_stamp")
    private OffsetDateTime timeStamp;
}
