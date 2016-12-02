package PokemonFighting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алена on 10.11.2016.
 */
public class Fighting {


    private static final String QUIT = "break";
    Pokemon Pokemon1;
    Pokemon Pokemon2;
    Trainer Trainer1;
    Trainer Trainer2;

    public void TrainersPokemon() {
        Trainer1 = new Trainer();
        Trainer2 = new Trainer();

    }

    public void Statistic() {
        System.out.println(Pokemon1.health + " HP   ||   " + Pokemon2.health + " HP");
        System.out.println(Pokemon1.power + " Power   ||   " + Pokemon2.power + " Power");
    }

    public int Winner() {
        if (Pokemon1.health <= 0 && Pokemon2.health > 0) {
            System.out.println(Trainer2.PokemonName + " win!!!");
        } else if (Pokemon2.health <= 0 && Pokemon1.health > 0) {
            System.out.println(Trainer1.PokemonName + " win!!!");
        } else if (Pokemon2.health <= 0 && Pokemon1.health <= 0) {
            System.out.println("No winner!");
        } else return 0;

        return 1;

    }

    public void TrainerCommand(Pokemon mypokemon, String command, int sub, Pokemon target) {

        switch (command) {
            case "1":
                mypokemon.BasicAttack(target);
                break;
            case "2":
                mypokemon.SpecialAttack(target);
                break;
            case "3":
                mypokemon.PowerfulAttack(target, sub);
            case "0":
                mypokemon.Pass();

        }

    }

    public void HELP() {
        System.out.print("For Basic Attack enter 1.\n" +
                "For Special Attack enter 2.\n" +
                "For Powerful Attack enter 3.\n" +
                "For Pass enter 0.\n\n");

    }


    public void play() {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String command;
            int p, hp;
            int num = 1;
            int sub = 0;

            TrainersPokemon();
            for (int k = 1; k < 3; k++) {
                System.out.println("Trainer " + k);
                System.out.println("Choose your Pokemon.");
                System.out.println("Enter the name of Pokemon: ");
                if (k == 1) {
                    Trainer1.PokemonName = lineReader.readLine();
                } else Trainer2.PokemonName = lineReader.readLine();
                System.out.println("Enter the hp (hit points) level: ");
                hp = Integer.parseInt(lineReader.readLine());
                p = hp / 2;
                System.out.println("The power level is half of hp: " + p);
                if (k == 1) {
                    Pokemon1 = Trainer1.MyPokemon();
                    Pokemon1.health = hp;
                    Pokemon1.power = p;
                } else {
                    Pokemon2 = Trainer2.MyPokemon();
                    Pokemon2.health = hp;
                    Pokemon2.power = p;
                }
                System.out.println();
            }

            System.out.println("Start the battle!");
            System.out.println(Trainer1.PokemonName + "     vs     " + Trainer2.PokemonName);

            command = ".";

            System.out.println("Press any button for start or type 'help'.\n");
            command = lineReader.readLine();
            if ("help".equals(command)) {
                HELP();
            }

            while ((!QUIT.equals(command)) && (Winner() == 0)) {
                sub = 0;
                Statistic();
                if (num % 2 != 0) {
                    System.out.print("Trainer 1. ");
                    System.out.print("Command for " + Trainer1.PokemonName + ": ");
                    command = lineReader.readLine();
                    System.out.println();
                    if (!QUIT.equals(command)) {
                        if (command.equals("3")) {
                            System.out.println("Current Power: " + Pokemon1.power + "   Enter the countpower for Powerful Attack:");
                            sub = Integer.parseInt(lineReader.readLine());
                        }
                        TrainerCommand(Pokemon1, command, sub, Pokemon2);
                        System.out.println();

                        num++;
                    }
                } else {
                    System.out.print("Trainer 2. ");
                    System.out.println("Command for " + Trainer2.PokemonName+ ": ");
                    command = lineReader.readLine();
                    System.out.println();
                    if (!QUIT.equals(command)) {
                        if (command.equals("3")) {
                            System.out.println("Current Power: " + Pokemon2.power + "   Enter the countpower for Powerful Attack:");
                            sub = Integer.parseInt(lineReader.readLine());
                        }
                        TrainerCommand(Pokemon2, command, sub, Pokemon1);
                        num++;
                        System.out.println();
                    }

                }


            }

            System.out.println("The battle is over!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        new Fighting().play();
    }

}
