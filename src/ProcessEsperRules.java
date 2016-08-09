
public class ProcessEsperRules implements Step {
    private Thing thing;
    private CallBack callback;

    public ProcessEsperRules(Thing thing, CallBack callback) {
        this.thing = thing;
        this.callback = callback;
    }

    @Override
    public void run() {
	Log.log("Esper rules - thing id: " + thing.getId());
        try {
    	Thread.sleep(40);
        } catch (InterruptedException e) {
    	// nothing to do
        }
        if(callback!=null)
    	callback.completed(thing, Steps.UPDATECACHE);
    }
}