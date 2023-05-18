//
//import com.github.javafaker.Faker;
//import common.Article;
//import common.Client;
//import common.CompraException;
//import common.ICarroCompra;
//import common.ITenda;
//import common.Lookups;
//import javax.naming.NamingException;
//import org.apache.logging.log4j.LogManager;
//import org.junit.jupiter.api.AfterAll;
//import static org.junit.jupiter.api.Assertions.fail;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//
//
///**
// * Verifica diferents situacions anomales:
// * 
// * - alta de nou client incorrecte
// * - passem un client incorrecte a l'iniciar sessió
// * - afegir el mateix article varis cops
// * - intentem afegir un article inexistent
// * 
// * @author manel
// */
//public class TestErrors {
//    
//   static ICarroCompra carro;
//       
//   static ITenda tenda;
//   
//   static Faker faker;
//   
//   static String idSessio;
//   
//   private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestValidacio.class);
//
//    
//   @BeforeAll
//   public static void inici()
//   {
//       try {
//           
//          faker = new Faker();
//           
//          carro = Lookups.carroCompraEJBRemoteLookup();
//          
//          tenda = Lookups.tendaEJBRemoteLookup();
//           
//       } catch (NamingException ex) {
//           logger.error("Error iniciant: " + ex);
//           fail();
//       }
//   }
//   
//   @AfterAll
//   public static void fi()
//   {
//       
//   }
//    
//   @Test
//   public void test2()
//   {   
//       Article a1, a2, a3, a4;
//   
//       Client cli;
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
//            a2.setDescripcio("Minuature: The " + faker.harryPotter().character() + " dancing with a " + faker.animal().name() + " at " + faker.harryPotter().location()) ;
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
//            //alta de nou client incorrecte
//            cli = new Client();
//            cli.setNom(faker.name().fullName());
//            cli.setLogin(null);
//            
//           try {
//               // si el client previament no existeix, l'afegim
//               if (!tenda.validaClient(cli.getLogin())) {                   
//                   logger.info("Alta de client... " + cli);
//                   tenda.addClient(cli.getLogin(), cli.getNom());
//                   
//               }
//               
//               fail();
//               
//            } catch (CompraException ex) {
//                  logger.info("Error controlat"); 
//            }
//           
//           try {
//               
//                // passem un client incorrecte a l'iniciar sessió
//
//                idSessio = carro.getSessio(null);
//            
//                fail();
//               
//            } catch (CompraException ex) {
//                logger.info("Error controlat"); 
//            }
//           
//            //alta de nou client correcte
//            cli = new Client();
//            cli.setNom(faker.name().fullName());
//            cli.setLogin(faker.name().firstName().substring(0, 4));
//            
//            if (!tenda.validaClient(cli.getLogin())) {                   
//                   logger.info("Alta de client... " + cli);
//                   tenda.addClient(cli.getLogin(), cli.getNom());   
//               }
//            
//             idSessio = carro.getSessio(cli.getLogin());
//           
//            // hem de poder afegir el mateix article varis cops
//            carro.addArticle(a1);
//            carro.addArticle(a1);
//            carro.addArticle(a1);
//            
//            //intentem afegir un article inexistent
//            a4 = new Article();
//            a4.setId(Long.MAX_VALUE);
//            
//            try {
//                carro.addArticle(a4);
//
//                 fail();
//
//            } catch (CompraException compraException) {
//                logger.info("Error controlat"); 
//            }
//            
//            // finalitzem compra
//            long idCompra = carro.finalitzaCompra();
//            
//            logger.info("Compra finalitzda amb id: " + idCompra); 
//            
//            // ====================================================
//
//           
//       } catch (CompraException ex) {
//           logger.error("ERROR Compra Exception: " + ex);
//           fail();
//       } catch (Exception ex) {
//           logger.error("ERROR: " + ex);
//           fail();
//       }
//   }
//}
