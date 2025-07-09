package synchronize_asyschronize;

interface OnGeekEvenListener {
    void onGeekEvent();
}

class B {

    private OnGeekEvenListener mListener;

    public void registerOnGeekEventListener(OnGeekEvenListener listener) {
        this.mListener = listener;
    }

    // my synchronous task
    public void doGeekStuff() {

        // perform any operation
        System.out.println("Performing callback before synchronous Task");

        // check if listener is registered
        if (mListener != null) {
            mListener.onGeekEvent();
        }
    }
}

class C {
    private OnGeekEvenListener mListener;

    public void registerOnGeekEventListener(OnGeekEvenListener listener) {
        this.mListener = listener;
    }

    // My Asynchronous task
    public void doGeekStuff()
    {

        // An Async task always executes in new thread
        new Thread(new Runnable() {
            public void run()
            {

                // perform any operation
                System.out.println("Performing operation in Asynchronous Task");

                // check if listener is registered.
                if (mListener != null) {

                    // invoke the callback method of class A
                    mListener.onGeekEvent();
                }
            }
        }).start();
    }
}

class A implements OnGeekEvenListener {

    @Override
    public void onGeekEvent() {
        System.out.println("Performing callback after synchronous Task");
    }
}

public class AsynchronousSynchronousCallback {
    public static void main(String[] args)
    {
        B obj = new B();
        OnGeekEvenListener mListener = new A();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();

        C obj2 = new C();
        obj2.registerOnGeekEventListener(mListener);
        obj2.doGeekStuff();
    }
}
