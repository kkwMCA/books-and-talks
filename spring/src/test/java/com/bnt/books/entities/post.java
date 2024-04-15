package com.bnt.books.entities;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "post")
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer post_id;

    @Column(name = "post_name", nullable = false, length = 10)
    private String com_id;
    private String image;
    private String data;
    private String description;
    private Timestamp datetime;

}

/*
 * @Entity annotation: is used to mark this class as a JPA entity.
 * It indicates that instances of this class will be mapped to database records.
 * 
 * @Table(name = "table_name")
 * make sure this matches the actual table name in DB
 * 
 * @Id : indicites the primary key.
 * Every JPA enttity should have the primary key.
 * 
 * @GeneratedValue :
 * This annotation specifies how to the primary key values are generated on
 * auto-incrementation
 * 
 * @Column : used to map a class field to a database column.
 * 
 * @NoArgsConstructor : No Argument Constructor (Lombok)
 * 
 * @Getter (Lombok)
 * 
 * @Setter (Lombok)
 */
