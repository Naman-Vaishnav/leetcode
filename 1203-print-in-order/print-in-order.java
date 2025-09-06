class Foo {
    private volatile int cur = 1;

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        while (cur != 1) { } // spin wait
        printFirst.run();
        cur = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (cur != 2) { } // spin wait
        printSecond.run();
        cur = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (cur != 3) { } // spin wait
        printThird.run();
    }
}
