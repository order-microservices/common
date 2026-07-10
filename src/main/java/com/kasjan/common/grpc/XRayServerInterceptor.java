package com.kasjan.common.grpc;

import com.kasjan.common.Headers;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.slf4j.MDC;

public class XRayServerInterceptor implements ServerInterceptor {

  private static final Metadata.Key<String> X_RAY_ID = Metadata.Key.of(
      Headers.X_RAY_ID,
      Metadata.ASCII_STRING_MARSHALLER
  );

  @Override
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
      final ServerCall<ReqT, RespT> serverCall,
      final Metadata metadata,
      final ServerCallHandler<ReqT, RespT> serverCallHandler
  ) {
    final var xrayId = metadata.get(X_RAY_ID);
    if (xrayId != null) {
      MDC.put(Headers.X_RAY_ID, xrayId);
    }
    return serverCallHandler.startCall(serverCall, metadata);
  }
}
