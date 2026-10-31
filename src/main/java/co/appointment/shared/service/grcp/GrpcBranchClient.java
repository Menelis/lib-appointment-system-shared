package co.appointment.shared.service.grcp;

import co.appointment.shared.record.BranchSummary;
import java.util.UUID;

public interface GrpcBranchClient {
    /**
     * Get Branch details from Branch Service via gRPC protocol.
     *
     * @param id branch id
     * @return {@link BranchSummary}
     */
    BranchSummary getBranchById(UUID id);
}
