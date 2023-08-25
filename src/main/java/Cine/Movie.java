package Cine;

public class Movie {

    private String tittle;
    private int length;
    private int minimunAge;
    private String directorName;

    public Movie(String tittle, int length, int minimunAge, String directorName) {
        this.tittle = tittle;
        this.length = length;
        this.minimunAge = minimunAge;
        this.directorName = directorName;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMinimunAge() {
        return minimunAge;
    }

    public void setMinimunAge(int minimunAge) {
        this.minimunAge = minimunAge;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
