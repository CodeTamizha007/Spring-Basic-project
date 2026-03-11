package com.sd.sdshop.apis.products;


import com.sd.sdshop.apis.Entitys.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepocitory productRepocitory;

    public List<ProductResponseDTO> getProdusts() {
        List<Products> products =  productRepocitory.findAll();
        List<ProductResponseDTO>  prodsResponce= new ArrayList<ProductResponseDTO>();
        for(Products prod : products){
            ProductResponseDTO proResDTO = new ProductResponseDTO(prod.getProductId(), prod.getProductName(), prod.getProductImage(),prod.getProductQuantity(),
                    prod.getProductDescription(),prod.getProductPrice(),prod.getActualPrice(),prod.getDiscount());
            prodsResponce.add(proResDTO);
        }
        return prodsResponce;
    }


    public ProductResponseDTO addProducts(ProductRequestDTO productRequestDTO, MultipartFile image) throws IOException {
        Products product = new Products(productRequestDTO.getProductName(),image.getBytes(),productRequestDTO.getProductQuantity(),productRequestDTO.getProductDescription(),productRequestDTO.getProductPrice(),productRequestDTO.getActualPrice(),productRequestDTO.getDiscount());

        Products prod = productRepocitory.save(product);

         return  new ProductResponseDTO(prod.getProductId(),prod.getProductName(),prod.getProductImage(),prod.getProductQuantity(),prod.getProductDescription(),prod.getProductPrice(),prod.getActualPrice(),prod.getDiscount());
    }

    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        Products product = new Products(productRequestDTO.getProductName(),productRequestDTO.getProductQuantity(),productRequestDTO.getProductDescription(),productRequestDTO.getProductPrice(),productRequestDTO.getActualPrice(),productRequestDTO.getDiscount());

        Products prod = productRepocitory.save(product);

        return  new ProductResponseDTO(prod.getProductId(),prod.getProductName(),prod.getProductImage(),prod.getProductQuantity(),prod.getProductDescription(),prod.getProductPrice(),prod.getActualPrice(),prod.getDiscount());
    }

    public ProductResponseDTO getProduct(String id) {

        Products product = productRepocitory.findByProductId(id);
        return new ProductResponseDTO(product.getProductId(),product.getProductName(),product.getProductImage(),product.getProductQuantity(),product.getProductDescription(),product.getProductPrice(),product.getActualPrice(),product.getDiscount());
    }

    public Boolean deleteproduct(String id) {
        Products product = productRepocitory.findByProductId(id);
        if(product != null){
            productRepocitory.deleteByProductId(id);
            return true;
        }
        return false;
    }
}
