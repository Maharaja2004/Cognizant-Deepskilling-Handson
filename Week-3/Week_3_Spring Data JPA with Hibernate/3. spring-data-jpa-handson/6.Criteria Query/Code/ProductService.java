package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Product> getFilteredProducts(Integer ramSize, String cpu, Integer hardDiskSize, String os, Double customerReview) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();

        if (ramSize != null) {
            predicates.add(cb.equal(product.get("ramSize"), ramSize));
        }
        if (cpu != null && !cpu.isEmpty()) {
            predicates.add(cb.equal(product.get("cpu"), cpu));
        }
        if (hardDiskSize != null) {
            predicates.add(cb.equal(product.get("hardDiskSize"), hardDiskSize));
        }
        if (os != null && !os.isEmpty()) {
            predicates.add(cb.equal(product.get("os"), os));
        }
        if (customerReview != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("customerReview"), customerReview));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }
}
