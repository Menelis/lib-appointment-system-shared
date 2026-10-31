package co.appointment.shared.service.grcp;

import co.appointment.grpc.Address;
import co.appointment.grpc.BranchServiceGrpc;
import co.appointment.grpc.GetBranchByIdRequest;
import co.appointment.grpc.GetBranchResponse;
import co.appointment.shared.record.BranchSummary;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractGrpcBranchClient implements GrpcBranchClient {

    private final BranchServiceGrpc.BranchServiceBlockingStub branchServiceBlockingStub;

    @Override
    public BranchSummary getBranchById(final UUID id) {
        GetBranchByIdRequest request =
                GetBranchByIdRequest.newBuilder().setId(id.toString()).build();
        GetBranchResponse response = branchServiceBlockingStub.processBranchById(request);

        if (response == null) {
            return null;
        }
        Address physicalAddress = response.getPhysicalAddress();
        return new BranchSummary(
                response.getName(),
                physicalAddress.getAddressLine1(),
                physicalAddress.getAddressLine2(),
                physicalAddress.getSuburb(),
                physicalAddress.getCity(),
                physicalAddress.getProvince(),
                physicalAddress.getPostalCode(),
                response.getEmailAddress(),
                response.getLandLine(),
                response.getFaxNumber());
    }
}
