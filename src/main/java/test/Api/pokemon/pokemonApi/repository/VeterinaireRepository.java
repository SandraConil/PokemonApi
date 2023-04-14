package test.Api.pokemon.pokemonApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.Api.pokemon.pokemonApi.entity.Veterinaire;

public interface VeterinaireRepository extends JpaRepository<Veterinaire,Long> {
    Veterinaire findByName(String nom);
}
