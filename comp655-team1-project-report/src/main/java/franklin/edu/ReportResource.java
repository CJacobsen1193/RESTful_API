package franklin.edu;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/order")
public class ReportResource {

    @Path("/orders")
    @GET
    @APIResponses(value = { @APIResponse(responseCode = "200", description = "All orders returned"),
            @APIResponse(responseCode = "204", description = "No orders available") })
    public List<Report> getAllOrders() {
        return Report.listAll();
    }

    @Path("/{id}")
    @GET
    @APIResponses(value = { @APIResponse(responseCode = "200", description = "Order found and returned"),
            @APIResponse(responseCode = "204", description = "Order not found") })
    public Report getOrderById(@RestPath("id") Long id) {
        return Report.findById(id);
    }

    @Path("/{id}")
    @APIResponses(value = { @APIResponse(responseCode = "200", description = "Order deleted successfully"),
            @APIResponse(responseCode = "404", description = "No order with given ID") })
    @Transactional
    @DELETE
    public Response deleteStudent(@RestPath("id") Long id) {
        if (Report.findById(id) != null) {
            Report.deleteById(id);
            return Response.ok("Order deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}