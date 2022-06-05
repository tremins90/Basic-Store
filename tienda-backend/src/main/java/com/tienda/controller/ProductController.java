package com.tienda.controller;

import com.tienda.dto.ProductDTO;
import com.tienda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.save(productDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> findAllProducts(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                            @RequestParam(value = "size", defaultValue = "10", required = false) int size) {
        //if product null return no content
        if (productService.findAllProducts(page, size).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productService.findAllProducts(page, size));
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long idProduct) {
        //if product null return no content
        if (productService.findById(idProduct) == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productService.findById(idProduct));
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO, @PathVariable Long idProduct) {
        //if product null return no content
        if (productService.findById(idProduct) == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productService.update(productDTO, idProduct));
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Void> delete(@PathVariable Long idProduct) {
        //if product null return no content
        if (productService.findById(idProduct) == null) {
            return ResponseEntity.noContent().build();
        }
        productService.delete(idProduct);
        return ResponseEntity.ok().build();
    }
}
