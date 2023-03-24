import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product item1 = new Product(12, "Мыло", 120);
    Product item2 = new Product(2, "Сахар", 10);
    Product item3 = new Product(125, "Фасоль", 85);


    @Test
    public void shouldPointToAnException() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });


    }

    @Test
    public void shouldRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.removeById(2);
        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
}