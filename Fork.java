import java.util.concurrent.*;

public class Fork {
  private Semaphore semaphore = new Semaphore(1);

  public void pickUp() {
    try {
      semaphore.acquire(); // Блокує якщо недоступний
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void putDown() { 
    semaphore.release(); // Дає доступ
  }
}
