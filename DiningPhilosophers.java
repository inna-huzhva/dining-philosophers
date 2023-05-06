import java.util.concurrent.*; //For semaphore

public class DiningPhilosophers {
  private Fork[] forks;
  private Philosopher[] philosophers;

  public DiningPhilosophers(int n) {
    forks = new Fork[n];
    for (int i = 0; i < n; i++) {
      forks[i] = new Fork();
    }
    philosophers = new Philosopher[n];
    for (int i = 0; i < n; i++) {
      philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % n]);
    }
    // Fix by reversing stick order:
    philosophers[0] = new Philosopher(0, forks[1], forks[0]);
    for (Philosopher p : philosophers) {
      p.start();
    }
  }

  public static void main(String[] args) {
    new DiningPhilosophers(5);
  }
}
