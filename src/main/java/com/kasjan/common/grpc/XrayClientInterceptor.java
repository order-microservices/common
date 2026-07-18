package com.kasjan.common.grpc;

import com.kasjan.common.MdcConstants;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import org.slf4j.MDC;

public class XrayClientInterceptor implements io.grpc.ClientInterceptor {
  private static final Metadata.Key<String> X_RAY_ID = Metadata.Key.of(
      MdcConstants.X_RAY_ID,
      Metadata.ASCII_STRING_MARSHALLER
  );

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method,
      CallOptions options,
      Channel next
  ) {
    return new ForwardingClientCall.SimpleForwardingClientCall<>(
        next.newCall(method, options)
    ) {
      @Override
      public void start(Listener<RespT> listener, Metadata headers) {
        final var value = MDC.get(MdcConstants.X_RAY_ID);
        if (value != null) {
          headers.put(X_RAY_ID, value);
        }
        super.start(listener, headers);
      }
    };
  }
}
