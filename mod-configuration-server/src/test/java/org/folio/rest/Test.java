package org.folio.rest;

import org.folio.rest.client.AdminClient;
import org.folio.rest.client.TenantClient;
import org.folio.rest.jaxrs.model.TenantAttributes;





/**
 * @author shale
 *
 */
public class Test {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {

    AdminClient aClient = new AdminClient("localhost", 8888, "harvard", "harvard", false);
    TenantClient tClient = new TenantClient("localhost", 8888, "harvard", "harvard", false);

/*    MimeMultipart mmp = new MimeMultipart();
    BodyPart bp = new MimeBodyPart(new FileInputStream("C:\\Git\\mod-files\\ramls\\mod-files\\files.raml"));
    bp.setDisposition("form-data");
    bp.setFileName("abc.raml");
    BodyPart bp2 = new MimeBodyPart(new FileInputStream("C:\\Git\\mod-files\\ramls\\mod-files\\files.raml"));
    bp2.setDisposition("form-data");
    bp2.setFileName("abcd.raml");
    mmp.addBodyPart(bp);
    mmp.addBodyPart(bp2);

    aClient.postUploadmultipart(PersistMethod.SAVE, null, "abc",
      mmp, reply -> {
      reply.statusCode();
    });*/

    aClient.getModuleStats( res -> {
      res.bodyHandler( b -> {
        System.out.println(b.toString());
        aClient.getHealth( r -> {
          r.bodyHandler( bh -> {
            System.out.println(bh.toString());
          });
        });
      });
    });
    tClient.post(new TenantAttributes(), reply -> {
      reply.bodyHandler( body -> {
        System.out.println(body);
      });
      reply.statusCode();
    });
    aClient.getJstack( trace -> {
      trace.bodyHandler( content -> {
        System.out.println(content);
      });
    });
    aClient.getPostgresActiveSessions("postgres", reply -> {
      reply.bodyHandler( body -> {
        System.out.println(body.toString("UTF8"));
      });
    });
    aClient.getPostgresLoad("postgres", reply -> {
      reply.bodyHandler( body -> {
        System.out.println(body.toString("UTF8"));
      });
    });
    aClient.getPostgresTableAccessStats(reply -> {
      reply.bodyHandler( body -> {
        System.out.println(body.toString("UTF8"));
      });
    });
    aClient.getPostgresTableSize("postgres", reply -> {
      reply.bodyHandler( body -> {
        System.out.println(body.toString("UTF8"));
      });
    });
  }

}
