package test.Api.pokemon.pokemonApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.Api.pokemon.pokemonApi.entity.Pokemon;

import java.util.List;

@Repository // indique à Spring que cette classe est le lien entre notre application et la base de données
public interface PokemonRepository extends JpaRepository <Pokemon, Long> {
    Pokemon findByFirstName(String firstName);
}
