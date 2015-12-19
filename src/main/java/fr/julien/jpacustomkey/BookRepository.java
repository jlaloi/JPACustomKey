package fr.julien.jpacustomkey;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends PagingAndSortingRepository<Book, String> {

}