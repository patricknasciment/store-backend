package com.patrick.store.repositories;

import com.patrick.store.domain.Product;
import com.patrick.store.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
