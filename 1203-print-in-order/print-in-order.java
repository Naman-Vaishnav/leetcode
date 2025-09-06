class Foo {
    private  int cur = 1;

    public Foo() {}

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (cur != 1) { wait(); } // spin wait
        printFirst.run();
        cur = 2;
        notifyAll();
    }

    public  synchronized void second(Runnable printSecond) throws InterruptedException {
        while (cur != 2) {  wait();} // spin wait
        printSecond.run();
        cur = 3;
         notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (cur != 3) {  wait(); } // spin wait
        printThird.run();
        notifyAll();
    }
}
