package com.example.eva_testtask.dao.impl;

import com.example.eva_testtask.dao.ProductDao;
import com.example.eva_testtask.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory factory;

    public ProductDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Product add(Product product) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to add product " + product, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Product> getByName(String name) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(Product.class, name));
        } catch (Exception e) {
            throw new NoSuchElementException("Can`t find product with name " + name);
        }
    }

    @Override
    public List<Product> getAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Product", Product.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all products from db");
        }
    }
}
