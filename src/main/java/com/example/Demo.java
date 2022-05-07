package com.example;

import org.bson.types.ObjectId;

import java.util.Locale;
import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    static GamesRepository gamesRepository;
    static MusicasRepository musicasRepository;
    static UsersRepository usersRepository;
    static int opcion;
    static int opcionTable;

    public static void main(String[] args) {
        System.out.println("What database do you want to use: 1:MongoDB/ 2:MySQL");
        opcion = scanner.nextInt();
        if (opcion == 1) {
            gamesRepository = new GamesRepositoryMongo();
            musicasRepository = new MusicasRepositoryMongo();
            usersRepository = new UsersRepositoryMongo();
        } else if (opcion == 2) {
            gamesRepository = new GamesRepositorySQL();
            musicasRepository = new MusicasRepositorySQL();
            usersRepository = new UsersRepositorySQL();
        }
        System.out.println("What Table do you want to use: 1:Juegos/ 2:Musicas/3:Users");
        opcionTable = scanner.nextInt();

        if (opcionTable == 1) {
            gamesRepository.init();
            startAppJuegos();
        } else if ((opcionTable== 2)){
            musicasRepository.init();
            startAppMusicas();
        }else {
            usersRepository.init();
            startAppUsers();
        }
    }

    static void startAppJuegos() {
        while (true) {
            Games trainer;
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
            if (opcion == 1) {
                gamesRepository.getAll().stream().flatMap(Games::toMasterMongo).forEach(System.out::println);

            } else {
                gamesRepository.getAll().stream().flatMap(Games::toMaster).forEach(System.out::println);
            }

            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("Game title:");
                String title = scanner.next();
                System.out.print("Game year:");
                String year = scanner.next();
                System.out.print("Game description:");
                String description = scanner.next();

                if (opcion == 1) {
                    trainer = new Games(title, year, description, new ObjectId());
                } else {
                    trainer = new Games(title, year, description);
                }
                try {
                    gamesRepository.insert(trainer);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("Game title: ");
                String gameTitle = "";

                gameTitle = scanner.next();

                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New game title : ");
                    String newTitle = scanner.next();
                    System.out.print("New Game year : ");
                    String newYear = scanner.next();
                    System.out.print("New Game description : ");
                    String newDescription = scanner.next();

                    gamesRepository.update(new Games(newTitle, newYear, newDescription), gameTitle);


                } else if (option.equals("d")) {
                    gamesRepository.delete(gameTitle);
                }
            }
        }
    }

    static void startAppMusicas() {
        while (true) {
            Musicas musicas;
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
            if (opcion == 1) {
                musicasRepository.getAll().stream().flatMap(Musicas::toMasterMongo).forEach(System.out::println);

            } else {
                musicasRepository.getAll().stream().flatMap(Musicas::toMaster).forEach(System.out::println);

            }

            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("Musicas title:");
                String title = scanner.next();
                System.out.print("Musicas artist:");
                String artist = scanner.next();
                System.out.print("Musicas disk:");
                String disk = scanner.next();
                System.out.print("Musicas year:");
                String year = scanner.next();
                if (opcion == 1) {
                    musicas = new Musicas(title, artist, disk, year, new ObjectId());
                } else {
                    musicas = new Musicas(title, artist, disk, year);
                }


                try {
                    musicasRepository.insert(musicas);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("Musicas Name: ");
                String musicasName = "";

                musicasName = scanner.next();

                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New Musicas title : ");
                    String newTitle = scanner.next();
                    System.out.print("New Musicas artist : ");
                    String newArtist = scanner.next();
                    System.out.print("New Musicas disk : ");
                    String newDisk = scanner.next();
                    System.out.print("New Musicas year : ");
                    String newYear = scanner.next();

                    musicasRepository.update(new Musicas(newTitle, newArtist, newDisk, newYear), musicasName);

                } else if (option.equals("d")) {
                    musicasRepository.delete(musicasName);
                }
            }
        }
    }

    static void startAppUsers() {
        while (true) {
            Users user;
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
            usersRepository.getAll().stream().flatMap(Users::toMaster).forEach(System.out::println);

            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("PlayerName:");
                String playername = scanner.next();
                System.out.print("Username:");
                String username = scanner.next();
                System.out.print("Game 1 title:");
                String game1Title = scanner.next();
                System.out.print("Game 2 title:");
                String game2Title = scanner.next();
                System.out.print("Game 3 title:");
                String game3Title = scanner.next();


                user = new Users(playername, username, game1Title, game2Title, game3Title);

                try {
                    usersRepository.insert(user);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("playerName: ");
                String gameTitle = "";

                gameTitle = scanner.next();

                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New PlayerNae : ");
                    String newTitle = scanner.next();
                    System.out.print("New UserName : ");
                    String newYear = scanner.next();
                    System.out.print("New Game1Title : ");
                    String newDescription = scanner.next();
                    System.out.print("New Game2Title : ");
                    String newGame2Title = scanner.next();
                    System.out.print("New Game3Title : ");
                    String newGame3Title = scanner.next();

                    usersRepository.update(new Users(newTitle, newYear, newDescription, newGame2Title, newGame3Title), gameTitle);


                } else if (option.equals("d")) {
                    gamesRepository.delete(gameTitle);
                }
            }
        }
    }
}

