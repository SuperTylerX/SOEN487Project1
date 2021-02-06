package model;

public class Artist {

    private String nickname;
    private String firstName;
    private String lastname;
    private String bio;

    public Artist(String nickname, String firstName, String lastname, String bio) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastname = lastname;
        this.bio = bio;
    }

    public Artist(Artist artist) {
        this.nickname = artist.nickname;
        this.firstName = artist.firstName;
        this.lastname = artist.lastname;
        this.bio = artist.bio;
    }

    public Artist clone() {
        return new Artist(this);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "nickname='" + nickname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public String printName() {
        return "Artist{ nickname = '" + nickname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + "'}";
    }

}
