package co.appointment.shared.service.grcp;

import co.appointment.shared.record.AppointmentSummary;

public interface GrpcAppointmentClient {
    /**
     * Get appointment details by reference no.
     * @param referenceNo reference no
     * @return {@link AppointmentSummary}
     */
    AppointmentSummary getAppointmentByRefNo(String referenceNo);
}
