package app.unittesting;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

@Slf4j
public class CompletableFutureCompleteTest {

  @Test
  void testCompleteAsync() throws ExecutionException, InterruptedException {
    CompletableFuture<String> comp = new CompletableFuture<>();
    Consumer<String> cons = comp::complete;
    new Thread(() -> runAsync(cons)).start();
    while (!comp.isDone()) {}
    Assertions.assertEquals("completed after 2 secs", comp.get());
    log.info(comp.get());
  }

  @SneakyThrows
  private void runAsync(Consumer cons) {
    Thread.sleep(2000);
    cons.accept("completed after 2 secs");
    log.info("after complete");
  }
}
