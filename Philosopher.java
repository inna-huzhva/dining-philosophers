import java.util.Random;

public class Philosopher extends Thread {
  private int seat;
  private Fork left, right;

  public Philosopher(int seat, Fork left, Fork right) {
    this.seat = seat;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return "P" + seat;
  }

  @Override
  public void run() {
    Random r = new Random();
    while(true) {
      right.pickUp();
      System.out.println(toString() + " picked right");
      left.pickUp();
      System.out.println(toString() + " picked left");
      int eatingTime = r.nextInt(1800) + 200;
      System.out.println(toString() + " eating for " + eatingTime + "ms");
      try {
        Thread.sleep(eatingTime);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      right.putDown();
      System.out.println(toString() + " put down right");
      left.putDown();
      System.out.println(toString() + " put down left");
    }
  }
}
