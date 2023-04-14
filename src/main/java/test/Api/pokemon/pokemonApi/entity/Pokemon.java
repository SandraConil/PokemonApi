package test.Api.pokemon.pokemonApi.entity;

import jakarta.persistence.*;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
     private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinaire_id")
    private Veterinaire veterinaire;

    public Pokemon() {
    }

    public Pokemon(String firstName, String type, Veterinaire veterinaire) {
        this.firstName = firstName;
        this.type = type;
        this.veterinaire = veterinaire;
    }

//getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    public void setVeterinaire(Veterinaire veterinaire) {
        this.veterinaire = veterinaire;
    }
}
