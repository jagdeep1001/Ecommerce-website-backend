package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.model.Cart;
import com.caseStudy.eCart.model.Products;
import com.caseStudy.eCart.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Object findByUsersAndProducts(Users users, Products products);

    List<Cart> findByUsers(Users users);

    String deleteAllByUsersAndProducts(Users users, Products products);

    ArrayList<Cart> findAllByUsers(Users users);
}
