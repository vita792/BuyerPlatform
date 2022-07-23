import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListOfProducts {

    Product firstProduct = new Product(1, "Apple", 1.89);
    Product secondProduct = new Product(2, "Cheese", 4.73);
    Product thirdProduct = new Product(3, "Ham", 9.25);

    List<Product> listOfProducts = new ArrayList<>();

    private List<Product> savedProducts() {

        listOfProducts.add(firstProduct);
        listOfProducts.add(secondProduct);
        listOfProducts.add(thirdProduct);
        return listOfProducts;

    }

    public List<Product> findAllProducts() {
        savedProducts();
        for (Product prod : listOfProducts) {
            System.out.println(prod);
        }
        return listOfProducts;
    }

    public Product findByIdProducts(int idProd) {
        if (idProd > listOfProducts.size() || idProd <= 0) {
            System.out.printf("To see all available products use '/show products'. Marketplace Application haven`t article %d.\n", idProd);
        } else {
            for (Product product : listOfProducts) {
                if (product.getId() == (idProd)) {
                    System.out.println(product);
                    return product;
                }
            }
        }
        return new Product();
    }

    @Override
    public String toString() {
        return "ListOfProducts {" +
                "firstProduct = " + firstProduct +
                ", secondProduct = " + secondProduct +
                ", thirdProduct = " + thirdProduct +
                ", listOfProducts = " + listOfProducts +
                '}';
    }
}
