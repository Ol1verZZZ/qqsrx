package qqsrx.spring.boot.minidouban.domain;

public class Artist {
    private String imdbArtistId;
    private String gender;
    private String birthDate;
    private String birthPlace;
    private String chineseName;
    private String foreignName;
    private String artistIntroduction;

    public String getChineseName() {
        return chineseName;
    }

    public String getGender() {
        return gender;
    }

    public String getArtistIntroduction() {
        return artistIntroduction;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getForeignName() {
        return foreignName;
    }

    public String getImdbArtistId() {
        return imdbArtistId;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setArtistIntroduction(String artistIntroduction) {
        this.artistIntroduction = artistIntroduction;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public void setImdbArtistId(String imdbArtistId) {
        this.imdbArtistId = imdbArtistId;
    }
}
