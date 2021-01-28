
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlbumClient albumClient = new AlbumClient();
        ArtistClient artistClient=new ArtistClient();
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while (num != -1) {
            System.out.println("\r\n\r\nPlease input an integer for different item: -1 to quit the client");
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
                    artistClient.get_all_artist();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 1) {//1 for Create new artist
                System.out.println("1.Create new artist. Please input some info");
                System.out.print("Firstname: ");
                String firstname = new Scanner(System.in).nextLine();
                System.out.print("Lastname: ");
                String lastname = new Scanner(System.in).nextLine();
                System.out.print("Nickname: ");
                String nickname = new Scanner(System.in).nextLine();
                System.out.print("Bio: ");
                String bio = new Scanner(System.in).nextLine();
                try {
                    artistClient.create_new_artist(nickname, firstname, lastname, bio);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 2) {//2 for Get artists by nickname
                System.out.println("2 for Get artists by nickname");
                System.out.print("Nickname: ");
                String nickname = new Scanner(System.in).nextLine();
                try {
                    artistClient.get_artist_by_nickname(nickname);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 3) {//3 for Update artist
                System.out.println("3.Update artist. Please input some info");
                System.out.print("Firstname: ");
                String firstname = new Scanner(System.in).nextLine();
                System.out.print("Lastname: ");
                String lastname = new Scanner(System.in).nextLine();
                System.out.print("Nickname: ");
                String nickname = new Scanner(System.in).nextLine();
                System.out.print("Bio: ");
                String bio = new Scanner(System.in).nextLine();
                try {
                    artistClient.update_artist(nickname, firstname, lastname, bio);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (num == 4) {//4 for Delete artist
                System.out.println("4 for delete artists by nickname");
                System.out.print("Nickname: ");
                String nickname = new Scanner(System.in).nextLine();
                try {
                    artistClient.del_artist_by_nickname(nickname);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (num == 5) {//5 for Get all albums
                try {
                    albumClient.get_all_albums();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 6) {//6 for Get albums by isrc
                System.out.println("6 for Get albums by isrc:");
                System.out.print("isrc: ");
                String isrc = new Scanner(System.in).nextLine();
                try {
                    albumClient.get_album_by_isrc(isrc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 7) {//7 for Create new album
                System.out.println("7 for Create new album. Please input some info");
                System.out.print("isrc: ");
                String isrc = new Scanner(System.in).nextLine();
                System.out.print("title: ");
                String title = new Scanner(System.in).nextLine();
                System.out.print("description: ");
                String description = new Scanner(System.in).nextLine();
                System.out.print("artist: ");
                String artist = new Scanner(System.in).nextLine();
                System.out.print("Year: ");
                int year = sc.nextInt();
                try {
                    albumClient.create_new_album(isrc, title, description, artist, year);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (num == 8) {//8 for update album
                System.out.println("8 for update album. Please input some info");
                System.out.print("isrc: ");
                String isrc = new Scanner(System.in).nextLine();
                System.out.print("title: ");
                String title = new Scanner(System.in).nextLine();
                System.out.print("description: ");
                String description = new Scanner(System.in).nextLine();
                System.out.print("artist: ");
                String artist = new Scanner(System.in).nextLine();
                System.out.print("Year: ");
                int year = sc.nextInt();
                try {
                    albumClient.update_album(isrc, title, description, artist, year);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (num == 9) {//9 for delete album
                System.out.println("9 for delete album by isrc:");
                System.out.print("isrc: ");
                String isrc = new Scanner(System.in).nextLine();
                try {
                    albumClient.del_album_by_isrc(isrc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("quit the client, thank you");
    }
}
