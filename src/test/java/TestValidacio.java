//
//import com.github.javafaker.Faker;
//import common.Article;
//import common.Client;
//import common.Compra;
//import common.CompraException;
//import common.ICarroCompra;
//import common.ITenda;
//import common.Lookups;
//import java.util.Date;
//import java.util.List;
//import javax.naming.NamingException;
//import org.apache.commons.lang3.time.DateUtils;
//import org.apache.logging.log4j.LogManager;
//import org.junit.jupiter.api.AfterAll;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInfo;
//
//
//
///**
// * Verifica diverses situacions correctes:
// * 
// * Alta d'articles
// * Alta de clients
// * Compra d'articles
// * Finalització de compra
// *  
// * @author manel
// * 
// * https://github.com/wildfly/jboss-ejb-client/blob/4.0/javax/src/main/java/org/jboss/ejb/protocol/remote/EJBClientChannel.java
// * 
// */
//public class TestValidacio {
//    
//   /***
//    * ens proporciona mètodes que ens permeten gestionar un carro de la compra.
//    * Des del moment que connectem, ens manté l'estat de les dades fins que ens desconnectem
//    */
//    static ICarroCompra carro;
//   
//   /***
//    * Ens proporciona mètodes remots que realitzen diverses funcions
//    * Similar a mètodes estàtics d'una classe
//    */
//   static ITenda tenda;
//   
//   static Faker faker;
//   
//   private TestInfo testInfo;
//   
//   private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestValidacio.class);
//
//   @BeforeEach
//   public void init(TestInfo testInfo) {
//       this.testInfo = testInfo;
//   }
//    
//   @BeforeAll
//   public static void inici()
//   {
//       try {
//           
//          // generador de dades fake
//          faker = new Faker();
//          
//          // ontenim una instància remota de la classe CarroCompraEJB
//          carro = Lookups.carroCompraEJBRemoteLookup();
//          
//          // obntenim una instància remota de la classe TendaEJB
//          tenda = Lookups.tendaEJBRemoteLookup();
//           
//       } catch (NamingException ex) {
//           logger.error("Error iniciant: " + ex);
//           fail();
//       }
//   }
//   
//   
//    
//   @Test
//   public void test1()
//   {   
//       
//       System.out.println("TEST: " + testInfo.getDisplayName());
//        
//        
//       Article a1, a2, a3;
//   
//       Client cli, cli2;
//       
//       try {
//           
//            a1 = new Article();
//            a2 = new Article();
//            a3 = new Article();
//            
//            logger.info("Nova compra"); 
//            
//            logger.info("Preparem articles i client"); 
//           
//            // alta i recuperem id
//            a1.setDescripcio("Book: Learn " + faker.programmingLanguage().name() + " for my " + faker.animal().name() + ". By: "  + faker.funnyName().name());
//            a1.setPreuEuros(faker.number().numberBetween(10, 100));
//            a1.setId(tenda.addArticle(a1.getDescripcio(), a1.getPreuEuros()));
//            logger.info("Alta d'article: " + a1);
//            
//            // alta i recuperem id
//            a2.setDescripcio("Miniature: The " + faker.harryPotter().character() + " dancing with a " + faker.animal().name() + " at " + faker.harryPotter().location()) ;
//            a2.setPreuEuros(faker.number().numberBetween(10, 100));
//            a2.setId(tenda.addArticle(a2.getDescripcio(), a2.getPreuEuros()));
//            logger.info("Alta d'article: " + a2);
//            
//            // alta i recuperem id
//            a3.setDescripcio("Pack of " + faker.food().fruit() + " and " + faker.food().dish());
//            a3.setPreuEuros(faker.number().numberBetween(10, 100));
//            a3.setId(tenda.addArticle(a3.getDescripcio(), a3.getPreuEuros()));
//            logger.info("Alta d'article: " + a3);
//            
//            logger.info("Llistant tots els articles...");
//            tenda.getArticles().forEach(x-> logger.info(x));
//            
//            //verifica login incorrecte
//            String idSessio;
//            
//            //alta nou client
//            cli = new Client();
//            cli.setNom(faker.name().firstName()+" "+faker.name().lastName());
//            cli.setLogin(cli.getNom().substring(0,5).replace(" ", "a"));
//           
//            // si el client previament no existeix, l'afegim
//            if (! tenda.validaClient(cli.getLogin()))
//            { 
//               logger.info("Alta de client... " + cli);
//               tenda.addClient(cli.getLogin(), cli.getNom());
//              
//            }
//            
//            // comencem a comprar fent "login"
//            logger.info("Iniciem compra de: " + cli); 
//            idSessio = carro.getSessio(cli.getLogin());
//            
//            // afegim articles
//            carro.addArticle(a1);
//            carro.addArticle(a2);
//            carro.addArticle(a3);
//            
//            // finalitzem compra
//            long idCompra = carro.finalitzaCompra();
//            
//            logger.info("Compra finalitzda amb id: " + idCompra); 
//            
//            // ====================================================
//            
//             logger.info("Nova compra"); 
//             
//            logger.info("Preparem articles i client"); 
//            
//             // alta i recuperem id
//            a1.setDescripcio(faker.beer().name());
//            a1.setPreuEuros(faker.number().numberBetween(10, 100));
//            a1.setId(tenda.addArticle(a1.getDescripcio(), a1.getPreuEuros()));
//            logger.info("Alta d'article: " + a1);
//            
//            // alta i recuperem id
//            a2.setDescripcio(faker.beer().name());
//            a2.setPreuEuros(faker.number().numberBetween(10, 100));
//            a2.setId(tenda.addArticle(a2.getDescripcio(), a2.getPreuEuros()));
//            logger.info("Alta d'article: " + a2);
//            
//            // alta i recuperem id
//            a3.setDescripcio(faker.beer().name());
//            a3.setPreuEuros(faker.number().numberBetween(10, 100));
//            a3.setId(tenda.addArticle(a3.getDescripcio(), a3.getPreuEuros()));
//            logger.info("Alta d'article: " + a3);
//            
//            logger.info("Llistant tots els articles...");
//            tenda.getArticles().forEach(x-> logger.info(x));
//            
//            //alta nou client
//            cli2 = new Client();
//            cli2.setNom(faker.name().firstName()+" "+faker.name().lastName());
//            cli2.setLogin(cli2.getNom().substring(0,5).replace(" ", "a"));
//           
//            // si el client previament no existeix, l'afegim
//            if (! tenda.validaClient(cli2.getLogin()))
//            { 
//               logger.info("Alta de client... " + cli2);
//               tenda.addClient(cli2.getLogin(), cli2.getNom());
//              
//            }
//            
//            // iniciem compra fent "login"
//            logger.info("Iniciem compra de: " + cli2);
//            
//            idSessio = carro.getSessio(cli2.getLogin());
//            
//            // afegim articles
//            carro.addArticle(a1);
//            carro.addArticle(a2);
//            carro.addArticle(a3);
//            
//            // finalitzem compra
//            idCompra = carro.finalitzaCompra();
//            
//            logger.info("compra finalitzda amb id: " + idCompra); 
//            
//            // ====================================================
//            
//            logger.info("Obtenim compra amb ID: " + idCompra);
//            
//            Compra c = tenda.getCompra(idCompra);
//            
//            logger.info("Detall compra: " + c);
//            
//            Date d1 = DateUtils.addMinutes(new Date(),-1);
//            Date d2 = DateUtils.addMinutes(new Date(),1);
//            
//            logger.info("Obtenim compra de " + cli.getLogin() + " entre dues dates: "+ d1 +" : " + d2);
//            
//            List<Compra> llista = tenda.getCompra(cli.getLogin(), d1, d2);
//            
//            logger.info(llista.toString());
//            
//            logger.info("Obtenim compra de " + cli2.getLogin() + " entre dues dates: "+ d1 +" : " + d2);
//            
//            llista = tenda.getCompra(cli2.getLogin(), d1, d2);
//            
//            logger.info(llista.toString());
//            
//            logger.info("Tanquem la comunicació i alliberem EJB remot..."); 
//            
//            carro.tancaSessio();
//            
//            assertTrue(true); 
//           
//       } catch (CompraException ex) {
//           logger.error("ERROR Compra Exception: " + ex.toString());
//           fail();
//       } catch (Exception ex) {
//           logger.error("ERROR: " + ex.toString());
//           fail();
//       }
//   }
//   
//   @AfterAll
//   public static void fi()
//   {
//       
//   }
//}
