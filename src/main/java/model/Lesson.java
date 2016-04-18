package model;


import javax.persistence.*;

/**
 * Created by Artur on 4/18/16.
 */
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String lessonId;

}
