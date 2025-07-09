package synchronize_asyschronize;

class ThreadOne extends Thread{
    NonSynchronizedMethod nonSynchronizedMethod;

    public ThreadOne(NonSynchronizedMethod nonSynchronizedMethod) {
        this.nonSynchronizedMethod = nonSynchronizedMethod;
    }

    public void run() {
        nonSynchronizedMethod.printNumbers();
    }
}

class ThreadTwo extends Thread {
    NonSynchronizedMethod nonSynchronizedMethod;

    public ThreadTwo(NonSynchronizedMethod nonSynchronizedMethod) {
        this.nonSynchronizedMethod = nonSynchronizedMethod;
    }

    public void run() {
        nonSynchronizedMethod.printNumbers();
    }
}

public class TestSynchronization {
    public static void main(String[] args) {

        NonSynchronizedMethod nonSynchronizedMethod = new NonSynchronizedMethod();

        ThreadOne threadOne = new ThreadOne(nonSynchronizedMethod);
        threadOne.setName("ThreadOne");

        ThreadTwo threadTwo = new ThreadTwo(nonSynchronizedMethod);
        threadTwo.setName("ThreadTwo");

        threadOne.start();
        threadTwo.start();
    }
}
