package co.appointment.shared.service.grcp;

import co.appointment.grpc.AppointmentServiceGrpc;
import co.appointment.grpc.GetAppointmentByReferenceNoRequest;
import co.appointment.grpc.GetAppointmentResponse;
import co.appointment.shared.record.AppointmentSummary;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractGrpcAppointmentClient implements GrpcAppointmentClient {

    private final AppointmentServiceGrpc.AppointmentServiceBlockingStub appointmentServiceBlockingStub;

    @Override
    public AppointmentSummary getAppointmentByRefNo(final String referenceNo) {
        GetAppointmentByReferenceNoRequest request = GetAppointmentByReferenceNoRequest.newBuilder()
                .setReferenceNo(referenceNo)
                .build();
        return getAppointmentSummary(appointmentServiceBlockingStub.processAppointmentByReferenceNo(request));
    }

    public AppointmentSummary getAppointmentSummary(final GetAppointmentResponse response) {

        if (response == null) {
            return null;
        }
        return new AppointmentSummary(
                UUID.fromString(response.getId()),
                UUID.fromString(response.getCustomerId()),
                UUID.fromString(response.getBranchId()),
                LocalDate.parse(response.getAppointmentDate()),
                response.getSlotStart(),
                response.getSlotEnd(),
                response.getDescription(),
                response.getReferenceNo(),
                response.getStatus(),
                response.getCancellationReason());
    }
}
