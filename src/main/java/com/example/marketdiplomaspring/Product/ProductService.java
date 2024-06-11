package com.example.marketdiplomaspring.Product;

public class ProductService {

    public Iterable<Product> getProducts(ProductRepository productRepository) {
        return productRepository.findAll();
    }

    public Object getProductById(ProductRepository productRepository, Long id) {

        return productRepository.findById(id);
    }

    public Product addProduct(ProductRepository productRepository, Product product) {

        return productRepository.save(product);
    }

    public Product updateProduct(ProductRepository productRepository, Product new_product, Long id) {

        return productRepository.findById(id)
                .map(product -> {
                    product.setName(new_product.getName());
                    product.setCategory_id(new_product.getCategory_id());
                    product.setDescription(new_product.getDescription());
                    product.setPrice(new_product.getPrice());
                    product.setImage_url(new_product.getImage_url());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    new_product.setId(id);
                    return productRepository.save(new_product);
                });
    }

    public String deleteProduct(ProductRepository productRepository, Long id) {
        Object finded_product = productRepository.findById(id);
        if (finded_product != null) {
            productRepository.deleteById(id);
            return "Product deleted";
        }else {
            return "Product not found";
        }



    }
}
