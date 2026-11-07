package co.appointment.shared.service.grcp;

import co.appointment.grpc.AuthServiceGrpc;
import co.appointment.grpc.GetUserByEmailRequest;
import co.appointment.grpc.GetUserByIdRequest;
import co.appointment.grpc.GetUserResponse;
import co.appointment.grpc.GetVerificationTokenRequest;
import co.appointment.grpc.GetVerificationTokenResponse;
import co.appointment.shared.record.UserSummary;
import co.appointment.shared.record.VerificationTokenSummary;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractGrpcAuthClient implements GrpcAuthClient {

    private final AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    @Override
    public UserSummary getUserByEmail(final String email) {
        GetUserByEmailRequest request =
                GetUserByEmailRequest.newBuilder().setEmail(email).build();
        return getUserSummary(authServiceBlockingStub.processUserByEmail(request));
    }

    @Override
    public VerificationTokenSummary getVerificationTokenByEmail(final String email) {
        GetVerificationTokenRequest request =
                GetVerificationTokenRequest.newBuilder().setEmail(email).build();

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
        GetUserByIdRequest request =
                GetUserByIdRequest.newBuilder().setId(id.toString()).build();
        return getUserSummary(authServiceBlockingStub.processUserById(request));
    }

    private UserSummary getUserSummary(final GetUserResponse response) {
        if (response == null) {
            return null;
        }
        return new UserSummary(UUID.fromString(response.getId()), response.getFullName(), response.getEmail());
    }
}
