package co.appointment.shared.service.grcp;

import co.appointment.grpc.AuthServiceGrpc;
import co.appointment.grpc.GetUserResponse;
import co.appointment.grpc.GetVerificationTokenResponse;
import co.appointment.grpc.ProcessVerificationTokenRequest;
import co.appointment.shared.record.UserSummary;
import co.appointment.shared.record.VerificationTokenSummary;
import com.google.protobuf.StringValue;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractGrpcAuthClient implements GrpcAuthClient {

    private final AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    @Override
    public UserSummary getUserByEmail(final String email) {
        return getUserSummary(authServiceBlockingStub.processUserByEmail(
                StringValue.newBuilder().setValue(email).build()));
    }

    @Override
    public VerificationTokenSummary getVerificationTokenByEmail(final String email, final String tokenType) {
        ProcessVerificationTokenRequest request = ProcessVerificationTokenRequest.newBuilder()
                .setEmail(email)
                .setTokenType(tokenType)
                .build();
        GetVerificationTokenResponse response = authServiceBlockingStub.processVerificationTokenByEmail(request);
        if (response == null) {
            return null;
        }

        return new VerificationTokenSummary(
                UUID.fromString(response.getId()),
                response.getToken(),
                response.getExpiryDate(),
                response.getTokenType());
    }

    public UserSummary getUserById(final UUID id) {
        return getUserSummary(authServiceBlockingStub.processUserById(
                StringValue.newBuilder().setValue(id.toString()).build()));
    }

    private UserSummary getUserSummary(final GetUserResponse response) {
        if (response == null) {
            return null;
        }
        return new UserSummary(UUID.fromString(response.getId()), response.getFullName(), response.getEmail());
    }
}
