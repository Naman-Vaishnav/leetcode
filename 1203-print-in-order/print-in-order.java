class Foo {
    int cur=1;
    Object lock = new Object();
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
         synchronized (lock) {
             while(cur!=1){
              lock.wait();   
            }
             printFirst.run();
            cur++;
            lock.notifyAll(); 

         }
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        synchronized (lock) {
             while(cur!=2){
              lock.wait();   
            }
             printSecond.run();
            cur++;
            lock.notifyAll(); 

         }
        
          
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        synchronized (lock) {
             while(cur!=3){
              lock.wait();   
            }
             printThird.run();
            cur++;
            lock.notifyAll(); 

         }
        
       
    }
}