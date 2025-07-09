package synchronize_asyschronize;

public class NonSynchronizedMethod {

    // if this code don't have 'synchronized' keyword, everything can not synchronize
    // if yes, print orderly from one to two
//    public synchronized void printNumbers() {
//        System.out.println("Starting to print Numbers for " + Thread.currentThread().getName());
//
//        for (int i=0; i<5; i++) {
//            System.out.println(Thread.currentThread().getName() + i);
//        }
//
//        System.out.println("Completed printing Numbers for " + Thread.currentThread().getName());
//    }

    public void printNumbers() {
        synchronized (this) {
            System.out.println("Starting to print Numbers for " + Thread.currentThread().getName());

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            System.out.println("Completed printing Numbers for " + Thread.currentThread().getName());

        }
    }
}
