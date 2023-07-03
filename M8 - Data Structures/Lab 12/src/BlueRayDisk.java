public class BlueRayDisk {

  public String title;
  public String director;
  public int yearOfRelease;
  public double cost;

  BlueRayDisk(String title, String director, int yearOfRelease, double cost) {
    this.title = title;
    this.director = director;
    this.yearOfRelease = yearOfRelease;
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "$" + cost + " " + yearOfRelease + " " + title + ", " + director;
  }
}
