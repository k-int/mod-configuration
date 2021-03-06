package org.folio.rest.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import org.folio.rest.resource.interfaces.PostDeployVerticle;
import org.folio.rest.security.AES;

/**
 * @author shale
 *
 */
public class InitConfigService implements PostDeployVerticle {

  @Override
  public void init(Vertx vertx, Context context, Handler<AsyncResult<Boolean>> handler) {

    System.out.println("Getting secret key to decode DB password.");
    //** hard code the secret key  - in production env - read from a secure place *//
    String secretKey = "b2+S+X4F/NFys/0jMaEG1A";
    int port = context.config().getInteger("http.port");
    //AES.setSecretKey(secretKey);
/*    AdminClient ac = new AdminClient("localhost", port, null);
    ac.postSetAESKey(secretKey, reply -> {
      if(reply.statusCode() == 204){
        handler.handle(io.vertx.core.Future.succeededFuture(true));
      }
      else{
        handler.handle(io.vertx.core.Future.failedFuture(reply.statusCode() + ", " + reply.statusMessage()));
      }
    });*/
    handler.handle(io.vertx.core.Future.succeededFuture(true));

  }
}

