package com.example.mobilestore.Repository;

import com.example.mobilestore.Model.CartDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends CrudRepository<CartDetail, Long> {
}
