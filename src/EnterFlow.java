
public class EnterFlow implements Step {
    private Thing thing;
    private CallBack callback;

    public EnterFlow(Thing thing, CallBack callback) {
        this.thing = thing;
        this.callback = callback;
    }

    @Override
    public void run() {
        Log.log("Entering flow - thing id: " + thing.getId());
        callback.completed(thing, Steps.CREATE);
    }

}