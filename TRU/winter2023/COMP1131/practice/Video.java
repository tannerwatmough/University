public class Video {
  private String vName;
  private int vYear;

  public Video() {
    vName = "null";
    vYear = 1900;
  }

  public Video(String name, int year) {
    vName = name;
    vYear = year;
  }

  public String getName() {
    return this.vName;
  }

  public void setName(String name) {
    vName = name;
  }

  public int getYear() {
    return this.vYear;
  }

  public void setYear(int year) {
    vYear = year;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Video)) {
      return false;
    }

    Video video = (Video) obj;

    String vidOneName = this.getName();
    String vidTwoName = video.getName();

    int vidOneYear = this.getYear();
    int vidTwoYear = video.getYear();

    if (vidOneName.equals(vidTwoName) && vidOneYear == vidTwoYear) {
      return true;
    } else {
      return false;
    }

  }
}