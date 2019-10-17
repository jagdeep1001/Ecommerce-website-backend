package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.model.Users;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);

    Users findByUserId(Long user_id);

    Users getByEmail(String name);
}
