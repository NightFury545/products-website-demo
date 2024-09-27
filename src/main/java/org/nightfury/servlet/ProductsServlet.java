package org.nightfury.servlet;

import com.github.javafaker.Faker;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.nightfury.entity.Product;
import org.nightfury.repository.ProductRepository;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private final ProductRepository productRepository = new ProductRepository();
    private final Faker faker = new Faker();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        removeAllProductsFromRepository();
        try {
            fillRepositoryWithProducts(Integer.parseInt(request.getParameter("amount")));
        } catch (NumberFormatException e) {
            fillRepositoryWithProducts(10);
        }


        List<Product> products = productRepository.getProductsFromRepository();

        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/products.jsp");
        dispatcher.forward(request, response);
    }

    private void fillRepositoryWithProducts(int amount) {
        for (int i = 0; i < amount; i++) {
            Product product = ProductRepository.createProduct(faker.commerce().productName(),
                Double.parseDouble(faker.commerce().price().replace(',', '.')));
            productRepository.addProductToRepository(product);
        }
    }

    private void removeAllProductsFromRepository() {
        this.productRepository.removeAllProductsFromRepository();
    }
}
