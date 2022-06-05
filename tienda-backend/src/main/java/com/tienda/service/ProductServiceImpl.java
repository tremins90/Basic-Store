package com.tienda.service;

import com.tienda.Exception.ResourceNotFoundException;
import com.tienda.dto.ProductDTO;
import com.tienda.model.Product;
import com.tienda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        // convert to DTOToEntity
        Product product = mapEntity(productDTO);
        // save to BD
        Product newProduct = productRepository.save(product);
        // convert to EntityToDTO and return
        return mapDto(newProduct);
    }

    @Override
    public List<ProductDTO> findAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Product> products = productRepository.findAll(pageable).getContent();
        return products.stream().map(this::mapDto).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapDto(product);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        product.setNameProduct(productDTO.getNameProduct());
        product.setPriceProduct(productDTO.getPriceProduct());
        product.setStockProduct(productDTO.getStockProduct());
        product.setStatusProduct(productDTO.isStatusProduct());
        product.setDescriptionProduct(productDTO.getDescriptionProduct());
        productRepository.save(product);
        return mapDto(product);
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }


    //method convert entity to dto
    private ProductDTO mapDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdProduct(product.getIdProduct());
        productDTO.setNameProduct(product.getNameProduct());
        productDTO.setDescriptionProduct(product.getDescriptionProduct());
        productDTO.setPriceProduct(product.getPriceProduct());
        productDTO.setStockProduct(product.getStockProduct());
        productDTO.setStatusProduct(product.isStatusProduct());

        return productDTO;
    }
    //method convert dto to entity
    private Product mapEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setIdProduct(productDTO.getIdProduct());
        product.setNameProduct(productDTO.getNameProduct());
        product.setDescriptionProduct(productDTO.getDescriptionProduct());
        product.setPriceProduct(productDTO.getPriceProduct());
        product.setStockProduct(productDTO.getStockProduct());
        product.setStatusProduct(productDTO.isStatusProduct());

        return product;
    }

}
