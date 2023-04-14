package test.Api.pokemon.pokemonApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.Api.pokemon.pokemonApi.entity.Pokemon;
import test.Api.pokemon.pokemonApi.entity.Veterinaire;
import test.Api.pokemon.pokemonApi.repository.PokemonRepository;
import test.Api.pokemon.pokemonApi.repository.VeterinaireRepository;

import java.util.List;

@RestController
@CrossOrigin
public class VeterinaireController {
    @Autowired
    VeterinaireRepository veterinaireRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    //pour creer des veterinaires   POST
    @PostMapping("/veterinaire")
    public Veterinaire addVeterinaire(@RequestBody Veterinaire veterinaire){
        veterinaireRepository.save(veterinaire);
        return veterinaire;
    }

    @RequestMapping(value = "deleteveterinaire/{nom}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVeterinaire(@PathVariable String name){
        if(veterinaireRepository.findByName(name) != null){
            // pour eviter tout conflit si ce veterinaire est en charge de pokémon je supprime leur veto associé
            Veterinaire myVeto = veterinaireRepository.findByName(name);
            List<Pokemon> pokemons = pokemonRepository.findAllPokemonByVeterinaire(myVeto.getId());
            for(Pokemon poke : pokemons){
                // je leur met un vétérinaire sans propriété pour les délié de mon veterinaire
                poke.setVeterinaire(null);
                pokemonRepository.save(poke);
            }

            // je peux maintenant supprimer mon veterinaire
            veterinaireRepository.deleteById(myVeto.getId());
            return new ResponseEntity<>("le veterinaire a été supprimé", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("un veterinaire n'existant pas ne peut pas être supprimé",HttpStatus.BAD_REQUEST);
        }

    }


}
