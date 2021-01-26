
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientFunction cf = new ClientFunction();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (num != -1) {
            System.out.println("Please input an integer for different item: -1 to quit the client");
            System.out.println("0 for Get all artists");
            System.out.println("1 for Create new artist");
            System.out.println("2 for Get artists by nickname");
            System.out.println("3 for Update artist");
            System.out.println("4 for Delete artist");
            System.out.println("5 for Get all albums");
            System.out.println("6 for Get albums by isrc");
            System.out.println("7 for Create new album");
            System.out.println("8 for update album");
            System.out.println("9 for delete album");
            num = sc.nextInt();

            if (num == 0) {
                try {
                    cf.get_all_artist();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 1) {//1 for Create new artist
                System.out.println("1.Create new artist. Please input some info");
                System.out.println("Firstname: ");
                String firstname = sc.nextLine();
                System.out.println("Lastname: ");
                String lastname = sc.nextLine();
                System.out.println("Nickname: ");
                String nickname = sc.nextLine();
                System.out.println("Bio: ");
                String bio = sc.nextLine();
                try {
                    cf.create_new_artist(nickname, firstname, lastname, bio);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 2) {//2 for Get artists by nickname
                System.out.println("2 for Get artists by nickname");
                System.out.println("Nickname: ");
                String nickname = sc.nextLine();
                try {
                    cf.get_artist_by_nickname(nickname);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 3) {//3 for Update artist
                System.out.println("3.Update artist. Please input some info");
                System.out.println("Firstname: ");
                String firstname = sc.nextLine();
                System.out.println("Lastname: ");
                String lastname = sc.nextLine();
                System.out.println("Nickname: ");
                String nickname = sc.nextLine();
                System.out.println("Bio: ");
                String bio = sc.nextLine();
                try {
                    cf.update_artist(nickname, firstname, lastname, bio);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (num == 4) {//4 for Delete artist
                System.out.println("4 for delete artists by nickname");
                System.out.println("Nickname: ");
                String nickname = sc.nextLine();
                try {
                    cf.del_artist_by_nickname(nickname);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (num == 5) {//5 for Get all albums
                try {
                    cf.get_all_albums();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 6) {//6 for Get albums by isrc
                System.out.println("6 for Get albums by isrc:");
                System.out.println("isrc: ");
                String isrc = sc.nextLine();
                try {
                    cf.get_album_by_isrc(isrc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 7) {//7 for Create new album
                System.out.println("7 for Create new album. Please input some info");
                System.out.println("isrc: ");
                String isrc = sc.nextLine();
                System.out.println("title: ");
                String title = sc.nextLine();
                System.out.println("description: ");
                String description = sc.nextLine();
                System.out.println("artist: ");
                String artist = sc.nextLine();
                System.out.println("Year: ");
                int year = sc.nextInt();
                try {
                    cf.create_new_album(isrc, title, description, artist, year);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (num == 8) {//8 for update album
                System.out.println("8 for update album. Please input some info");
                System.out.println("isrc: ");
                String isrc = sc.nextLine();
                System.out.println("title: ");
                String title = sc.nextLine();
                System.out.println("description: ");
                String description = sc.nextLine();
                System.out.println("artist: ");
                String artist = sc.nextLine();
                System.out.println("Year: ");
                int year = sc.nextInt();
                try {
                    cf.update_album(isrc, title, description, artist, year);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 9) {//9 for delete album
                System.out.println("9 for delete album by isrc:");
                System.out.println("isrc: ");
                String isrc = sc.nextLine();
                try {
                    cf.del_album_by_isrc(isrc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("quit the client, thank you");
    }
}
