package com.sd.sdshop.apis.products;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    private  ProductService productService;

    @GetMapping("products")
    public List<ProductResponseDTO> products(){
        return productService.getProdusts();
    }

    @PostMapping("products")
    public ProductResponseDTO addProduct(@RequestPart ProductRequestDTO product, @RequestPart MultipartFile image) throws IOException {
        return productService.addProducts(product,image);
    }

    @PostMapping("product")
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO product){
        return productService.addProduct(product);
    }

    @GetMapping("product/{id}")
    public ProductResponseDTO getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }
}








