package com.tienda.service;

import com.tienda.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public ProductDTO save(ProductDTO productDTO);

    public List<ProductDTO> findAllProducts(int page, int size);

    public ProductDTO findById(Long id);

    public ProductDTO update(ProductDTO productDTO, Long id);

    public void delete(Long id);


}
