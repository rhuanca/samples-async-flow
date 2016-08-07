import java.util.concurrent.ExecutorService;

public class CallBackHandler implements CallBack {

    private ExecutorService service;

    public CallBackHandler(ExecutorService service) {
	this.service = service;
    }

    @Override
    public void completed(Thing thing, Steps next) {
	if (next != null) {
	    switch (next) {
	    case CREATE:
		service.execute(new CreateThing(thing, CallBackHandler.this));
		break;
	    case ESPER:
		service.execute(new ExecuteSperRules(thing, CallBackHandler.this));
		break;
	    case UPDATECACHE:
		service.execute(new ExecuteUpdateCache(thing, CallBackHandler.this));
		break;
	    default:
		break;
	    }
	} else {
	    if (thing.getId().equals("kill")) {
		Log.log("killing process");
		service.shutdown();
	    }
	}
    }
}