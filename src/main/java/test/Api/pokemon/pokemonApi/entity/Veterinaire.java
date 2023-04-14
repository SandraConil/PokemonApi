package test.Api.pokemon.pokemonApi.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Veterinaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "veterinaire")
    private List<Pokemon> pokemon;

    public Veterinaire() {
    }

    public Veterinaire(String nom) {
        this.nom = nom;
         }

         //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
