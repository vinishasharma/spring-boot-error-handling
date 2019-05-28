package com.example.errorhandlingapp.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.couchbase.core.mapping.Document;

//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.mapping.Document;

/*cassandra repo*/
//@Getter
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@Builder(toBuilder = true)
//@AllArgsConstructor
//@Table("employee")
//public class Employee {
//
//    @PrimaryKey(value = "id")
//    int id;
//
//    @Column
//    String name;
//
//    @Column
//    String city;
//
//    @Column
//    int age;
//}


/*Mongo repo*/
//@Document
//@Getter
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@Builder(toBuilder = true)
//@AllArgsConstructor
//public class Employee {
//
//    @Id
//    ObjectId id;
//
//    String name;
//
//    String city;
//
//    int age;
//}


/*couchbase repo*/
@Document
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Employee {

    @Id
    int id;

    @Field
    String name;

    @Field
    String city;

    @Field
    int age;
}