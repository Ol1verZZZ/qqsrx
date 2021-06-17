package qqsrx.spring.boot.minidouban.domain;

public class Casting {
    private String imdbId;
    private String imdbArtistId;
    private String role;

    public Casting() {
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getImdbArtistId() {
        return imdbArtistId;
    }

    public String getRole() {
        return role;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setImdbArtistId(String imdbArtistId) {
        this.imdbArtistId = imdbArtistId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
