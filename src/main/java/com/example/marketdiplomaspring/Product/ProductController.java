package com.example.marketdiplomaspring.Product;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("")
    public Iterable<Product> getProduct()
    {
        ProductService productService = new ProductService();

        return productService.getProducts(this.productRepository);
    }

    @GetMapping("/{id}")
    public Object getProductById(@PathVariable Long id)
    {
        ProductService productService = new ProductService();

        return productService.getProductById(this.productRepository, id);
    }

    @PostMapping("")
    public Product addProduct(@RequestBody Product product) {

        ProductService productService = new ProductService();

        return productService.addProduct(this.productRepository, product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product,  @PathVariable Long id) {

        ProductService productService = new ProductService();

        return productService.updateProduct(this.productRepository,product, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        ProductService productService = new ProductService();

        String response = productService.deleteProduct(this.productRepository, id);

        return response;
    }
}
