package com.patrick.store.config;

import com.patrick.store.domain.*;
import com.patrick.store.domain.enums.ClientType;
import com.patrick.store.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "informática");
        Category cat2 = new Category(null, "eletronicos");
        categoryRepository.saveAll(List.of(cat1, cat2));

        Product p1 = new Product(null, "Radio", 2000.00);
        Product p2 = new Product(null, "Computador", 6000.00);
        Product p3 = new Product(null, "Mouse", 400.00);

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat1);

        cat1.getProducts().addAll(List.of(p1, p3));
        cat2.getProducts().add(p2);

        productRepository.saveAll(List.of(p1, p2, p3));
        categoryRepository.saveAll(List.of(cat1, cat2));

        State state1 = new State(null, "Minas Gerais");
        State state2 = new State(null, "São Paulo");

        City city1 = new City(null, "Uberlândia", state1);
        City city2 = new City(null, "Campinas", state2);
        City city3 = new City(null, "Mogi Mirim", state2);

        state1.getCities().add(city1);
        state2.getCities().addAll(List.of(city2, city3));

        stateRepository.saveAll(List.of(state1, state2));
        cityRepository.saveAll(List.of(city1, city2, city3));

        Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "11111111111", ClientType.PESSOAFISICA);
        cli1.getPhones().addAll(List.of("999999999", "888888888"));

        Address ad1 = new Address(null, "Rua Pescador", "99", "Macacos", "99999999", "casa", cli1,city1);
        Address ad2 = new Address(null, "Rua Jovial", "33", "Lambaris", "29299299", "ap", cli1,city2);

        cli1.getAddresses().addAll(List.of(ad1, ad2));

        clientRepository.save(cli1);
        addressRepository.saveAll(List.of(ad1,ad2));
    }
}
