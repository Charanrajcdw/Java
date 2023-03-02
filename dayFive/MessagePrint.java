package dayFive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Message{
	public void message(String msg) {
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(msg);
	}
}

public class MessagePrint {
	public static void main(String[] args) {
		Message message=new Message();
		ExecutorService es=Executors.newFixedThreadPool(3);
		es.execute(()->{
			synchronized(message) {
				message.message("[------");				
				message.message("message1");
				message.message("------]");
			}
		});
		es.execute(()->{
			synchronized(message) {
				message.message("[------");				
				message.message("message2");
				message.message("------]");
			}
		});
		es.execute(()->{
			synchronized(message) {
				message.message("[------");				
				message.message("message3");
				message.message("------]");
			}
		});
		es.shutdown();
	}
}
