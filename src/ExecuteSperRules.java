
public class ExecuteSperRules implements Step {
    private Thing thing;
    private CallBack callback;

    public ExecuteSperRules(Thing thing, CallBack callback) {
        this.thing = thing;
        this.callback = callback;
    }

    @Override
    public void run() {
	Log.log("Esper rules - thing id: " + thing.getId());
        try {
    	Thread.sleep(20);
        } catch (InterruptedException e) {
    	// nothing to do
        }
        if(callback!=null)
    	callback.completed(thing, Steps.UPDATECACHE);
    }
}