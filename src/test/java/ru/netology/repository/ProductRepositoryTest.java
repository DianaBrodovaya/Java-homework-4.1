package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();

  private Book book1 = new Book(1, "bookName1", 230, "author1", 120, 2020);
  private Book book2 = new Book(2, "bookName2", 123, "author2", 240, 2019);
  private Book book3 = new Book(3, "bookName3", 321, "author3", 360, 2018);

  @Test
  public void shouldRemoveById(){
      repository.save(book1);
      repository.save(book2);
      repository.save(book3);

      repository.removeById(book2.getId());

      assertNull(repository.findById(book2.getId()));
  }

  @Test
  public void shouldRemoveByIdWithException(){
    repository.save(book1);
    repository.save(book2);

    assertThrows(NotFoundException.class, () -> repository.removeById(book3.getId()));
  }
}
