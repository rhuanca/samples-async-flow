
public class CreateThing implements Step {
    private Thing thing;
    private CallBack callback;

    public CreateThing(Thing thing, CallBack callback) {
        this.thing = thing;
        this.callback = callback;
    }

    @Override
    public void run() {
	Log.log("Insert thing - thing id: " + thing.getId());
        try {
    	Thread.sleep(20);
        } catch (InterruptedException e) {
    	// nothing to do
        }
        if(callback!=null)
    	callback.completed(thing, Steps.ESPER);
    }
}