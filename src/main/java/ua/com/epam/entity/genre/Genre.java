package ua.com.epam.entity.genre;

public class Genre {


    private Long genreId;

    private String genreName;

    private String genreDescription;

    public Genre() {
    }

    public Genre(Long genreId, String genreName, String genreDescription) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.genreDescription = genreDescription;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (genreId != null ? !genreId.equals(genre.genreId) : genre.genreId != null) return false;
        if (genreName != null ? !genreName.equals(genre.genreName) : genre.genreName != null) return false;
        return genreDescription != null ? genreDescription.equals(genre.genreDescription) : genre.genreDescription == null;
    }

    @Override
    public int hashCode() {
        int result = genreId != null ? genreId.hashCode() : 0;
        result = 31 * result + (genreName != null ? genreName.hashCode() : 0);
        result = 31 * result + (genreDescription != null ? genreDescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", genreDescription='" + genreDescription + '\'' +
                '}';
    }
}
