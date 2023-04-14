package test.Api.pokemon.pokemonApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.Api.pokemon.pokemonApi.entity.Pokemon;
import test.Api.pokemon.pokemonApi.repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController //pour dire que c'est un controller qui renvoie des données
@CrossOrigin  //pour ne pas bloquer les requettes
public class PokemonController {

    @Autowired // une injection de dependance
    PokemonRepository pokemonRepository;


    //pour recuperer mes pokemons  GET
    @GetMapping("/getPokemon")
    public List<Pokemon> getPokemons() {
        return pokemonRepository.findAll();
    }


    //pour creer des pokemons   POST
    @PostMapping("/pokemon")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
     pokemonRepository.save(pokemon);
     return pokemon;
    }


    //pour recuperer un pokemon GET
 @GetMapping("/recupPokemon/{firstName}")
 public Pokemon recupPokemon(@PathVariable String firstName){

        return pokemonRepository.findByFirstName(firstName);
    }


// UPDATE PUT qui permet de modifier le nom du pokemon
@PutMapping("/modifPokemon/{name}")
public Pokemon modifPokemon(@PathVariable String name, @RequestBody Pokemon pokemon) {
    Pokemon modifier = pokemonRepository.findByFirstName(name);
    modifier.setFirstName(pokemon.getFirstName());
    pokemonRepository.save(modifier);
    return modifier;

}

//pour supprimer DELETE
   @DeleteMapping("/pokemon/{name}")
    public void deletePokemon(@PathVariable Long id){
     pokemonRepository.deleteById(id);
}

}
