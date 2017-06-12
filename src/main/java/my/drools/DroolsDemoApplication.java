package my.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroolsDemoApplication {

	public static void main(String[] args) {

		System.out.println("Inside the Spring Boot : DroolsDemoApplication");
		SpringApplication.run(DroolsDemoApplication.class, args);

		System.out.println("Inside the Spring Boot : DroolsDemoApplication Executing the rules");


		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			// go !
			Account account = new Account(200);
			account.withdraw(150);
			kSession.insert(account);
			kSession.fireAllRules();

		} catch (Throwable t) {
			t.printStackTrace();
		}


	}
}
