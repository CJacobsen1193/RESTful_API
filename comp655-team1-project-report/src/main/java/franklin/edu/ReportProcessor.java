package franklin.edu;

import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class ReportProcessor {

    @Inject
    @Channel("orders-out")
    Emitter<UUID> orderEmitter;

    @Incoming("reports-in")
    @Transactional
    public void processReport(Report report) {
        report.persist();
        orderEmitter.send(report.order_id);
    }
}
