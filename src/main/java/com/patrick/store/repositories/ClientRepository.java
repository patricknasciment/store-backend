package com.patrick.store.repositories;

import com.patrick.store.domain.Address;
import com.patrick.store.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
