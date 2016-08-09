import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    private static long async(int numberOfTags){
	ExecutorService service = Executors.newFixedThreadPool(250);

	CallBackHandler loop = new CallBackHandler(service);
	
	Log.log("### async start ###");
	long t0 = System.currentTimeMillis();
	for (int i = 0; i < numberOfTags; i++) {
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
    
    private static long sync(int numberOfTags){
	Log.log("### sync start ###");
	long t0 = System.currentTimeMillis();
	for (int i = 0; i < numberOfTags; i++) {
	    String id = "" + (i + 1);
	    Thing thing = new Thing(id, id);
	    new CreateThing(thing, null).run();
	    new ProcessEsperRules(thing, null).run();
	    new UpdateCache(thing, null).run();
	}
	long t1 = System.currentTimeMillis();
	Log.log("### sync finished ###");
	return t1 - t0;
    }

    public static void main(String args[]) {
	int numberOfTags = 500;
	
	long async = async(numberOfTags);
	long sync = sync(numberOfTags);
	
	Log.log("For " + numberOfTags + " things");
	Log.log("Async took: " + async + " millis");
	Log.log("Sync took: " + sync + " millis");
    }
}
