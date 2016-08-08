import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    private final static int MAX = 500;

    private static long async(){
	ExecutorService service = Executors.newFixedThreadPool(50);

	CallBackHandler loop = new CallBackHandler(service);
	
	Log.log("### async start ###");
	long t0 = System.currentTimeMillis();
	for (int i = 0; i < MAX; i++) {
	    String id = "" + (i + 1);
	    Thing thing = new Thing(id, id);
	    service.execute(new EnterFlow(thing, loop));
	}
	service.execute(new EnterFlow(new Thing("kill", "kill"), loop));
	while(!service.isTerminated());
	
	long t1 = System.currentTimeMillis();
	Log.log("### async end ###");
	return t1 - t0;
    }
    
    private static long sync(){
	Log.log("### sync start ###");
	long t0 = System.currentTimeMillis();
	for (int i = 0; i < MAX; i++) {
	    String id = "" + (i + 1);
	    Thing thing = new Thing(id, id);
	    new CreateThing(thing, null).run();
	    new ExecuteSperRules(thing, null).run();
	    new ExecuteUpdateCache(thing, null).run();
	}
	long t1 = System.currentTimeMillis();
	Log.log("### sync finished ###");
	return t1 - t0;
    }

    public static void main(String args[]) {
	long async = async();
	long sync = sync();
	
	Log.log("For " + MAX + " things");
	Log.log("Async took: " + async + " millis");
	Log.log("Sync took: " + sync + " millis");
    }
}
