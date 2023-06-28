package org.marco.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/8/9 21:45
 */
public class CompleteFurterMain {

	public static void main(String[] args) {
		int i = Runtime.getRuntime().availableProcessors();
		System.out.println("可用处理器数量 ： " + i);
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10);
		long currentTime = System.currentTimeMillis();
		List<CompletableFuture<Integer>> futureList = integerList.stream()
				.map(CompleteFurterMain::getRamdon)
				.map(f->f.thenApplyAsync((random)->{
					System.out.println(Thread.currentThread().getName() + " 打印价格 " + random.longValue());
					return random;
				}))
//				.map(f->f.thenCompose())
				.collect(Collectors.toList());

		futureList.stream()
				.map(CompletableFuture::join)
				.forEach(System.out::println);
		System.out.println("耗时：" + (System.currentTimeMillis() - currentTime) + "s");
	}

	private static CompletableFuture<Integer> getRamdon(Integer integer) {
		CompletableFuture<Integer> completedFuture = new CompletableFuture<>();
		new Thread(() -> {
			Random random = new Random();
			int sleepSecond = random.nextInt(6);
			System.out.println(Thread.currentThread().getName() + " sleep " + sleepSecond + " s");
			try {
				TimeUnit.SECONDS.sleep(sleepSecond);
				Integer result = sleepSecond * integer;
				completedFuture.complete(result);
			} catch (InterruptedException e) {
				e.printStackTrace();
				completedFuture.completeExceptionally(e);
			}
		}).start();
		return completedFuture;
	}

}
