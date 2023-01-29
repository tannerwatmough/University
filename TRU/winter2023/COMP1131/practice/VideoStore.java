public class VideoStore {
  public static void main(String[] args) {
    Video video1 = new Video("Hogwarts", 2001);
    Video video2 = new Video("Not Hogwarts", 2002);

    System.out.println(video1.getName());
    System.out.println(video1.getYear());
    System.out.println(video2.getName());
    System.out.println(video2.getYear());

    System.out.println(video1.equals(video2));

    video2.setName("Hogwarts");

    System.out.println(video1.getName());
    System.out.println(video1.getYear());
    System.out.println(video2.getName());
    System.out.println(video2.getYear());

    System.out.println(video1.equals(video2));

    video2.setYear(2001);

    System.out.println(video1.getName());
    System.out.println(video1.getYear());
    System.out.println(video2.getName());
    System.out.println(video2.getYear());

    System.out.println(video1.equals(video2));

  }
}