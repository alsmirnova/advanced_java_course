package PokemonFighting;

/**
 * Created by Алена on 10.11.2016.
 */
public class Trainer {
    Pokemon mypokemon;
    int hp, p;
    String PokemonName;

    public Pokemon MyPokemon() {

        mypokemon = new Pokemon(hp, p);
        //System.out.println(PokemonName + " "+ hp +" HP\n"+ p + " Power");
        return mypokemon;
    }


}
