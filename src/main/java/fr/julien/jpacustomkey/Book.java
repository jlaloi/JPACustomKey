package fr.julien.jpacustomkey;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GenericGenerator(name = "seq_id", strategy = "fr.julien.jpacustomkey.BookIdGenerator")
    @GeneratedValue(generator = "seq_id")
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
