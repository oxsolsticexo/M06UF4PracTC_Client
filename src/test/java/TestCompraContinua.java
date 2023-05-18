//
//import com.github.javafaker.Faker;
//import javax.naming.NamingException;
//import common.Article;
//import common.Client;
//import common.CompraException;
//import common.ICarroCompra;
//import common.ITenda;
//import common.Lookups;
//import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;
//import org.apache.logging.log4j.LogManager;
//import org.junit.jupiter.api.AfterAll;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
///**
// * Realitza compres continues
// * 
// * @author manel
// */
//public class TestCompraContinua {
//    
//   static ICarroCompra carro;
//       
//   static ITenda tenda;
//   
//   static Faker faker;
//   
//   static String idSessio;
//   
//   static Integer maxArticles;
//   
//   static Integer maxCompras;
//   
//   
//   private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestValidacio.class);
//
//    
//   @BeforeAll
//   public static void inici()
//   {
//        try {
//
//           faker = new Faker();
//
//           tenda = Lookups.tendaEJBRemoteLookup();
//           
//           carro = Lookups.carroCompraEJBRemoteLookup();
//
//           Random r = new Random();
//
//           maxArticles = r.nextInt(1, 50);
//
//           maxCompras = r.nextInt(1, 100);
//
//           logger.info("Generant " + maxCompras + " compres a " + maxArticles + " articles  per compra...");
//           
//           /***
//            * Consulta els missatges del carro de la compra a cada x temps
//            */
//           TimerTask timerTask = new MyTimerTask(carro);
//            //running timer task as daemon thread
//           Timer timer = new Timer(true);
//           timer.scheduleAtFixedRate(timerTask, 0, 1000); //cada segon
//           System.out.println("TimerTask started");
//
//           } catch (NamingException ex) {
//              logger.error("Error iniciant: " + ex);
//              fail();
//           }
//   }
//   
//   @AfterAll
//   public static void fi()
//   {
//       
//   }
//    
//   @Test
//   public void testNonStop()
//   {   
//       Article a1;
//   
//       Client cli;
//       
//       try {
//            for (int compras = 0; compras < maxCompras; compras++)
//            {
//            
//                //alta de nou client correcte
//                cli = new Client();
//                cli.setNom(faker.name().fullName());
//                cli.setLogin(faker.name().firstName().substring(0, 4));
//
//                if (!tenda.validaClient(cli.getLogin())) {
//                       tenda.addClient(cli.getLogin(), cli.getNom());   
//                }
//
//                idSessio = carro.getSessio(cli.getLogin());
//
//                for (int articles = 0; articles < maxArticles; articles++)
//                {
//                    // alta i recuperem id
//                    a1 = new Article();
//                    a1.setDescripcio("Book: Learn " + faker.programmingLanguage().name() + " for my " + faker.animal().name() + ". By: "  + faker.funnyName().name());
//                    a1.setPreuEuros(faker.number().numberBetween(10, 100));
//                    a1.setId(tenda.addArticle(a1.getDescripcio(), a1.getPreuEuros()));
//                    logger.info("Alta d'article: " + a1);
//
//                    Thread.sleep(1);
//
//                    carro.addArticle(a1);
//                }
//
//                // finalitzem compra
//                long idCompra = carro.finalitzaCompra();
//               
//            }
//           
//       } catch (CompraException ex) {
//           logger.error("ERROR Compra Exception: " + ex);
//           fail();
//       } catch (Exception ex) {
//           logger.error("ERROR: " + ex);
//           fail();
//       }
//       
//      assertTrue(true); 
//    }
//
//   /***
//    * Classe necessària per a generar un thread independent que consulta
//    * els missatges del servidor i els mostra per consola
//    */
//    static class MyTimerTask extends TimerTask 
//    {
//
//        ICarroCompra c;
//
//        @Override
//        public void run() {
//
//            while (c.pendingMessages() > 0)
//            {
//                System.out.println("MISSATGE DEL SERVIDOR: [  " + c.getMessage() + " ]");
//            }
//
//        }
//
//        public MyTimerTask(ICarroCompra _c) {
//
//            this.c = _c;
//
//        }
//    }
//
//}
