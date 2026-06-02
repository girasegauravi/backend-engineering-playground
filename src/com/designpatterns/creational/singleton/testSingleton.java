import com.designpatterns.creational.singleton.DoubleCheckedLockingSingleton;
import com.designpatterns.creational.singleton.EagerSingleton;
import com.designpatterns.creational.singleton.LazySingleton;
import com.designpatterns.creational.singleton.SynchronizedSingleton;

import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Supplier;

public static <T> void testSingleton(
        String singletonName,
        Supplier<T> supplier
) throws Exception {

    int THREAD_COUNT = 10;

    ExecutorService executorService =
            Executors.newFixedThreadPool(THREAD_COUNT);

    Set<Integer> instanceHashCodes =
            ConcurrentHashMap.newKeySet();

    CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

    System.out.println("\n================================================");
    System.out.println("Testing : " + singletonName);
    System.out.println("================================================");

    for (int i = 0; i < THREAD_COUNT; i++) {

        Runnable task = () -> {

            try {

                T instance = supplier.get();

                int hash = System.identityHashCode(instance);

                instanceHashCodes.add(hash);

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> Instance Hash : " + hash
                );

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        };
        executorService.execute(task);
    }

    latch.await();

    executorService.shutdown();

    System.out.println("\nUnique Instance Count : "
            + instanceHashCodes.size());

    if (instanceHashCodes.size() == 1) {
        System.out.println("VALIDATION PASSED");
        System.out.println("Only ONE instance exists");
    } else {
        System.out.println("VALIDATION FAILED");
        System.out.println("Multiple instances created");
    }
}

void main() throws Exception {

        /*
        -------------------------------------------------------
        1. EAGER SINGLETON TEST
        -------------------------------------------------------
        */
    testSingleton(
            "Eager Singleton",
            EagerSingleton::getInstance
    );

        /*
        -------------------------------------------------------
        2. LAZY SINGLETON TEST
        -------------------------------------------------------
        NOTE:
        Sometimes race condition may not happen depending
        on timing.

        To FORCE issue in interview/demo:
        add Thread.sleep inside if(instance == null)
        -------------------------------------------------------
        */
    testSingleton(
            "Lazy Singleton (NOT Thread Safe)",
            LazySingleton::getInstance
    );

        /*
        -------------------------------------------------------
        3. SYNCHRONIZED SINGLETON TEST
        -------------------------------------------------------
        */
    testSingleton(
            "Synchronized Singleton",
            SynchronizedSingleton::getInstance
    );

        /*
        -------------------------------------------------------
        4. DOUBLE CHECKED LOCKING TEST
        -------------------------------------------------------
        */
    testSingleton(
            "Double Checked Locking Singleton",
            DoubleCheckedLockingSingleton::getInstance
    );
}