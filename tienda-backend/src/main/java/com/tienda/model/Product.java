package com.tienda.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product",uniqueConstraints = {@UniqueConstraint(columnNames = {"name_product"})})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "name_product", nullable = false, length = 50)
    private String nameProduct;

    @Column(name = "description_product", nullable = false, length = 50)
    private String descriptionProduct;

    @Column(name = "price_product", nullable = false)
    private double priceProduct;

    @Column(name = "stock_product", nullable = false)
    private int stockProduct;

    @Column(name = "status_product", nullable = false)
    private boolean statusProduct;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return idProduct != null && Objects.equals(idProduct, product.idProduct);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
