
public class UpdateCache implements Step {

    private Thing thing;
    private CallBack callback;

    public UpdateCache(Thing thing, CallBack callback) {
        this.thing = thing;
        this.callback = callback;
    }

    @Override
    public void run() {
	Log.log("Update cache - thing id: " + thing.getId());
        try {
    	Thread.sleep(40);
        } catch (InterruptedException e) {
    	// nothing to do
        }
        if(callback!=null)
    	callback.completed(thing, null);
    }
}